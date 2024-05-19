package com.parmezannahyi.rotp_ph.init;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.action.stand.StandEntityBlock;
import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.StandEntityLightAttack;
import com.github.standobyte.jojo.action.stand.StandEntityMeleeBarrage;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.StandInstance.StandPart;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.parmezannahyi.rotp_ph.RotpPurpleHazeAddon;
import com.parmezannahyi.rotp_ph.actions.stand.*;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class InitStands {
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Action<?>> ACTIONS = DeferredRegister.create(
            (Class<Action<?>>) ((Class<?>) Action.class), RotpPurpleHazeAddon.MOD_ID);
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<StandType<?>> STANDS = DeferredRegister.create(
            (Class<StandType<?>>) ((Class<?>) StandType.class), RotpPurpleHazeAddon.MOD_ID);

    // ======================================== Purple Haze ========================================


    // Дядя Бит крутой...
public static final RegistryObject<StandEntityAction> PURPLE_HAZE_PUNCH = ACTIONS.register("purple_haze_punch",
            () -> new PurpleHazePunch(new StandEntityLightAttack.Builder()
                    .punchSound(InitSounds.PURPLE_HAZE_PUNCH_SOUND)
                    .standSound(InitSounds.PURPLE_HAZE_PUNCH_LIGHT)
                    .shout(InitSounds.PURPLE_HAZE_PUNCH_LIGHT_FUGO)));

    public static final RegistryObject<StandEntityAction> PURPLE_HAZE_BARRAGE = ACTIONS.register("purple_haze_barrage",
            () -> new PurpleHazeBarrage(new StandEntityMeleeBarrage.Builder()
                    .barrageHitSound(InitSounds.PURPLE_HAZE_PUNCH_SOUND)
                    .standSound(InitSounds.PURPLE_HAZE_PUNCH_BARRAGE)));

    public static final RegistryObject<StandEntityAction> PURPLE_HAZE_MADNESS_BARRAGE = ACTIONS.register("purple_haze_madness_barrage",
            () -> new PurpleHazeMadnessBarrage(new StandEntityMeleeBarrage.Builder()
                    .standUserWalkSpeed(1F)
                    .staminaCostTick(2F)
                    .barrageHitSound(InitSounds.PURPLE_HAZE_PUNCH_SOUND)
                    .standSound(InitSounds.PURPLE_HAZE_PUNCH_BARRAGE)));

    public static final RegistryObject<StandEntityHeavyAttack> PURPLE_HAZE_VIRAL_PUNCH = ACTIONS.register("purple_haze_viral_punch",
            () -> new PurpleHazeViralPunch(new StandEntityHeavyAttack.Builder()
                    .punchSound(InitSounds.PURPLE_HAZE_HEAVY_PUNCH_SOUND)
                    .shout(InitSounds.PURPLE_HAZE_PUNCH_FINISHER_FUGO)
                    .standSound(InitSounds.PURPLE_HAZE_PUNCH_FINISHER)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityHeavyAttack> PURPLE_HAZE_HEAVY_PUNCH = ACTIONS.register("purple_haze_heavy_punch",
            () -> new PurpleHazeHeavyPunch (new StandEntityHeavyAttack.Builder()
                    .shiftVariationOf(PURPLE_HAZE_PUNCH).shiftVariationOf(PURPLE_HAZE_BARRAGE)
                    .setFinisherVariation(PURPLE_HAZE_VIRAL_PUNCH)
                    .punchSound(InitSounds.PURPLE_HAZE_HEAVY_PUNCH_SOUND)
                    .standSound (InitSounds.PURPLE_HAZE_PUNCH_HEAVY)
                    .shout (InitSounds.PURPLE_HAZE_PUNCH_HEAVY_FUGO)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> PURPLE_HAZE_BLOCK = ACTIONS.register("purple_haze_block",
            () -> new PurpleHazeBlock ());

    public static final RegistryObject<StandEntityAction> PURPLE_HAZE_CAPSULE_SHOT = ACTIONS.register("purple_haze_capsule_shot",
            () -> new PurpleHazeCapsuleShot(new StandEntityAction.Builder()
                    .cooldown(20)
                    .resolveLevelToUnlock(1)
                    .shout(InitSounds.PURPLE_HAZE_CAPSULE_SHOT_FUGO)));
    
    public static final RegistryObject<StandEntityAction> PURPLE_HAZE_VIRUS_AURA = ACTIONS.register("purple_haze_virus_aura",
            () -> new PurpleHazeVirusAura (new StandEntityAction.Builder()
                    .resolveLevelToUnlock (2)
                    .cooldown(20)
                    .standSound(InitSounds.PURPLE_HAZE_AURA)
                    .shout(InitSounds.PURPLE_HAZE_AURA_FUGO)));

    public static final RegistryObject<StandEntityAction> PURPLE_HAZE_MADNESS = ACTIONS.register("purple_haze_madness",
            () -> new PurpleHazeMadness (new StandEntityAction.Builder()
                    .holdToFire(40, false)
                    .resolveLevelToUnlock(3)
                    .cooldown(400)
                    .standSound(InitSounds.PURPLE_HAZE_MADNESS)
                    .shout(InitSounds.PURPLE_HAZE_MADNESS_FUGO)));







    // ...then create the Stand type instance. Moves, stats, entity sizes, and a few other things are determined here.
    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<PurpleHazeEntity>> PURPLE_HAZE_STAND =
            new EntityStandRegistryObject<>("purple_haze",
                    STANDS,
                    () -> new EntityStandType.Builder<StandStats>()
                            .color(0x8f3fb1)
                            .storyPartName(ModStandsInit.PART_5_NAME)
                            .leftClickHotbar(
                                    PURPLE_HAZE_PUNCH.get(),
                                    PURPLE_HAZE_BARRAGE.get(),
                                    PURPLE_HAZE_CAPSULE_SHOT.get() //
                            )
                            .rightClickHotbar(
                                    PURPLE_HAZE_BLOCK.get(),
                                    PURPLE_HAZE_VIRUS_AURA.get ()

                            )
                            .defaultStats(StandStats.class, new StandStats.Builder()
                                    .tier(5)
                                    .power(14)
                                    .speed(12)
                                    .range(5, 10)
                                    .durability(3)
                                    .precision(4)
                                    .build())
                            .addSummonShout(InitSounds.PURPLE_HAZE_FUGO_SUMMON)
                            .addOst(InitSounds.PURPLE_HAZE_OST)
                            .build(),

                    InitEntities.ENTITIES,
                    () -> new StandEntityType<PurpleHazeEntity>(PurpleHazeEntity::new, 0.7F, 2.1F)
                            .summonSound(InitSounds.PURPLE_HAZE_SUMMON_SOUND)
                            .unsummonSound(InitSounds.PURPLE_HAZE_UNSUMMON_SOUND))
                    .withDefaultStandAttributes();



    // ======================================== ??? ========================================



}
