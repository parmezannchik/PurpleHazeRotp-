package com.parmezannahyi.rotp_ph.client.render.entity.model;// Made with Blockbench 4.9.3

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.render.entity.model.stand.HumanoidStandModel;
import com.github.standobyte.jojo.client.render.entity.model.stand.bb.BlockbenchStandModelHelper;
import com.github.standobyte.jojo.client.render.entity.pose.IModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.RotationAngle;
import com.github.standobyte.jojo.client.render.entity.pose.anim.PosedActionAnimation;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity;

import net.minecraft.client.renderer.model.ModelRenderer;
import org.apache.commons.lang3.ObjectUtils;
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class PurpleHazeModel extends HumanoidStandModel<PurpleHazeEntity> {

	private final ModelRenderer head_r1;
	private final ModelRenderer eyeRight;
	private final ModelRenderer eyeLeft;
	private final ModelRenderer helmetPart;
	private final ModelRenderer head_r2;
	private final ModelRenderer torso_r1;
	private final ModelRenderer leftArm_r1;
	private final ModelRenderer rightArm_r1;




	public PurpleHazeModel() {
		addHumanoidBaseBoxes(null);

		texWidth = 128;
		texHeight = 128;


		head.setPos(0.0F, 0.0F, 0.0F);
		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.texOffs(20, 27).addBox(1.0F, -1.5F, -4.5F, 1.0F, 2.0F, 1.0F, -0.3F, false);
		head.texOffs(0, 27).addBox(-1.0F, -1.5F, -4.5F, 1.0F, 2.0F, 1.0F, -0.3F, false);
		head.texOffs(24, 0).addBox(0.0F, -1.5F, -4.5F, 1.0F, 2.0F, 1.0F, -0.3F, false);
		head.texOffs(42, 27).addBox(-2.0F, -1.5F, -4.5F, 1.0F, 2.0F, 1.0F, -0.3F, false);
		head.texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 3.0F, 8.0F, 0.11F, false);
		head.texOffs(24, 8).addBox(-1.5F, -9.0F, -4.0F, 3.0F, 1.0F, 8.0F, 0.1F, false);
		head.texOffs(62, 48).addBox(-2.0F, -2.25F, -5.75F, 4.0F, 2.0F, 1.0F, 0.1F, false);
		head.texOffs(62, 52).addBox(-0.5F, -0.25F, -5.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head_r1 = new ModelRenderer(this);
		head_r1.setPos(0.0F, 24.0F, 0.0F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, -0.1745F, 0.0F, 0.0F);
		head_r1.texOffs(54, 42).addBox(-3.0F, -29.8F, -10.25F, 6.0F, 5.0F, 1.0F, 0.1F, false);

		eyeRight = new ModelRenderer(this);
		eyeRight.setPos(0.0F, 24.0F, 0.0F);
		head.addChild(eyeRight);
		eyeRight.texOffs(63, 38).addBox(-2.25F, -28.0F, -4.25F, 1.0F, 1.0F, 1.0F, -0.2F, false);

		eyeLeft = new ModelRenderer(this);
		eyeLeft.setPos(0.0F, 0.0F, 0.0F);
		head.addChild(eyeLeft);
		eyeLeft.texOffs(67, 38).addBox(1.25F, -4.0F, -4.25F, 1.0F, 1.0F, 1.0F, -0.2F, false);

		helmetPart = new ModelRenderer(this);
		helmetPart.setPos(0.0F, -9.5F, 1.0F);
		head.addChild(helmetPart);
		

		head_r2 = new ModelRenderer(this);
		head_r2.setPos(0.0F, 0.0F, 0.0F);
		helmetPart.addChild(head_r2);
		setRotationAngle(head_r2, -0.3927F, 0.0F, 0.0F);
		head_r2.texOffs(22, 59).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, 0.1F, false);



		


		torso.setPos(0.0F, -12.0F, 0.0F);
		upperPart.addChild(torso);
		torso.texOffs(0, 27).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		torso.texOffs(44, 54).addBox(-2.5F, 4.0F, -2.3F, 5.0F, 6.0F, 1.0F, 0.0F, false);
		torso.texOffs(48, 23).addBox(-3.5F, 1.1F, -2.0F, 7.0F, 3.0F, 1.0F, 0.4F, false);
		torso.texOffs(24, 0).addBox(-4.0F, 9.0F, -2.0F, 8.0F, 3.0F, 4.0F, 0.1F, false);
		torso.texOffs(0, 5).addBox(-1.0F, 10.4F, -3.0F, 2.0F, 2.0F, 1.0F, 0.1F, false);

		torso_r1 = new ModelRenderer(this);
		torso_r1.setPos(0.0F, 24.0F, 0.0F);
		torso.addChild(torso_r1);
		setRotationAngle(torso_r1, 0.0436F, 0.0F, 0.0F);
		torso_r1.texOffs(24, 27).addBox(-4.0F, -24.3F, 2.6F, 8.0F, 15.0F, 1.0F, -0.3F, false);


		leftArm.setPos(6.0F, -10.0F, 0.0F);
		upperPart.addChild(leftArm);
		leftArm.texOffs(28, 49).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftArm.texOffs(28, 43).addBox(1.6F, 2.4F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		leftArm.texOffs(50, 37).addBox(-2.0F, 3.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.1F, false);

		leftArm_r1 = new ModelRenderer(this);
		leftArm_r1.setPos(-6.0F, 22.0F, 0.0F);
		leftArm.addChild(leftArm_r1);
		setRotationAngle(leftArm_r1, 0.0F, 0.0F, -0.0873F);
		leftArm_r1.texOffs(56, 50).addBox(9.5F, -24.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.01F, false);


		leftArmJoint.setPos(0.0F, 4.0F, 0.0F);
		leftArm.addChild(leftArmJoint);
		leftArmJoint.texOffs(10, 59).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);


		leftForeArm.setPos(0.0F, 4.0F, 0.0F);
		leftArm.addChild(leftForeArm);
		leftForeArm.texOffs(48, 13).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftForeArm.texOffs(30, 17).addBox(-1.0F, 0.0F, -2.3F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		leftForeArm.texOffs(4, 0).addBox(1.5F, 4.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.01F, false);
		leftForeArm.texOffs(4, 16).addBox(1.5F, 4.0F, 1.0F, 1.0F, 1.0F, 1.0F, -0.01F, false);
		leftForeArm.texOffs(24, 22).addBox(1.5F, 4.0F, -2.0F, 1.0F, 1.0F, 1.0F, -0.01F, false);


		rightArm.setPos(-6.0F, -10.0F, 0.0F);
		upperPart.addChild(rightArm);
		rightArm.texOffs(44, 3).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightArm.texOffs(12, 43).addBox(-2.6F, 2.4F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		rightArm.texOffs(44, 49).addBox(-2.0F, 3.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.1F, false);

		rightArm_r1 = new ModelRenderer(this);
		rightArm_r1.setPos(6.0F, 22.0F, 0.0F);
		rightArm.addChild(rightArm_r1);
		setRotationAngle(rightArm_r1, 0.0F, 0.0F, 0.0873F);
		rightArm_r1.texOffs(0, 58).addBox(-10.5F, -24.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.01F, false);


		rightArmJoint.setPos(0.0F, 4.0F, 0.0F);
		rightArm.addChild(rightArmJoint);
		rightArmJoint.texOffs(53, 58).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);


		rightForeArm.setPos(0.0F, 4.0F, 0.0F);
		rightArm.addChild(rightForeArm);
		rightForeArm.texOffs(16, 43).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightForeArm.texOffs(38, 12).addBox(-1.0F, 0.0F, -2.3F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		rightForeArm.texOffs(0, 43).addBox(-2.5F, 4.0F, -2.0F, 1.0F, 1.0F, 1.0F, -0.01F, false);
		rightForeArm.texOffs(28, 22).addBox(-2.5F, 4.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.01F, false);
		rightForeArm.texOffs(42, 37).addBox(-2.5F, 4.0F, 1.0F, 1.0F, 1.0F, 1.0F, -0.01F, false);


		leftLeg.setPos(1.9F, 12.0F, 0.0F);
		body.addChild(leftLeg);
		leftLeg.texOffs(0, 43).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftLeg.texOffs(0, 53).addBox(-2.0F, 5.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.1F, false);
		leftLeg.texOffs(0, 21).addBox(-1.0F, 4.4F, -2.6F, 2.0F, 2.0F, 1.0F, 0.0F, false);


		leftLegJoint.setPos(0.0F, 6.0F, 0.0F);
		leftLeg.addChild(leftLegJoint);
		leftLegJoint.texOffs(58, 27).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);


		leftLowerLeg.setPos(0.0F, 6.0F, 0.0F);
		leftLeg.addChild(leftLowerLeg);
		leftLowerLeg.texOffs(42, 27).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
		leftLowerLeg.texOffs(38, 7).addBox(1.3F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, -0.001F, false);
		leftLowerLeg.texOffs(24, 17).addBox(-1.2F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, -0.001F, false);


		rightLeg.setPos(-1.9F, 12.0F, 0.0F);
		body.addChild(rightLeg);
		rightLeg.texOffs(38, 39).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightLeg.texOffs(12, 54).addBox(-2.0F, 5.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.1F, false);
		rightLeg.texOffs(44, 0).addBox(-1.0F, 4.4F, -2.6F, 2.0F, 2.0F, 1.0F, 0.0F, false);


		rightLegJoint.setPos(0.0F, 6.0F, 0.0F);
		rightLeg.addChild(rightLegJoint);
		rightLegJoint.texOffs(56, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);


		rightLowerLeg.setPos(0.0F, 6.0F, 0.0F);
		rightLeg.addChild(rightLowerLeg);
		rightLowerLeg.texOffs(32, 17).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
		rightLowerLeg.texOffs(0, 16).addBox(-2.3F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, -0.001F, false);
		rightLowerLeg.texOffs(0, 0).addBox(1.3F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, -0.001F, false);
	}

	@Override // TODO summon poses
	protected RotationAngle[][] initSummonPoseRotations() {
		return new RotationAngle[][] {
				new RotationAngle[] {

				},
				new RotationAngle[] {

				}
		};
	}

	@Override
	protected void initActionPoses() { //
		actionAnim.put(StandPose.RANGED_ATTACK, new PosedActionAnimation.Builder<PurpleHazeEntity>()
				.addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<>(new RotationAngle[] {
						new RotationAngle(body, 0.0F, -0.48F, 0.0F),
						new RotationAngle(leftArm, 0.0F, 0.0F, -0.7854F),
						new RotationAngle(leftForeArm, 0.0F, 0.0F, 0.6109F),
						new RotationAngle(rightArm, -1.0908F, 0.0F, 1.5708F),
						new RotationAngle(rightForeArm, 0.0F, 0.0F, 0.0F)
				}))
				.build(idlePose));

		super.initActionPoses();
	}

	@Override
	public void prepareMobModel(PurpleHazeEntity entity, float walkAnimPos, float walkAnimSpeed, float partialTick) {
		super.prepareMobModel(entity, walkAnimPos, walkAnimSpeed, partialTick);

	}



	@Override // TODO idle pose
	protected ModelPose<PurpleHazeEntity> initIdlePose() {
		return super.initIdlePose();
	}

	@Override
	protected IModelPose<PurpleHazeEntity> initIdlePose2Loop() {
		return super.initIdlePose2Loop();
	}
}