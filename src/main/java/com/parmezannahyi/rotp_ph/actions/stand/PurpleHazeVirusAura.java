package com.parmezannahyi.rotp_ph.actions.stand;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity;
import net.minecraft.world.World;

public class PurpleHazeVirusAura extends StandEntityAction {
    @Override
    protected ActionConditionResult checkStandConditions(StandEntity stand, IStandPower power, ActionTarget target) {
        PurpleHazeEntity purpleHaze = (PurpleHazeEntity) stand;
        if (purpleHaze.isMad()) {
            return conditionMessage("cant_control_stand");
        }
        if (purpleHaze.isCloseToUser ()){
            return conditionMessage("can_hurt_user");
        }
        return ActionConditionResult.POSITIVE;
    }

    public PurpleHazeVirusAura(StandEntityAction.Builder builder){
        super(builder);
    }

    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        PurpleHazeEntity purpleHaze = (PurpleHazeEntity) standEntity;
        purpleHaze.setAuraActive(!purpleHaze.hasAura());

    }
}
