package com.parmezannahyi.rotp_ph.entity;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.ClientUtil;
import com.github.standobyte.jojo.client.StandController;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.parmezannahyi.rotp_ph.init.InitEffects;
import com.parmezannahyi.rotp_ph.init.InitStands;
import net.minecraft.client.Minecraft;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class PurpleHazeEntity extends StandEntity {
    private static final DataParameter<Integer> CAPSULES_COUNT = EntityDataManager.defineId(PurpleHazeEntity.class, DataSerializers.INT);
    public PurpleHazeEntity (StandEntityType<com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity> type, World world) {
        super (type, world);
    }
    boolean madness;
    boolean auraActive;
    public void setMadOrNot (boolean set) {
        this.madness = set;
    }
    public void setAuraActive (boolean set){this.auraActive = set;}

    public void retractWhenOver(){
        if (!this.isFollowingUser()) {
            this.setManualControl (false, false);
            this.retractStand (false);

        }
    }

    public boolean isMad () {
        return madness;
    }
    public boolean hasAura(){return auraActive;}

    float madnessBarrageTime = 0;

    protected void defineSynchedData () {
        super.defineSynchedData ();
        entityData.define(CAPSULES_COUNT, 6);
    }

    @Override
    public void onSyncedDataUpdated (DataParameter<?> dataParameter) {
        super.onSyncedDataUpdated (dataParameter);
    }


    private void moveToTarget (LivingEntity target) {
        ActionTarget actionTarget = new ActionTarget (target);
        this.setManualControl (true, true);
        Vector3d standPos = this.getPosition (1);
            Vector3d targetPos = new Vector3d (actionTarget.getTargetPos (false).x, actionTarget.getTargetPos (false).y, actionTarget.getTargetPos (false).z);
        this.setDeltaMovement ((targetPos.x () - standPos.x ()) / 10, (targetPos.y () - standPos.y ()) / 32, (targetPos.z () - standPos.z ()) / 10);
        this.lookAt (EntityAnchorArgument.Type.FEET, targetPos);
        this.lookAt (EntityAnchorArgument.Type.EYES, target.getEyePosition (1));
    }

    @Override
    public void tick () {
        super.tick ();
        LivingEntity user = this.getUser();
        if (this.isCloseToUser ()){
            this.setAuraActive (false);
        }
        if (user.isAlive() && user.hasEffect (ModStatusEffects.RESOLVE.get ())) {
            this.setMadOrNot(true);
            this.setAuraActive (false);
        }
        else {
            this.setMadOrNot (false);
        }
        if (this.hasAura ()){
                World world = this.level;
                world.addParticle (ParticleTypes.DRAGON_BREATH.getType(), this.getRandomX(1), this.getRandomY(), this.getRandomZ(1), 0, 0, 0);
                List<LivingEntity> targets = world.getEntitiesOfClass (LivingEntity.class, this.getBoundingBox ().inflate (2));
                for (LivingEntity target : targets){
                    if (!target.hasEffect (InitEffects.PH_VIRUS.get ())){}
                    target.addEffect (new EffectInstance (InitEffects.PH_VIRUS.get (), 100, 0));
            }
        }
        if (this.isMad () && this.getStaminaCondition () > 0) {
            List<Entity> entitiesAround = this.level.getEntities(this, user.getBoundingBox().inflate(this.getMaxRange ()), entity -> (entity instanceof LivingEntity && this.checkTargets (entity)));
            if (!entitiesAround.isEmpty ()) {
                entitiesAround.forEach(entity -> {
                    if (entity instanceof LivingEntity) {
                        LivingEntity livingTarget = (LivingEntity) entity;
                        if (livingTarget.getHealth () > 0) {
                            ActionTarget actionTarget = new ActionTarget (livingTarget);
                            StandEntityAction punch = InitStands.PURPLE_HAZE_PUNCH.get ();
                            StandEntityAction barrage = InitStands.PURPLE_HAZE_MADNESS_BARRAGE.get ();
                            StandEntityAction heavyPunch = InitStands.PURPLE_HAZE_HEAVY_PUNCH.get ();
                            this.moveToTarget (livingTarget);

                            if (this.getFinisherMeter ()> 0.3 && !this.isBeingRetracted ()) {
                                if (this.getCurrentTaskAction () != barrage){
                                    this.setTask (barrage, 60, StandEntityAction.Phase.PERFORM, actionTarget);
                                }
                                if (this.getFinisherMeter () > 0.7 && (livingTarget.getHealth ()/livingTarget.getMaxHealth ())<0.15){
                                    this.stopTask ();
                                    this.setTask (heavyPunch, heavyPunch.getStandActionTicks (this.getUserPower (), this), StandEntityAction.Phase.WINDUP, actionTarget);
                                    madnessBarrageTime = 0;
                                }
                            }
                            else {
                                this.setTask (punch, 10, StandEntityAction.Phase.PERFORM, actionTarget);
                            }
                        }
                    }
                });
            }
            this.retractWhenOver();
            Minecraft mc = Minecraft.getInstance ();
            if (StandController.getInstance ().isControllingStand () && ClientUtil.getCameraEntity () != mc.player){
                ClientUtil.setCameraEntityPreventShaderSwitch(mc, mc.player);
                ClientUtil.setOverlayMessage (new TranslationTextComponent ("jojo.message.action_condition.cant_control_stand"));
            }
        }

    }
    private boolean checkTargets(Entity entity){
        return entity.isAlive() && entity != this.getUser() && !entity.isAlliedTo(this.getUser());
    }
    public void useCapsule(){
        if (this.entityData.get (CAPSULES_COUNT) > 0){
            this.entityData.set (CAPSULES_COUNT, this.entityData.get (CAPSULES_COUNT)-1);
        }
    }
    public int getCapsuleCount(){
        return this.entityData.get (CAPSULES_COUNT);
    }

}

