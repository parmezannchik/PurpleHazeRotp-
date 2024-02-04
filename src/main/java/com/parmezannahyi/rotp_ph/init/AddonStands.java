package com.parmezannahyi.rotp_ph.init;

import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject.EntityStandSupplier;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity;

public class AddonStands {

    public static final EntityStandSupplier<EntityStandType<StandStats>, StandEntityType<PurpleHazeEntity>>
            PURPLE_HAZE = new EntityStandSupplier<>(InitStands.PURPLE_HAZE_STAND);
}
