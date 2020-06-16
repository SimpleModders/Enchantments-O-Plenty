package com.rafaelsn.enchantmentsoplenty;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(EnchantmentsOPlenty.MODID)
public class EnchantmentsHolder {
    public static final Enchantment MIRROR = null;
    public static final Enchantment LEECH = null;

    private EnchantmentsHolder() {
        throw new IllegalStateException("Utility class");
    }
}
