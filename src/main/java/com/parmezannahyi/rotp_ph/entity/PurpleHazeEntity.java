package com.parmezannahyi.rotp_ph.entity;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.parmezannahyi.rotp_ph.init.InitStands;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class PurpleHazeEntity extends StandEntity {
    private static final DataParameter<Integer> MADNESS_PUNCH_COUNTER = EntityDataManager.defineId(PurpleHazeEntity.class, DataSerializers.INT);

    public PurpleHazeEntity(StandEntityType<com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity> type, World world) {
        super(type, world);
    }
    public ArrayList<StandEntityTask> taskQueue;
    boolean madness;
    public void setMadOrNot(boolean set) {
        this.madness = set;
    }
    public void retractWhenOver(){
        if (!this.isFollowingUser()){
            this.stopTask();
            this.setManualControl(false, false);
            this.retractStand(false);
        }
    }
    public boolean isMad(){
        return madness;
    }
    float madnessTime = 0;
    public boolean isBarraging(){
        return this.getCurrentTaskAction() == InitStands.PURPLE_HAZE_MADNESS_BARRAGE.get();
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(MADNESS_PUNCH_COUNTER, 0);
    }

    @Override
    public void tick(){
        super.tick();
        LivingEntity user = this.getUser();
        if (user.isAlive() && user.getHealth() <= 2){
            this.setMadOrNot(true);
        }
        // im getting mad too
        if (this.isMad() && !user.isCrouching()){
            this.madnessTime ++;
            tickCount++;
            List<Entity> entitiesAround = this.level.getEntities(this, this.getBoundingBox().inflate(this.getMaxRange()), entity -> (entity instanceof LivingEntity));
            if (!entitiesAround.isEmpty()){
                entitiesAround.forEach(target -> {
                    if (target instanceof LivingEntity){
                        LivingEntity livingTarget = (LivingEntity) target;
                        ActionTarget actionTarget = new ActionTarget(livingTarget);
                        StandEntityAction punch = InitStands.PURPLE_HAZE_PUNCH.get();
                        StandEntityAction barrage = InitStands.PURPLE_HAZE_BARRAGE.get();
                        StandEntityAction heavyPunch = InitStands.PURPLE_HAZE_HEAVY_PUNCH.get();
                        if (livingTarget.isAlive() && livingTarget != user && !livingTarget.isAlliedTo(user)){
                            this.setManualControl(true, true);
                            Vector3d standPos = this.getPosition(1);
                            Vector3d targetPos = new Vector3d(actionTarget.getTargetPos(false).x, actionTarget.getTargetPos(false).y, actionTarget.getTargetPos(false).z);
                            if (this.getLastHurtMob() != livingTarget){ this.setDeltaMovement((targetPos.x() - standPos.x())/10, (targetPos.y() - standPos.y())/32, (targetPos.z() - standPos.z())/10); }
                            this.lookAt(EntityAnchorArgument.Type.FEET, targetPos);
                            this.lookAt(EntityAnchorArgument.Type.EYES, livingTarget.getEyePosition(1));
                            if (this.getFinisherMeter() >= 0.8F) {
                                this.stopTask();
                                this.setTask(heavyPunch, heavyPunch.getStandActionTicks(this.getUserPower(), this), StandEntityAction.Phase.WINDUP, actionTarget);
                            }
                            this.setTask(barrage, 80, StandEntityAction.Phase.PERFORM, actionTarget);
                        }
                        else {
                            this.retractWhenOver();
                        }
                    }
                });
            }
        }
    }
}

