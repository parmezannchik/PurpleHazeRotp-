package com.parmezannahyi.rotp_ph.client.render.entity.renderer;

import com.github.standobyte.jojo.client.render.entity.renderer.SimpleEntityRenderer;
import com.parmezannahyi.rotp_ph.RotpPurpleHazeAddon;
import com.parmezannahyi.rotp_ph.client.render.entity.model.CapsuleProjectileModel;
import com.parmezannahyi.rotp_ph.entity.CapsuleProjectileEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class CapsuleProjectileRenderer extends SimpleEntityRenderer<CapsuleProjectileEntity, CapsuleProjectileModel> {

    public CapsuleProjectileRenderer(EntityRendererManager renderManager) {
        super(renderManager, new CapsuleProjectileModel(),
                new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "textures/entity/capsule_projectile.png"));
    }
}
