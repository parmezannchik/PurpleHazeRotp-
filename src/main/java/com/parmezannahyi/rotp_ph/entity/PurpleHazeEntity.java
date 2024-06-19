package com.parmezannahyi.rotp_ph.entity;

import java.util.Comparator;
import java.util.List;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.StandUtil;
import com.github.standobyte.jojo.util.mc.MCUtil;
import com.parmezannahyi.rotp_ph.init.InitEffects;
import com.parmezannahyi.rotp_ph.init.InitStands;

import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class PurpleHazeEntity extends StandEntity {
    private static final DataParameter<Integer> CAPSULES_COUNT = EntityDataManager.defineId(PurpleHazeEntity.class, DataSerializers.INT);
    private static final DataParameter<Boolean> MAD_HAS_TARGET = EntityDataManager.defineId(PurpleHazeEntity.class, DataSerializers.BOOLEAN);
    public PurpleHazeEntity(StandEntityType<PurpleHazeEntity> type, World world) {
        super(type, world);
    }
    boolean madness;
    boolean madnessfromability;
    boolean auraActive;
    private LivingEntity autoAttackTarget = null;
    public void setMadOrNot(boolean set) {
        this.madness = set;
    }
    public void setMadOrNotWithAbility (boolean set) {
        this.madnessfromability = set;
        this.madness = set;
    }
    public void setAuraActive(boolean set) {
        this.auraActive = set;
    }

    public void retractWhenOver() {
        if (!this.isFollowingUser()) {
            entityData.set(MAD_HAS_TARGET, false);
            this.retractStand(false);
        }
    }

    public boolean isMad() {
        return madness;
    }
    public boolean isMadCauseOfAbility() {
        return madnessfromability && madness;
    }
    public boolean hasAura() {
        return auraActive;
    }

    float madnessBarrageTime = 0;
    public void setAutoAttackTarget(LivingEntity entity) {
        this.autoAttackTarget = entity;
        if (entity == null) {
            if (entityData.get(MAD_HAS_TARGET)) {
                this.retractStand(false);
            }
            entityData.set(MAD_HAS_TARGET, false);
        }
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(CAPSULES_COUNT, 6);
        entityData.define(MAD_HAS_TARGET, false);
    }
    @Override
    protected boolean setTask(StandEntityTask task) {
        if (!level.isClientSide() && (task == null || task.getAction() == InitStands.PURPLE_HAZE_MADNESS.get())) {
            setAutoAttackTarget(null);
        }
        return super.setTask(task);
    }

    @Override
    public void onSyncedDataUpdated(DataParameter<?> dataParameter) {
        super.onSyncedDataUpdated(dataParameter);
    }

    @Override
    public boolean isFollowingUser() {
        return !entityData.get(MAD_HAS_TARGET) && super.isFollowingUser();
    }

    private void moveToTarget(LivingEntity target) {
        entityData.set(MAD_HAS_TARGET, true);
        setStandFlag(StandFlag.BEING_RETRACTED, false);
        Vector3d standPos = this.position();
        Vector3d targetPos = target.position();
        Vector3d vecToTarget = targetPos.subtract(standPos);
        double distanceSqr = vecToTarget.lengthSqr();
        double minDistance = target.getBbWidth() + this.getBbWidth() + 1;
        if (distanceSqr < minDistance * minDistance) {
            targetPos = targetPos.subtract(vecToTarget.normalize().scale(minDistance));
            vecToTarget = targetPos.subtract(standPos);
        }
        this.setDeltaMovement(vecToTarget.x / 10, vecToTarget.y / 16, vecToTarget.z / 10);
        this.lookAt(EntityAnchorArgument.Type.EYES, target.getEyePosition(1));
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity user = this.getUser();
        World world = this.level;
        if (this.isCloseToUser()) {
            this.setAuraActive(false);
        }
        if (user != null && user.isAlive() && this.isMadCauseOfAbility ()) {
            this.setMadOrNotWithAbility (true);
            this.setAuraActive (false);
        }
        if (this.hasAura()) {
                world.addParticle(ParticleTypes.DRAGON_BREATH.getType(), this.getRandomX(1), this.getRandomY(), this.getRandomZ(1), 0, 0, 0);
                List<LivingEntity> targets = world.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(2));
                for (LivingEntity target : targets){
                    if (!target.hasEffect(InitEffects.PH_VIRUS.get())) {
                        target.addEffect(new EffectInstance(InitEffects.PH_VIRUS.get(), 100, 0));
                    }
            }
        }
        if (this.isMad()) {
            if (this.getCurrentTaskAction() == ModStandsInit.UNSUMMON_STAND_ENTITY.get() && user instanceof PlayerEntity){
                PlayerEntity player = (PlayerEntity) this.getUser();
                this.stopTask();
                player.displayClientMessage(new TranslationTextComponent("jojo.message.action_condition.cant_control_stand"), true);
            }
            LivingEntity livingTarget = null;
            
            Entity curTarget = getCurrentTask().map(StandEntityTask::getTarget).orElse(ActionTarget.EMPTY).getEntity();
            if (curTarget instanceof LivingEntity && curTarget.isAlive() && curTarget.distanceToSqr(user) < getMaxRange() * getMaxRange()) {
                livingTarget = (LivingEntity) curTarget;
            }
            else {
                List<Entity> entitiesAround = this.level.getEntities(this, user.getBoundingBox().inflate(this.getMaxRange()),
                        entity -> (entity instanceof LivingEntity && this.checkTargets(entity)));
                if (!entitiesAround.isEmpty()) {
                    Entity closestEntity = entitiesAround.stream()
                            .min(Comparator.comparingDouble(
                                    target -> target.distanceToSqr(this)))
                            .get();
                    // 6 строчками выше уже есть проверка на instanceof LivingEntity, когда мы берем лист всех сущностей вокруг, еще раз проверять не нужно
                    livingTarget = (LivingEntity) closestEntity; 
                }
            }
            
            if (livingTarget != null) {
                if (livingTarget.getHealth() > 0) {
                    ActionTarget actionTarget = new ActionTarget(livingTarget);
                    StandEntityAction punch = InitStands.PURPLE_HAZE_PUNCH.get();
                    StandEntityAction barrage = InitStands.PURPLE_HAZE_MADNESS_BARRAGE.get();
                    StandEntityAction heavyPunch = InitStands.PURPLE_HAZE_HEAVY_PUNCH.get();
                    this.moveToTarget(livingTarget);

                    if (this.getStaminaCondition() > 0.25) {
                        if (this.getFinisherMeter() > 0.3 && !this.isBeingRetracted() && !livingTarget.isDeadOrDying ()) {
                            if (this.getCurrentTaskAction() != barrage) {
                                this.setTask(barrage, 60, StandEntityAction.Phase.PERFORM, actionTarget);
                            }
                            if (this.getFinisherMeter() > 0.7 && (livingTarget.getHealth() / livingTarget.getMaxHealth())<  0.15){
                                this.stopTask();
                                this.setTask(heavyPunch, heavyPunch.getStandActionTicks(this.getUserPower(), this), StandEntityAction.Phase.WINDUP, actionTarget);
                                madnessBarrageTime = 0;
                            }
                        }
                        else {
                            this.setTask(punch, 10, StandEntityAction.Phase.PERFORM, actionTarget);
                        }
                    }
                }
                else if (livingTarget.isDeadOrDying () && livingTarget.getMaxHealth () >= 20){
                    this.getUser ().addEffect (new EffectInstance (ModStatusEffects.STAMINA_REGEN.get (), 100, 1));
                }
            }
            else {
                if (this.getCurrentTaskAction () != InitStands.PURPLE_HAZE_MADNESS_BARRAGE.get()){
                    this.stopTask ();
                    this.retractWhenOver();
                }
            }

            if (isManuallyControlled()) {
                if (user instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) getUser();
                    StandUtil.setManualControl(player, false, false);
                    player.displayClientMessage(new TranslationTextComponent("jojo.message.action_condition.cant_control_stand"), true);
                }
            }
        }

    }

    @Override
    public ActionTarget aimWithThisOrUser(double reachDistance, ActionTarget currentTarget) {
        ActionTarget target;
        if (currentTarget.getType() == ActionTarget.TargetType.ENTITY && isTargetInReach(currentTarget)) {
            target = currentTarget;
        }
        else {
            RayTraceResult aim = null;
            if (!isManuallyControlled()) {
                LivingEntity user = getUser();
                if (user != null) {
                    aim = precisionRayTrace(user, reachDistance);
                }
            }
            if (aim == null || autoAttackTarget != null) {
                aim = precisionRayTrace(this, reachDistance);
            }

            target = ActionTarget.fromRayTraceResult(aim);
        }

        if (target.getEntity() != this) {
            Vector3d targetPos = target.getTargetPos(true);
            if (targetPos != null) {
                MCUtil.rotateTowards(this, targetPos, (float) getAttackSpeed() / 16F * 18F);
            }
        }

        return target;
    }

    @Override
    public void defaultRotation() {
        if (entityData.get(MAD_HAS_TARGET)) {
            setYHeadRot(this.yRot);
        }
        else {
            super.defaultRotation();
        }
    }

    public boolean checkTargets(Entity entity){
        return entity != this.getUser() && !entity.isAlliedTo(this.getUser());
    }
    public void useCapsule(){
        if (this.entityData.get(CAPSULES_COUNT) > 0) {
            this.entityData.set(CAPSULES_COUNT, this.entityData.get(CAPSULES_COUNT)-  1);
        }
    }
    public int getCapsuleCount(){
        return this.entityData.get(CAPSULES_COUNT);
    }

}

