package com.parmezannahyi.rotp_ph.actions.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PurpleHazeMadness extends StandEntityAction {
    public PurpleHazeMadness(StandEntityAction.Builder builder){
        super(builder);
    }
    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            PurpleHazeEntity purpleHaze = (PurpleHazeEntity) standEntity;
            purpleHaze.setMadOrNotWithAbility(!purpleHaze.isMadCauseOfAbility());
            if (!purpleHaze.isMadCauseOfAbility()){
                Entity cameraEntity = standEntity.isManuallyControlled() ? standEntity : userPower.getUser();
                Vector3d eyePos = cameraEntity.getEyePosition(1);
                AxisAlignedBB targetsBox = new AxisAlignedBB(eyePos, eyePos).inflate(32, 32, 32);
                List<Entity> potentialTargets = world.getEntities(purpleHaze, targetsBox,
                        entity -> (entity instanceof LivingEntity && purpleHaze.checkTargets(entity)));
                Vector3d lookVec = cameraEntity.getLookAngle();
                Optional<Entity> entityLookedAt = potentialTargets.stream().max(Comparator.comparingDouble(
                        entity -> {
                            Vector3d targetPos = entity.getBoundingBox().getCenter();
                            Vector3d vecToTarget = targetPos.subtract(eyePos).normalize();
                            double angleCos = lookVec.dot(vecToTarget);
                            return angleCos;
                        }));
                entityLookedAt.ifPresent(target -> purpleHaze.setAutoAttackTarget((LivingEntity) target));
            }
            else {
                purpleHaze.setAutoAttackTarget(null);
            }
        }
    }
}
