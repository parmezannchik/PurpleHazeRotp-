package com.parmezannahyi.rotp_ph.actions.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity;
import net.minecraft.world.World;

public class PurpleHazeMadness extends StandEntityAction {
    public PurpleHazeMadness(StandEntityAction.Builder builder){
        super(builder);
    }
    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        PurpleHazeEntity purpleHaze = (PurpleHazeEntity) standEntity;
        purpleHaze.setMadOrNotWithAbility (!purpleHaze.isMadCauseOfAbility ());
    }
}
