package com.parmezannahyi.rotp_ph.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

public class PurpleHazeVirusEffect extends Effect {

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
        if (entity.getHealth() > 1.0F) {
            entity.hurt(DamageSource.MAGIC, 1.0F);
        }
    }
}
