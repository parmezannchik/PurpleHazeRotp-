package com.parmezannahyi.rotp_ph.init;

import com.parmezannahyi.rotp_ph.RotpPurpleHazeAddon;
import com.parmezannahyi.rotp_ph.effects.PurpleHazeVirusEffect;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEffects {

    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(
     ForgeRegistries.POTIONS, RotpPurpleHazeAddon.MOD_ID);

    // Arigato, Stando

    public static final RegistryObject<Effect> PH_VIRUS = EFFECTS.register("ph_virus", 
            () -> new PurpleHazeVirusEffect(0x883AAA));


}
