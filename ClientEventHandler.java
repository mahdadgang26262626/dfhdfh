package com.yourname.adminutility;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AdminUtility.MOD_ID, value = Dist.CLIENT)
public class ClientEventHandler {

    private static boolean wasPressed = false;

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent event) {
        if (event.getPhase() != ClientTickEvent.Phase.END) return;
        if (Minecraft.getInstance().player == null) return;

        // بررسی اینکه کلید تازه فشرده شده (نه نگه داشته شده)
        boolean isPressed = KeyBindings.toggleEspKey.isDown();
        if (isPressed && !wasPressed) {
            ESPRenderer.toggle(); // تغییر وضعیت
        }
        wasPressed = isPressed;
    }
}