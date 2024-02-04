package com.parmezannahyi.rotp_ph.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.github.standobyte.jojo.action.ActionTarget.TargetType;
import com.github.standobyte.jojo.entity.damaging.projectile.ModdedProjectileEntity;
import com.github.standobyte.jojo.init.ModParticles;
import com.github.standobyte.jojo.util.general.MathUtil;
import com.parmezannahyi.rotp_ph.init.InitEffects;
import com.parmezannahyi.rotp_ph.init.InitEntities;

import com.parmezannahyi.rotp_ph.init.InitParticles;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potions;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.*;
import net.minecraft.util.math.RayTraceContext.FluidMode;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class CapsuleProjectileEntity extends ModdedProjectileEntity {

    public CapsuleProjectileEntity(EntityType<CapsuleProjectileEntity> type, World world) {
        super(type, world);
    }

    public CapsuleProjectileEntity(LivingEntity shooter, World world) {
        super(InitEntities.CAPSULE_PROJECTILE.get(), shooter, world);
    }


    @Override
    protected float getBaseDamage() {
        return 6;
    }

    @Override
    protected float getMaxHardnessBreakable() {
        return 100;
    }

    @Override
    public boolean standDamage() {
        return true;
    }

    @Override
    public int ticksLifespan() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected void onHitBlock(BlockRayTraceResult blockRayTraceResult){
        AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(this.level,this.getX(),this.getY(),this.getZ());
cloud.setParticle(InitParticles.PURPLE_HAZE_VIRUS.get());
        int level = 0; // 1 уровень эффекта
        cloud.addEffect(new EffectInstance(InitEffects.PH_VIRUS.get(), level, 1));
cloud.setDuration(240);
cloud.moveTo(this.getX(),this.getY(),this.getZ());
this.level.addFreshEntity(cloud);


    }
    @Override
    protected void afterEntityHit(EntityRayTraceResult entityRayTraceResult, boolean entityHurt) {
        AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(this.level,this.getX(),this.getY(),this.getZ());
        cloud.setParticle(InitParticles.PURPLE_HAZE_VIRUS.get());
        cloud.addEffect(new EffectInstance(InitEffects.PH_VIRUS.get()));
        cloud.setDuration(240);
        cloud.moveTo(this.getX(),this.getY(),this.getZ());
        this.level.addFreshEntity(cloud);
        LivingEntity target = (LivingEntity)entityRayTraceResult.getEntity();
    target.addEffect(new EffectInstance(InitEffects.PH_VIRUS.get(),240,2));
    }
}
