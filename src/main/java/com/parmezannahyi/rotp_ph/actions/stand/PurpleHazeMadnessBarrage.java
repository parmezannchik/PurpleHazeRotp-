package com.parmezannahyi.rotp_ph.actions.stand;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityMeleeBarrage;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity;

public class PurpleHazeMadnessBarrage extends StandEntityMeleeBarrage {
    public PurpleHazeMadnessBarrage(Builder builder) {
        super(builder.heldWalkSpeed(1).standUserWalkSpeed(1));
    }

    @Override
    protected ActionConditionResult checkStandConditions(StandEntity stand, IStandPower power, ActionTarget target) {
        PurpleHazeEntity purpleHaze = (PurpleHazeEntity) stand;
        if (purpleHaze.isMad()) {
            return conditionMessage("cant_control_stand");
        }
        return ActionConditionResult.POSITIVE;
    }
}
