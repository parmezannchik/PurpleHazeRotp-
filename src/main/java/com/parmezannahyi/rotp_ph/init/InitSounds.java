package com.parmezannahyi.rotp_ph.init;

import java.util.function.Supplier;

import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.util.mc.OstSoundList;
import com.parmezannahyi.rotp_ph.RotpPurpleHazeAddon;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, RotpPurpleHazeAddon.MOD_ID); // TODO sounds.json

    public static final RegistryObject<SoundEvent> EXAMPLE_STAND_SUMMON_VOICELINE = SOUNDS.register("example_stand_summon_voiceline",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "example_stand_summon_voiceline")));

    public static final Supplier<SoundEvent> PURPLE_HAZE_SUMMON_SOUND = ModSounds.STAND_SUMMON_DEFAULT;

    public static final Supplier<SoundEvent> PURPLE_HAZE_UNSUMMON_SOUND = ModSounds.STAND_UNSUMMON_DEFAULT;

    public static final Supplier<SoundEvent> PURPLE_HAZE_PUNCH_LIGHT = ModSounds.STAND_PUNCH_LIGHT;

    public static final Supplier<SoundEvent> PURPLE_HAZE_PUNCH_HEAVY = ModSounds.STAND_PUNCH_HEAVY;

    public static final Supplier<SoundEvent> PURPLE_HAZE_PUNCH_BARRAGE = ModSounds.STAND_PUNCH_LIGHT;



    public static final OstSoundList EXAMPLE_STAND_OST = new OstSoundList(
            new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "example_stand_ost"), SOUNDS);
}
