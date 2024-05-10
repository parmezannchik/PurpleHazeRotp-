package com.parmezannahyi.rotp_ph.client.render.entity.model;// Made with Blockbench 4.9.3

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.render.entity.model.stand.HumanoidStandModel;
import com.github.standobyte.jojo.client.render.entity.pose.IModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.RotationAngle;
import com.github.standobyte.jojo.client.render.entity.pose.anim.PosedActionAnimation;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.parmezannahyi.rotp_ph.actions.stand.PurpleHazeCapsuleShot;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity;
import com.parmezannahyi.rotp_ph.init.InitStands;
import net.minecraft.client.renderer.model.ModelRenderer;

// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class PurpleHazeModel extends HumanoidStandModel<PurpleHazeEntity> {

	private final ModelRenderer head_r1;
	private final ModelRenderer eyeRight;
	private final ModelRenderer eyeLeft;
	private final ModelRenderer helmetPart;
	private final ModelRenderer head_r2;
	private final ModelRenderer cape;
	private final ModelRenderer leftArm_r1;
	private final ModelRenderer rightArm_r1;
	private final ModelRenderer capsule1;
	private final ModelRenderer capsule2;
	private final ModelRenderer capsule3;
	private final ModelRenderer capsule4;
	private final ModelRenderer capsule5;
	private final ModelRenderer capsule6;




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

		cape = new ModelRenderer(this);
		cape.setPos(0.0F, 0.0F, 2.0F);
		torso.addChild(cape);
		setRotationAngle(cape, 0.0F, 0.0F, 0.0F);
		cape.texOffs(24, 27).addBox(-4.0F, -0.25F, -0.25F, 8.0F, 15.0F, 1.0F, -0.3F, false);


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

		capsule1 = new ModelRenderer(this);
		capsule1.setPos(0.0F, 0.0F, 0.0F);
		leftForeArm.addChild(capsule1);
		capsule1.texOffs(4, 16).addBox(1.5F, 4.0F, 1.0F, 1.0F, 1.0F, 1.0F, -0.01F, false);

		capsule2 = new ModelRenderer(this);
		capsule2.setPos(0.0F, 0.0F, 0.0F);
		leftForeArm.addChild(capsule2);
		capsule2.texOffs(4, 0).addBox(1.5F, 4.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.01F, false);

		capsule3 = new ModelRenderer(this);
		capsule3.setPos(0.0F, 0.0F, 0.0F);
		leftForeArm.addChild(capsule3);
		capsule3.texOffs(24, 22).addBox(1.5F, 4.0F, -2.0F, 1.0F, 1.0F, 1.0F, -0.01F, false);

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

		rightForeArm = new ModelRenderer(this);
		rightForeArm.setPos(0.0F, 4.0F, 0.0F);
		rightArm.addChild(rightForeArm);
		rightForeArm.texOffs(16, 43).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightForeArm.texOffs(38, 12).addBox(-1.0F, 0.0F, -2.3F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		capsule4 = new ModelRenderer(this);
		capsule4.setPos(0.0F, 0.0F, 0.0F);
		rightForeArm.addChild(capsule4);
		capsule4.texOffs(42, 37).addBox(-2.5F, 4.0F, 1.0F, 1.0F, 1.0F, 1.0F, -0.01F, false);

		capsule5 = new ModelRenderer(this);
		capsule5.setPos(0.0F, 0.0F, 0.0F);
		rightForeArm.addChild(capsule5);
		capsule5.texOffs(28, 22).addBox(-2.5F, 4.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.01F, false);

		capsule6 = new ModelRenderer(this);
		capsule6.setPos(0.0F, 0.0F, 0.0F);
		rightForeArm.addChild(capsule6);
		capsule6.texOffs(0, 43).addBox(-2.5F, 4.0F, -2.0F, 1.0F, 1.0F, 1.0F, -0.01F, false);

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
						new RotationAngle (body, 0.3927F, -0.3927F, 0.0F),
						new RotationAngle (head, 0.733F, -0.1745F, 0.2182F),
						new RotationAngle (cape, 0.3927F, 0.0F, 0.0F),
						new RotationAngle (leftArm, -0.3927F, 0.0F, 0.0F),
						new RotationAngle (rightArm, 0.0F, 0.0F, 0.3927F),
						new RotationAngle (rightForeArm, -0.6109F, -0.5236F, -0.6109F),
						new RotationAngle (leftLeg, -2.3562F, 0.0F, 0.0F),
						new RotationAngle (leftLegJoint, 1.0472F, 0.0F, 0.0F),
						new RotationAngle (leftLowerLeg, 1.9635F, 0.0F, 0.0F),
						new RotationAngle (rightLeg, -1.5708F, 0.0F, 0.0F),
						new RotationAngle (rightLegJoint, -0.7854F, 0.0F, 0.0F),
						new RotationAngle (rightLowerLeg, 1.5708F, 0.0F, 0.0F)
				},
				new RotationAngle[] {
						new RotationAngle (body, -0.3927F, 0.0F, 0.0F),
						new RotationAngle (upperPart, 0.0F, -0.3927F, 0.0F),
						new RotationAngle (cape, 0.0F, 45F, 0.0F),
						new RotationAngle (leftArm, -1.2139F, -0.2048F, -0.0757F),
						new RotationAngle (rightArm, -0.3927F, 0.0F, 0.0F),
						new RotationAngle (rightForeArm, -0.7854F, 0.0F, 0.0F),
						new RotationAngle (leftLeg, 0.0F, -0.3927F, 0.0F),
						new RotationAngle (leftLowerLeg, 0.3927F, 0.0F, 0.0F),
						new RotationAngle (rightLeg, -0.8571F, -0.3614F, 0.3876F),
						new RotationAngle (rightLegJoint, 0.7854F, 0.0F, 0.0F),
						new RotationAngle (rightLowerLeg, 1.5708F, 0.0F, 0.0F)
				}
		};
	}

	@Override
	protected void initActionPoses() {

		actionAnim.put(PurpleHazeCapsuleShot.SHOOT_RIGHT_HAND_CAPSULE, new PosedActionAnimation.Builder<PurpleHazeEntity>()
				.addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<>(new RotationAngle[] {
						new RotationAngle(rightArm, -1.1781F, 0.0F, 0.0F),
						new RotationAngle(rightForeArm, -1.5708F, -1.1781F, 1.5708F)
				}))
				.build(idlePose));
		actionAnim.put (PurpleHazeCapsuleShot.SHOOT_LEFT_HAND_CAPSULE, new PosedActionAnimation.Builder<PurpleHazeEntity> ()
				.addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<> (new RotationAngle []{
				new RotationAngle (leftArm, -1.1781F, 0.0F, 0.0F),
				new RotationAngle (leftForeArm, -1.5708F, 1.1781F, -1.5708F)
		})).build (idlePose));

		super.initActionPoses();
	}

	@Override
	public void prepareMobModel(PurpleHazeEntity entity, float walkAnimPos, float walkAnimSpeed, float partialTick) {
		super.prepareMobModel (entity, walkAnimPos, walkAnimSpeed, partialTick);
		if (entity.getCapsuleCount () <= 5) {
			this.capsule1.visible = false;
			if (entity.getCapsuleCount () <= 4){
				this.capsule2.visible = false;
				if (entity.getCapsuleCount () <= 3) {
					this.capsule3.visible = false;
					if (entity.getCapsuleCount () <= 2) {
						this.capsule4.visible = false;
						if (entity.getCapsuleCount () <= 1) {
							this.capsule5.visible = false;
							if (entity.getCapsuleCount () <= 0) {
								this.capsule6.visible = false;
							}
						}
					}
				}
			}
		}
		else {
			this.capsule1.visible = true;
			this.capsule2.visible = true;
			this.capsule3.visible = true;
			this.capsule4.visible = true;
			this.capsule5.visible = true;
			this.capsule6.visible = true;
		}
	}


	@Override // TODO idle pose
	protected ModelPose<PurpleHazeEntity> initIdlePose() {
		return new ModelPose<> (new RotationAngle []{
				new RotationAngle (leftArm, 0.0F, 0.3927F, 0.0F),
				new RotationAngle (leftForeArm, 0.0F, 0F, 0F),
				new RotationAngle (rightArm, 0.0F, -0.3927F, 0.0F),
				new RotationAngle (rightForeArm, 0.0F, 0F, 0F),
				new RotationAngle (leftLeg, -0.2182F, 0.0F, -0.0873F),
				new RotationAngle (leftLowerLeg, 0.3927F, 0.0F, 0.0F),
				new RotationAngle (rightLeg, -0.2182F, 0.0F, 0.0873F),
				new RotationAngle (rightLowerLeg, 0.3927F, 0.0F, 0.0F),
				new RotationAngle (body, 0F, 0.0F, 0.0F),
				new RotationAngle (upperPart, 0.0F, 0F, 0.0F),
				new RotationAngle (cape, 0.0F, 0F, 0.0F),
		});
	}

	@Override
	protected IModelPose<PurpleHazeEntity> initIdlePose2Loop() {
		return new ModelPose<> (new RotationAngle []{
				new RotationAngle (leftArm, -0.0436F, 0.3927F, 0.0F),
				new RotationAngle (rightArm, -0.0436F, -0.3927F, 0.0F)
		});
	}
}