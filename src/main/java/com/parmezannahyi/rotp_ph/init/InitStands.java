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
import com.parmezannahyi.rotp_ph.actions.stand.PurpleHazeCapsuleShot;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity;

import com.parmezannahyi.rotp_ph.init.InitEntities;
import com.parmezannahyi.rotp_ph.init.InitSounds;
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
    public static final RegistryObject<StandEntityAction> PURPLE_HAZE_PUNCH = ACTIONS.register("example_stand_punch",
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(InitSounds.PURPLE_HAZE_PUNCH_LIGHT)));

    public static final RegistryObject<StandEntityAction> PURPLE_HAZE_BARRAGE = ACTIONS.register("example_stand_barrage",
            () -> new StandEntityMeleeBarrage(new StandEntityMeleeBarrage.Builder()
                    .barrageHitSound(InitSounds.PURPLE_HAZE_PUNCH_BARRAGE)));

    public static final RegistryObject<StandEntityHeavyAttack> PURPLE_HAZE_FINISHER_PUNCH = ACTIONS.register("example_stand_finisher_punch",
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder() // TODO finisher ability
                    .punchSound(InitSounds.PURPLE_HAZE_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityHeavyAttack> PURPLE_HAZE_HEAVY_PUNCH = ACTIONS.register("example_stand_heavy_punch",
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder()
                    .shiftVariationOf(PURPLE_HAZE_PUNCH).shiftVariationOf(PURPLE_HAZE_BARRAGE)
                    .setFinisherVariation(PURPLE_HAZE_FINISHER_PUNCH)
                    .punchSound(InitSounds.PURPLE_HAZE_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> PURPLE_HAZE_BLOCK = ACTIONS.register("purple_haze_block",
            () -> new StandEntityBlock());

    public static final RegistryObject<StandEntityAction> PURPLE_HAZE_CAPSULE_SHOT = ACTIONS.register("purple_haze_capsule_shot",
            () -> new PurpleHazeCapsuleShot(new StandEntityAction.Builder()));






    // ...then create the Stand type instance. Moves, stats, entity sizes, and a few other things are determined here.
    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<PurpleHazeEntity>> PURPLE_HAZE_STAND =
            new EntityStandRegistryObject<>("example_stand",
                    STANDS,
                    () -> new EntityStandType.Builder<StandStats>()
                            .color(0x00AFAF)
                            .storyPartName(ModStandsInit.PART_5_NAME)
                            .leftClickHotbar(
                                    PURPLE_HAZE_PUNCH.get(),
                                    PURPLE_HAZE_BARRAGE.get(),
                                    PURPLE_HAZE_CAPSULE_SHOT.get() //
                            )
                            .rightClickHotbar(
                                    PURPLE_HAZE_BLOCK.get()

                            )
                            .defaultStats(StandStats.class, new StandStats.Builder()
                                    .tier(5)
                                    .power(14)
                                    .speed(12)
                                    .range(5, 5)
                                    .durability(3)
                                    .precision(4)
                                    .build())
                            .addSummonShout(InitSounds.EXAMPLE_STAND_SUMMON_VOICELINE)
                            .addOst(InitSounds.EXAMPLE_STAND_OST)
                            .build(),

                    InitEntities.ENTITIES,
                    () -> new StandEntityType<PurpleHazeEntity>(PurpleHazeEntity::new, 0.7F, 2.1F)
                            .summonSound(InitSounds.PURPLE_HAZE_SUMMON_SOUND)
                            .unsummonSound(InitSounds.PURPLE_HAZE_UNSUMMON_SOUND))
                    .withDefaultStandAttributes();



    // ======================================== ??? ========================================



}
