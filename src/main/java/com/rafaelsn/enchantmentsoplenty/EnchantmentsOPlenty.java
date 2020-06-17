package com.rafaelsn.enchantmentsoplenty;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.util.function.Predicate;

@Mod(EnchantmentsOPlenty.MODID)
public class EnchantmentsOPlenty
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "enchantmentsoplenty";

    public static final EnchantmentType SWORD = addEnchantment("sword", SwordItem.class::isInstance);
    public static final EnchantmentType FEET = addEnchantment("feet", ArmorItem.class::isInstance);

    public EnchantmentsOPlenty() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Nonnull
    public static EnchantmentType addEnchantment(String name, Predicate<Item> condition) {
        return EnchantmentType.create(name, condition);
    }
}
