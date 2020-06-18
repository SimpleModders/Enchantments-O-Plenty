package com.rafaelsn.enchantmentsoplenty;

import com.rafaelsn.enchantmentsoplenty.enchantments.FlowerPathEnchantment;
import com.rafaelsn.enchantmentsoplenty.enchantments.LeechEnchantment;
import com.rafaelsn.enchantmentsoplenty.enchantments.MirrorEnchantment;
import com.rafaelsn.enchantmentsoplenty.enchantments.WitherEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.rafaelsn.enchantmentsoplenty.EnchantmentsOPlenty.MODID;

public class EnchantmentHandler {

    public static final DeferredRegister<Enchantment> ENCHANTS = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, MODID);

    public static final RegistryObject<Enchantment> MIRROR_ENCHANTMENT =
            ENCHANTS.register("mirror", MirrorEnchantment::new);

    public static final RegistryObject<Enchantment> LEECH_ENCHANTMENT =
            ENCHANTS.register("leech", LeechEnchantment::new);

    public static final RegistryObject<Enchantment> WITHER_ENCHANTMENT =
            ENCHANTS.register("wither", WitherEnchantment::new);

    public static final RegistryObject<Enchantment> FLOWER_PATH_ENCHANTMENT =
            ENCHANTS.register("flower_path", FlowerPathEnchantment::new);

    private EnchantmentHandler() {
        throw new IllegalStateException("Utility class");
    }
}
