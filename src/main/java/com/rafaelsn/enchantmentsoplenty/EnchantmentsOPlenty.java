package com.rafaelsn.enchantmentsoplenty;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EnchantmentsOPlenty.MODID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class EnchantmentsOPlenty
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "enchantmentsoplenty";

    public static Set<Enchantment> enchants = new HashSet<>();
    public static final ArrayList<Item> itemList = new ArrayList<>();

    public static final EnchantmentType PICKAXE = addEnchantment("pickaxe", PickaxeItem.class::isInstance);
    public static final EnchantmentType SWORD = addEnchantment("sword", SwordItem.class::isInstance);

    public EnchantmentsOPlenty() {
        MinecraftForge.EVENT_BUS.register(this);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Enchantment.class,this::registerEnchantments);
    }

    @SubscribeEvent
    public void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        enchants.add(new MirrorEnchantment());
        enchants.add(new LeechEnchantment());

        IForgeRegistry<Enchantment> r = event.getRegistry();

        for (Enchantment enchant : enchants)
            r.register(enchant);
        LOGGER.info("Registered "+enchants.size()+" enchantments!");

        setup();
    }

    @Nonnull
    public static EnchantmentType addEnchantment(String name, Predicate<Item> condition) {
        return EnchantmentType.create(name, condition);
    }

    public static void setup() {
        for (Item item : ForgeRegistries.ITEMS) {
            itemList.add(item);
        }
    }

    @ObjectHolder(MODID)
    public static class ObjectHolders {
        public static final Enchantment MIRROR = null;
        public static final Enchantment LEECH = null;
    }
}
