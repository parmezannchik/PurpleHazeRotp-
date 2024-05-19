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

public static final RegistryObject<SoundEvent> PURPLE_HAZE_FUGO_SUMMON = SOUNDS.register("ph_summon",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_summon")));

    public static final Supplier<SoundEvent> PURPLE_HAZE_SUMMON_SOUND = ModSounds.STAND_SUMMON_DEFAULT;

    public static final Supplier<SoundEvent> PURPLE_HAZE_UNSUMMON_SOUND =  ModSounds.STAND_UNSUMMON_DEFAULT;

    public static final Supplier<SoundEvent> PURPLE_HAZE_PUNCH_SOUND =  ModSounds.STAND_PUNCH_LIGHT;
    public static final Supplier<SoundEvent> PURPLE_HAZE_HEAVY_PUNCH_SOUND =  ModSounds.STAND_PUNCH_HEAVY;

    public static final Supplier<SoundEvent> PURPLE_HAZE_PUNCH_LIGHT = SOUNDS.register("ph_light_punch",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_light_punch")));
    public static final Supplier<SoundEvent> PURPLE_HAZE_PUNCH_LIGHT_FUGO = SOUNDS.register("ph_fugo_light_punch",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_light_punch")));

    public static final Supplier<SoundEvent> PURPLE_HAZE_PUNCH_HEAVY = SOUNDS.register("ph_heavy_punch",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_heavy_punch")));

    public static final Supplier<SoundEvent> PURPLE_HAZE_PUNCH_HEAVY_FUGO = SOUNDS.register("ph_fugo_heavy_punch",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_fugo_heavy_punch")));

    public static final Supplier<SoundEvent> PURPLE_HAZE_PUNCH_BARRAGE = SOUNDS.register("ph_barrage",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_barrage")));

    public static final Supplier<SoundEvent> PURPLE_HAZE_PUNCH_BARRAGE_FUGO = SOUNDS.register("ph_fugo_barrage",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_barrage")));

    public static final Supplier<SoundEvent> PURPLE_HAZE_PUNCH_FINISHER = SOUNDS.register("ph_finisher",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_finisher")));

    public static final Supplier<SoundEvent> PURPLE_HAZE_PUNCH_FINISHER_FUGO = SOUNDS.register("ph_fugo_finisher",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_fugo_finisher")));

    public static final Supplier<SoundEvent> PURPLE_HAZE_AURA = SOUNDS.register("ph_aura",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_aura")));

    public static final Supplier<SoundEvent> PURPLE_HAZE_AURA_FUGO = SOUNDS.register("ph_fugo_aura",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_fugo_aura")));

    public static final Supplier<SoundEvent> PURPLE_HAZE_MADNESS = SOUNDS.register("ph_madness",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_madness")));
    public static final Supplier<SoundEvent> PURPLE_HAZE_MADNESS_FUGO = SOUNDS.register("ph_fugo_madness",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_fugo_madness")));

    public static final Supplier<SoundEvent> PURPLE_HAZE_CAPSULE_SHOT_FUGO = SOUNDS.register("ph_fugo_capsule_shot",
            () -> new SoundEvent(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "ph_fugo_capsule_shot")));

    public static final OstSoundList PURPLE_HAZE_OST = new OstSoundList(
            new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "purple_haze_ost"), SOUNDS);
}
