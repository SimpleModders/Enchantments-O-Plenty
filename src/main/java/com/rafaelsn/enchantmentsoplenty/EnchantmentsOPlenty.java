package com.rafaelsn.enchantmentsoplenty;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EnchantmentsOPlenty.MODID)
public class EnchantmentsOPlenty
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "enchantmentsoplenty";

    public EnchantmentsOPlenty() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EnchantmentHandler.ENCHANTS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

}
