package com.parmezannahyi.rotp_ph.client.render.entity.renderer;

import com.parmezannahyi.rotp_ph.entity.PurpleHazeCloudEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class PurpleHazeCloudRenderer extends EntityRenderer<PurpleHazeCloudEntity> {

    public PurpleHazeCloudRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    // the entity itself doesn't need to be rendered, so we override the render method to empty
    @Override
    public void render(PurpleHazeCloudEntity entity, float yRot, float partialTick,
                       MatrixStack matrixStack, IRenderTypeBuffer vertexBuilder, int packedLight) {
    }

    private static final ResourceLocation EMPTY = new ResourceLocation("empty");
    @Override
    public ResourceLocation getTextureLocation(PurpleHazeCloudEntity p_110775_1) {
        return EMPTY;
    }

}