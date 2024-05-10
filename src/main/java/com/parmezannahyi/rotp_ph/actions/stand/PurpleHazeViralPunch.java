package com.parmezannahyi.rotp_ph.actions.stand;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.IHasStandPunch;
import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.punch.StandBlockPunch;
import com.github.standobyte.jojo.action.stand.punch.StandEntityPunch;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.mc.damage.StandEntityDamageSource;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeCloudEntity;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity;
import com.parmezannahyi.rotp_ph.init.InitEffects;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;

public class PurpleHazeViralPunch extends StandEntityHeavyAttack {
    @Override
    protected ActionConditionResult checkStandConditions(StandEntity stand, IStandPower power, ActionTarget target) {
        PurpleHazeEntity purpleHaze = (PurpleHazeEntity) stand;
        if (purpleHaze.isMad ()){
            return conditionMessage ("cant_control_stand");
        }
        return ActionConditionResult.POSITIVE;
    }
    public PurpleHazeViralPunch(StandEntityHeavyAttack.Builder builder){
        super(builder);
    }
    @Override
    public StandEntityPunch punchEntity(StandEntity stand, Entity target, StandEntityDamageSource dmgSource) {
        if (target instanceof LivingEntity){
            LivingEntity livingTarget = (LivingEntity) target;
            PurpleHazeEntity purpleHaze = (PurpleHazeEntity) stand;
            if (purpleHaze.getCapsuleCount () > 0){
                livingTarget.addEffect (new EffectInstance (InitEffects.PH_VIRUS.get (), 200, 0));
                purpleHaze.useCapsule ();
            }
        }
        return super.punchEntity(stand, target, dmgSource)
                .addKnockback(0.5F + stand.getLastHeavyFinisherValue())
                .disableBlocking((float) stand.getProximityRatio(target) - 0.25F);
    }
    @Override
    public StandBlockPunch punchBlock(StandEntity stand, BlockPos pos, BlockState state) {
        PurpleHazeCloudEntity cloud = new PurpleHazeCloudEntity (stand.level, 1);

        PurpleHazeEntity purpleHaze = (PurpleHazeEntity) stand;
        if (purpleHaze.getCapsuleCount () > 0){
            cloud.moveTo (pos, 1, 1);
            stand.level.addFreshEntity (cloud);
            purpleHaze.useCapsule ();
        }
        return super.punchBlock(stand, pos, state);

    }

}

