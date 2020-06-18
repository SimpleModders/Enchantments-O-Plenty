package com.rafaelsn.enchantmentsoplenty.enchantments;

import com.rafaelsn.enchantmentsoplenty.EnchantmentsOPlenty;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.rafaelsn.enchantmentsoplenty.EnchantmentHandler.LEECH_ENCHANTMENT;

@Mod.EventBusSubscriber(modid= EnchantmentsOPlenty.MODID)
public class LeechEnchantment extends Enchantment {
    public LeechEnchantment() {
        super(Rarity.RARE, EnchantmentType.WEAPON, new EquipmentSlotType[]{
                EquipmentSlotType.MAINHAND
        });
    }

    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event) {
        if (event.getSource().getTrueSource() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
            int level = EnchantmentHelper.getEnchantmentLevel(LEECH_ENCHANTMENT.get(), player.getHeldItemMainhand().getStack());
            if (level > 0) {
                float damage = event.getAmount();
                float healAmount = Math.max(0.5f, damage * level * 0.1f);
                player.heal(healAmount);
            }
        }
    }
}
