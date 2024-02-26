
package com.parmezannahyi.rotp_ph.entity;


import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.parmezannahyi.rotp_ph.effects.PurpleHazeVirusEffect;
import com.parmezannahyi.rotp_ph.init.InitEffects;
import com.parmezannahyi.rotp_ph.init.InitEntities;

import com.parmezannahyi.rotp_ph.init.InitParticles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class PurpleHazeCloudEntity extends Entity {

    private int livetime;
    private LivingEntity user;

    public PurpleHazeCloudEntity(World world) {
        this(InitEntities.PURPLE_HAZE_CLOUD.get(), world);
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
                (random.nextDouble() * 16 - 0.5) * (random.nextDouble() - random.nextDouble()),
                random.nextDouble() * 16 - 0.5,
                (random.nextDouble() * 16 - 0.5) * (random.nextDouble() - random.nextDouble()));
        Vector3d entityPosition = thisPos.add(randomOffset);
        for (int i = 0; i < 8; i++) {
            level.addParticle(InitParticles.PURPLE_HAZE_VIRUS.get(), entityPosition.x, entityPosition.y, entityPosition.z, 0,  0, 0);
            level.getEntities(this, this.getBoundingBox().inflate(16), entity -> !(entity instanceof StandEntity)).forEach(target -> {
if(target instanceof LivingEntity){
    LivingEntity livingtarget=(LivingEntity)target;
    PurpleHazeVirusEffect.applyVirus(livingtarget ,0,livetime);
    //
}
            });
        }

        if (this.livetime==400){this.remove();} // ты што сука в лифте родился

    }

    public void setUser(LivingEntity user){
        this.user = user;
    }
    public LivingEntity getUser(){
        return user;
    }



    @Override
    protected void defineSynchedData() {}

    @Override
    protected void readAdditionalSaveData(CompoundNBT compound) {
        compound.putInt("Age", livetime);
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT compound) {
        livetime = compound.getInt("Age");
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }}


