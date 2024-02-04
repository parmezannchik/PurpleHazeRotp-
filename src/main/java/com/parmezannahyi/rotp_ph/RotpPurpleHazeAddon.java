package com.parmezannahyi.rotp_ph;

import com.parmezannahyi.rotp_ph.init.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RotpPurpleHazeAddon.MOD_ID)
public class RotpPurpleHazeAddon {
    // The value here should match an entry in the META-INF/mods.toml file
    public static final String MOD_ID = "rotp_ph";
    private static final Logger LOGGER = LogManager.getLogger();

    public RotpPurpleHazeAddon() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        InitEntities.ENTITIES.register(modEventBus);
        InitSounds.SOUNDS.register(modEventBus);
        InitStands.ACTIONS.register(modEventBus);
        InitStands.STANDS.register(modEventBus);
        InitEffects.EFFECTS.register(modEventBus);
        InitParticles.PARTICLES.register((modEventBus));
    }


    public static Logger getLogger() {
        return LOGGER;
    }
}