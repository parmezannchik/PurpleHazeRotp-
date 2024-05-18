package com.parmezannahyi.rotp_ph.actions.stand;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.power.impl.stand.StandInstance;
import com.parmezannahyi.rotp_ph.entity.CapsuleProjectileEntity;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity;
import com.parmezannahyi.rotp_ph.init.InitEntities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class PurpleHazeCapsuleShot extends StandEntityAction {
    public static final StandPose SHOOT_RIGHT_HAND_CAPSULE = new StandPose("SHOOT_RIGHT_HAND_CAPSULE");
    public static final StandPose SHOOT_LEFT_HAND_CAPSULE = new StandPose("SHOOT_LEFT_HAND_CAPSULE");
    public PurpleHazeCapsuleShot(StandEntityAction.Builder builder) {
        super(builder.holdToFire(10, false));
    }

    @Override
    protected ActionConditionResult checkStandConditions(StandEntity stand, IStandPower power, ActionTarget target) {
        PurpleHazeEntity purpleHaze = (PurpleHazeEntity) stand;
        if (purpleHaze.getCapsuleCount() == 0) {
            return conditionMessage("no_capsules_to_shot");
        }
        if (purpleHaze.isMad()) {
            return conditionMessage("cant_control_stand");
        }
        return super.checkStandConditions(stand, power, target);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        PurpleHazeEntity purpleHaze = (PurpleHazeEntity)standEntity;
        if (!world.isClientSide()) {
            CapsuleProjectileEntity capsule = new CapsuleProjectileEntity(userPower.getUser(), world);
            capsule.setShootingPosOf(standEntity);
            standEntity.shootProjectile(capsule, 1.0F, 0.25F);
            purpleHaze.useCapsule();
        }
    }

    @Override
    public StandPose getStandPose(IStandPower standPower, StandEntity standEntity, StandEntityTask task) {
        PurpleHazeEntity purpleHaze = (PurpleHazeEntity) standEntity;
        if (purpleHaze.getCapsuleCount() > 3) {
            return SHOOT_LEFT_HAND_CAPSULE;
        }
        return SHOOT_RIGHT_HAND_CAPSULE;
    }
}
