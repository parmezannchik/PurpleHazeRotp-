package com.parmezannahyi.rotp_ph.init;

import com.parmezannahyi.rotp_ph.RotpPurpleHazeAddon;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, RotpPurpleHazeAddon.MOD_ID);

    public static final RegistryObject<BasicParticleType> PURPLE_HAZE_VIRUS = PARTICLES.register("purple_haze_virus", () -> new BasicParticleType(false)); // lalala it goes around the world lalala
}

