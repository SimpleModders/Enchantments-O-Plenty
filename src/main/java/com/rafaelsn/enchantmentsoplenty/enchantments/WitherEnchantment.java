package com.rafaelsn.enchantmentsoplenty.enchantments;

import com.rafaelsn.enchantmentsoplenty.EnchantmentsOPlenty;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.common.Mod;

import static com.rafaelsn.enchantmentsoplenty.EnchantmentsOPlenty.SWORD;

@Mod.EventBusSubscriber(modid = EnchantmentsOPlenty.MODID)
public class WitherEnchantment extends Enchantment {
    public WitherEnchantment() {
        super(Rarity.RARE, SWORD, new EquipmentSlotType[]{
                EquipmentSlotType.MAINHAND
        });
        this.setRegistryName("wither");
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onEntityDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity) target;
            int ticks = 40 + user.getRNG().nextInt(20 * level);
            livingentity.addPotionEffect(new EffectInstance(Effects.WITHER, ticks, 1));
        }
    }

//    @SubscribeEvent
//    public static void onAttack(LivingHurtEvent event) {
//        if (event.getSource().getTrueSource() instanceof PlayerEntity) {
//            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
//            int level = EnchantmentHelper.getEnchantmentLevel(WITHER, player.getHeldItemMainhand().getStack());
//            if (level > 0) {
//                ((LivingEntity)event.getEntity()).addPotionEffect(new EffectInstance(Effects.WITHER, 20 * (2 + level), 1));
//            }
//        }
//    }
}
