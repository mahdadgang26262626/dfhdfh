package com.yourname.adminutility;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AdminUtility.MOD_ID)
public class AdminUtility {
    public static final String MOD_ID = "adminutility";

    public AdminUtility() {
        // ثبت ایونت‌های عمومی
        MinecraftForge.EVENT_BUS.register(this);
        // ثبت KeyBindings از طریق Bus ماد
        FMLJavaModLoadingContext.get().getModEventBus().register(KeyBindings.class);
    }
}