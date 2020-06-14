package com.rafaelsn.enchantmentsoplenty;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.rafaelsn.enchantmentsoplenty.EnchantmentsOPlenty.ObjectHolders.LEECH;
import static com.rafaelsn.enchantmentsoplenty.EnchantmentsOPlenty.SWORD;

@Mod.EventBusSubscriber(modid= EnchantmentsOPlenty.MODID)
public class LeechEnchantment extends Enchantment {
    public LeechEnchantment() {
        super(Rarity.RARE, SWORD, new EquipmentSlotType[]{
                EquipmentSlotType.MAINHAND
        });
        this.setRegistryName("leech");
    }

    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event) {
        if (event.getSource().getTrueSource() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
            int level = EnchantmentHelper.getEnchantmentLevel(LEECH, player.getHeldItemMainhand().getStack());
            if (level > 0) {
                float damage = event.getAmount();
                float healAmount = Math.min(0.5f, damage * level * 0.1f);
//                LOGGER.info("Heal for " + healAmount);
                player.heal(healAmount);
            }
        }
    }
}
