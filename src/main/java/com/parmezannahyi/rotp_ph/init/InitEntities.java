package com.parmezannahyi.rotp_ph.init;

import com.parmezannahyi.rotp_ph.RotpPurpleHazeAddon;

import com.parmezannahyi.rotp_ph.client.render.entity.renderer.PurpleHazeRenderer;
import com.parmezannahyi.rotp_ph.entity.CapsuleProjectileEntity;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeCloudEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
            ForgeRegistries.ENTITIES, RotpPurpleHazeAddon.MOD_ID);
    public static void onFMLClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(InitStands.PURPLE_HAZE_STAND.getEntityType(), PurpleHazeRenderer::new);



    }
    public static final RegistryObject<EntityType<CapsuleProjectileEntity>> CAPSULE_PROJECTILE = ENTITIES.register("capsule_projectile",
            () -> EntityType.Builder.<CapsuleProjectileEntity>of(CapsuleProjectileEntity::new, EntityClassification.MISC)
                    .sized(0.75F, 0.75F)
                    .setUpdateInterval(10)
                    .build(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "capsule_projectile").toString()));
    public static final RegistryObject<EntityType<PurpleHazeCloudEntity>> PURPLE_HAZE_CLOUD = ENTITIES.register("purple_haze_cloud",
            () -> EntityType.Builder.<PurpleHazeCloudEntity>of(PurpleHazeCloudEntity::new, EntityClassification.MISC)
                    .sized(0.1F, 0.1F)
                    .fireImmune()
                    .build(new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "purple_haze_cloud").toString()));
}


