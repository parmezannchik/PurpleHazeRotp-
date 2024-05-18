package com.parmezannahyi.rotp_ph.entity;

import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.parmezannahyi.rotp_ph.effects.PurpleHazeVirusEffect;
import com.parmezannahyi.rotp_ph.init.InitEntities;
import com.parmezannahyi.rotp_ph.init.InitParticles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class PurpleHazeCloudEntity extends Entity {

    private double livetime;
    private double spreadSpeed;

    public PurpleHazeCloudEntity(World world, double spreadSpeed) {
        super(InitEntities.PURPLE_HAZE_CLOUD.get(), world);
        this.spreadSpeed = spreadSpeed;
    }

    public PurpleHazeCloudEntity(EntityType<?> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        this.livetime++;
        Vector3d thisPos = position();
        Vector3d randomOffset = new Vector3d(
                (random.nextDouble() * (livetime / 20) - 0.5) * (random.nextDouble() - random.nextDouble()),
                random.nextDouble() * (livetime / 20) - 0.5,
                (random.nextDouble() * (livetime/ 20) - 0.5) * (random.nextDouble() - random.nextDouble()));
        Vector3d entityPosition = thisPos.add(randomOffset);
        level.getEntities(this, this.getBoundingBox().inflate(((livetime /20) - 0.5) * spreadSpeed), entity -> !(entity instanceof StandEntity)).forEach(target -> {
            if (target instanceof LivingEntity) {
                LivingEntity livingtarget = (LivingEntity)target;

                PurpleHazeVirusEffect.applyVirus(livingtarget , (int)Math.round(livetime / 80), (int)livetime / 2);
            }
        });
        for (int i = 0; i < 8; i++) {
            level.addParticle(InitParticles.PURPLE_HAZE_VIRUS.get(), entityPosition.x, entityPosition.y, entityPosition.z, 0, 0, 0);
        }
        if (this.livetime == 200){
            this.remove();
        }
    }

    @Override
    protected void defineSynchedData() {}

    @Override
    protected void readAdditionalSaveData(CompoundNBT compound) {
        compound.putInt("Age", (int)livetime);
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT compound) {
        livetime = compound.getInt("Age");
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}


