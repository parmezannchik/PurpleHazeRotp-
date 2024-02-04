package com.parmezannahyi.rotp_ph.actions.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.parmezannahyi.rotp_ph.entity.CapsuleProjectileEntity;
import com.parmezannahyi.rotp_ph.init.InitEntities;
import net.minecraft.world.World;

public class PurpleHazeCapsuleShot extends StandEntityAction {

    public PurpleHazeCapsuleShot(StandEntityAction.Builder builder) {
        super(builder);
    }
    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            CapsuleProjectileEntity capsule = new CapsuleProjectileEntity(userPower.getUser(),world );
            standEntity.shootProjectile(capsule, 2.0F, 0.25F);
            // Пиу-Пах-Пиу
        }
    }
}
