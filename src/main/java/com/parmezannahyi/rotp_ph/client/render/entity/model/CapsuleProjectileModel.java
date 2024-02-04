package com.parmezannahyi.rotp_ph.client.render.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.parmezannahyi.rotp_ph.entity.CapsuleProjectileEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class CapsuleProjectileModel extends EntityModel<CapsuleProjectileEntity> {
	private final ModelRenderer capsule;

	public CapsuleProjectileModel() {
		texWidth = 16;
		texHeight = 16;

		capsule = new ModelRenderer(this);
		capsule.setPos(0.0F, 0.0F, 0.0F);
		capsule.texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, -0.01F, false);
	}

	@Override
	public void setupAnim(CapsuleProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		capsule.yRot = netHeadYaw * ((float)Math.PI / 180F);
		capsule.xRot = ageInTicks * 2F;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		capsule.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}