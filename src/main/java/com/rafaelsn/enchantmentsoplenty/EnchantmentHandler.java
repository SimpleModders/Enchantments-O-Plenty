package com.rafaelsn.enchantmentsoplenty;

import com.rafaelsn.enchantmentsoplenty.enchantments.FlowerPathEnchantment;
import com.rafaelsn.enchantmentsoplenty.enchantments.LeechEnchantment;
import com.rafaelsn.enchantmentsoplenty.enchantments.MirrorEnchantment;
import com.rafaelsn.enchantmentsoplenty.enchantments.WitherEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class EnchantmentHandler {

    protected static final Set<Enchantment> enchants = new HashSet<>();

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        enchants.add(new MirrorEnchantment());
        enchants.add(new LeechEnchantment());
        enchants.add(new WitherEnchantment());
        enchants.add(new FlowerPathEnchantment());

        IForgeRegistry<Enchantment> r = event.getRegistry();

        for (Enchantment enchant : enchants)
            r.register(enchant);

        EnchantmentsOPlenty.LOGGER.info("Registered {} enchantments!", enchants.size());
    }

    private EnchantmentHandler() {
        throw new IllegalStateException("Utility class");
    }
}
