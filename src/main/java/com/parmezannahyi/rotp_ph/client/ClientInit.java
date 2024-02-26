package com.parmezannahyi.rotp_ph.client;

import com.github.standobyte.jojo.client.particle.MeteoriteVirusParticle;
import com.github.standobyte.jojo.client.particle.custom.CustomParticlesHelper;
import com.github.standobyte.jojo.client.resources.CustomResources;
import com.parmezannahyi.rotp_ph.RotpPurpleHazeAddon;
import com.parmezannahyi.rotp_ph.client.render.entity.renderer.CapsuleProjectileRenderer;
import com.parmezannahyi.rotp_ph.client.render.entity.renderer.PurpleHazeCloudRenderer;
import com.parmezannahyi.rotp_ph.client.render.entity.renderer.PurpleHazeRenderer;
import com.parmezannahyi.rotp_ph.init.InitEntities;
import com.parmezannahyi.rotp_ph.init.InitStands;
import com.parmezannahyi.rotp_ph.init.InitParticles;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = RotpPurpleHazeAddon.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientInit {

    @SubscribeEvent
    public static void onFMLClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(
                InitStands. PURPLE_HAZE_STAND.getEntityType(), PurpleHazeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(InitEntities.CAPSULE_PROJECTILE.get(), CapsuleProjectileRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(InitEntities.PURPLE_HAZE_CLOUD.get(), PurpleHazeCloudRenderer::new);
    }
    @SubscribeEvent
    public static void onMcConstructor(ParticleFactoryRegisterEvent event) {
        Minecraft mc = Minecraft.getInstance();
        mc.particleEngine.register(InitParticles.PURPLE_HAZE_VIRUS.get(), MeteoriteVirusParticle.Factory::new);
        CustomParticlesHelper.saveSprites(mc);
        CustomResources.initCustomResourceManagers(mc);
    }
}
