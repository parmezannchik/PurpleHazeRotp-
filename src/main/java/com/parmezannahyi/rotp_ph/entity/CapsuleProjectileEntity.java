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
        return 0;
    }

    @Override
    protected float getMaxHardnessBreakable() {
        return 0;
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
        PurpleHazeCloudEntity cloud = new PurpleHazeCloudEntity(level, 1);
        cloud.moveTo(blockRayTraceResult.getLocation());
        level.addFreshEntity(cloud);
        this.breakProjectile (TargetType.BLOCK, blockRayTraceResult);
    }
    @Override
    protected void afterEntityHit(EntityRayTraceResult entityRayTraceResult, boolean entityHurt) {
        if (entityRayTraceResult.getEntity() instanceof  LivingEntity){
            LivingEntity target = (LivingEntity)entityRayTraceResult.getEntity();
            PurpleHazeCloudEntity cloud = new PurpleHazeCloudEntity(level, 2);
            cloud.moveTo(target.getPosition(1));
            level.addFreshEntity(cloud);
            target.addEffect(new EffectInstance(InitEffects.PH_VIRUS.get(),240,2));
        }
    }
}
