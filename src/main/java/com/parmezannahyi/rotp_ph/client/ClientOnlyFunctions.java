package com.parmezannahyi.rotp_ph.client;

import com.github.standobyte.jojo.client.ClientUtil;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class ClientOnlyFunctions {
    
    public static void setCameraEntityPreventShaderSwitch(Entity entity) {
        Minecraft mc = Minecraft.getInstance();
        ClientUtil.setCameraEntityPreventShaderSwitch(mc, entity);
    }
}
