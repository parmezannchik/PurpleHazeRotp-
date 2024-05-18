package com.parmezannahyi.rotp_ph.effects;

import com.github.standobyte.jojo.potion.UncurableEffect;
import com.parmezannahyi.rotp_ph.init.InitEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;

public class PurpleHazeVirusEffect extends UncurableEffect {

    public PurpleHazeVirusEffect(int color) {
        super(EffectType.HARMFUL, color);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int level) {
        int j = 25 >> level;
        if (j > 0) {
            return duration % j == 0;
        } else {
            return true;
        }
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int level) {
        entity.hurt(DamageSource.MAGIC, level + 0.5F);
    }
    public static void applyVirus(LivingEntity entity, int level, int duration){
        // if (!entity.hasEffect(InitEffects.VIRUS_IMMUNE.get())){ //для Голда Екиспиренса
        BlockPos pos = new BlockPos(entity.getPosition(1));
        if (entity.level.isDay() && entity.level.canSeeSky(pos)){
            duration = duration / 2;
            level = Math.round((float) level/2);
        }
        entity.addEffect(new EffectInstance(InitEffects.PH_VIRUS.get(), duration, level));
    }
    //}
}

