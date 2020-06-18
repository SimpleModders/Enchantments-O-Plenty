package com.rafaelsn.enchantmentsoplenty.enchantments;

import com.rafaelsn.enchantmentsoplenty.EnchantmentsOPlenty;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.rafaelsn.enchantmentsoplenty.EnchantmentHandler.EXPLOSIVE_ENCHANTMENT;

@Mod.EventBusSubscriber(modid = EnchantmentsOPlenty.MODID)
public class ExplosiveEnchantment extends Enchantment {
    public ExplosiveEnchantment() {
        super(Rarity.RARE, EnchantmentType.BOW, new EquipmentSlotType[]{
                EquipmentSlotType.MAINHAND
        });
    }

    @SubscribeEvent
    public static void onProjectileHit(ProjectileImpactEvent event) {
        Entity arrow = event.getEntity();
        if (!(arrow instanceof AbstractArrowEntity)) return;
        RayTraceResult result = event.getRayTraceResult();
        if (!(result instanceof BlockRayTraceResult)) return;
        Entity shooter = ((AbstractArrowEntity) arrow).getShooter();
        if (!(shooter instanceof LivingEntity)) return;
        if (result.getType() == RayTraceResult.Type.MISS) return;
        LivingEntity playerEntity = (LivingEntity) ((AbstractArrowEntity) arrow).getShooter();
        if (playerEntity == null) return;
        int level = EnchantmentHelper.getEnchantmentLevel(EXPLOSIVE_ENCHANTMENT.get(), playerEntity.getHeldItemMainhand().getStack());
        if (level == 0) return;
        World world = arrow.world;
        if (!world.isRemote) {
            BlockPos pos = arrow.getPosition();
            if (!world.isAirBlock(pos)) return;
            Explosion.Mode explosionMode = Explosion.Mode.NONE;
            world.createExplosion(arrow, pos.getX(), pos.getY(), pos.getZ(), (float) 3, explosionMode);
            arrow.remove();
        }
    }
}
