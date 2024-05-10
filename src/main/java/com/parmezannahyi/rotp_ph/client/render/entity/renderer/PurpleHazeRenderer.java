package com.parmezannahyi.rotp_ph.client.render.entity.renderer;

import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;
import com.parmezannahyi.rotp_ph.client.render.entity.model.PurpleHazeModel;
import com.parmezannahyi.rotp_ph.RotpPurpleHazeAddon;
import com.parmezannahyi.rotp_ph.entity.PurpleHazeEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.util.ResourceLocation;

public class PurpleHazeRenderer extends StandEntityRenderer<PurpleHazeEntity, PurpleHazeModel> {

    public PurpleHazeRenderer(EntityRendererManager renderManager) {
        super(renderManager, new PurpleHazeModel(),
                new ResourceLocation(RotpPurpleHazeAddon.MOD_ID, "textures/entity/stand/purple_haze.png"), 0);
    }
}
