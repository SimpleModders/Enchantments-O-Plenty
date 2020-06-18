package com.rafaelsn.enchantmentsoplenty.enchantments;

import com.rafaelsn.enchantmentsoplenty.EnchantmentsOPlenty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.rafaelsn.enchantmentsoplenty.EnchantmentHandler.FLOWER_PATH_ENCHANTMENT;

@Mod.EventBusSubscriber(modid= EnchantmentsOPlenty.MODID)
public class FlowerPathEnchantment extends Enchantment {
    public FlowerPathEnchantment() {
        super(Rarity.RARE, EnchantmentType.ARMOR_FEET, new EquipmentSlotType[]{
                EquipmentSlotType.FEET
        });
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @SubscribeEvent
    public static void onUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            int level = EnchantmentHelper.getMaxEnchantmentLevel(FLOWER_PATH_ENCHANTMENT.get(), player);
            if (level > 0) {
                double posX = player.getPosX() + (player.getRNG().nextDouble() * 4) - 2;
                double posZ = player.getPosZ() + (player.getRNG().nextDouble() * 4) - 2;

                BlockPos groundBlockPos = new BlockPos(posX, player.getPosY() + player.getYOffset(), posZ);
                World world = player.getEntityWorld();
                BlockState groundState = world.getBlockState(groundBlockPos);
                Block groundBlock = groundState.getBlock();

                BlockPos aboveBlockPos = new BlockPos(groundBlockPos.getX(), groundBlockPos.getY() + 1, groundBlockPos.getZ());
                BlockState aboveBlockState = world.getBlockState(aboveBlockPos);

                if (validLocation(groundBlock, aboveBlockState)) {
                    if (player.getRNG().nextFloat() < (0.01 * level)) {
                        Block flower = getFlower(player.getRNG().nextInt(12));
                        world.setBlockState(aboveBlockPos, flower.getDefaultState());
                    }
                }
            }
        }
    }

    private static boolean validLocation(Block block, BlockState possibleLocationState) {
        return (block instanceof GrassBlock && possibleLocationState.getMaterial() == Material.AIR);
    }

    private static Block getFlower(int number) {
        Block[] data = {
                Blocks.DANDELION,
                Blocks.POPPY,
                Blocks.BLUE_ORCHID,
                Blocks.ALLIUM,
                Blocks.AZURE_BLUET,
                Blocks.RED_TULIP,
                Blocks.ORANGE_TULIP,
                Blocks.WHITE_TULIP,
                Blocks.PINK_TULIP,
                Blocks.OXEYE_DAISY,
                Blocks.CORNFLOWER,
                Blocks.LILY_OF_THE_VALLEY
        };
        return data[number];
    }

}
