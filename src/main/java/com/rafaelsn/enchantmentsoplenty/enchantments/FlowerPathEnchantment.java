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

import static com.rafaelsn.enchantmentsoplenty.EnchantmentsHolder.FLOWER_PATH;

@Mod.EventBusSubscriber(modid= EnchantmentsOPlenty.MODID)
public class FlowerPathEnchantment extends Enchantment {
    public FlowerPathEnchantment() {
        super(Rarity.RARE, EnchantmentType.ARMOR_FEET, new EquipmentSlotType[]{
                EquipmentSlotType.FEET
        });
        this.setRegistryName("flower_path");
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @SubscribeEvent
    public static void onUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            int level = EnchantmentHelper.getMaxEnchantmentLevel(FLOWER_PATH, player);
            if (level > 0) {
                double posX = player.getPosX() + (player.getRNG().nextDouble() * 4) - 2;
                double posZ = player.getPosZ() + (player.getRNG().nextDouble() * 4) - 2;

                BlockPos playerLocation = new BlockPos(posX, player.getPosY() + player.getYOffset(), posZ);
                World world = player.getEntityWorld();
                BlockState state = world.getBlockState(playerLocation);
                Block block = state.getBlock();

                if (block instanceof GrassBlock) {

                    BlockPos possibleLocation = new BlockPos(playerLocation.getX(), playerLocation.getY() + 1, playerLocation.getZ());
                    BlockState possibleLocationState = world.getBlockState(possibleLocation);

                    if (possibleLocationState.getMaterial() == Material.AIR) {
                        if (player.getRNG().nextFloat() < (0.01 * level)) {
                            switch (player.getRNG().nextInt(12)) {
                                case 0:
                                    world.setBlockState(possibleLocation, Blocks.DANDELION.getDefaultState());
                                    break;
                                case 1:
                                    world.setBlockState(possibleLocation, Blocks.POPPY.getDefaultState());
                                    break;
                                case 2:
                                    world.setBlockState(possibleLocation, Blocks.BLUE_ORCHID.getDefaultState());
                                    break;
                                case 3:
                                    world.setBlockState(possibleLocation, Blocks.ALLIUM.getDefaultState());
                                    break;
                                case 4:
                                    world.setBlockState(possibleLocation, Blocks.AZURE_BLUET.getDefaultState());
                                    break;
                                case 5:
                                    world.setBlockState(possibleLocation, Blocks.RED_TULIP.getDefaultState());
                                    break;
                                case 6:
                                    world.setBlockState(possibleLocation, Blocks.ORANGE_TULIP.getDefaultState());
                                    break;
                                case 7:
                                    world.setBlockState(possibleLocation, Blocks.WHITE_TULIP.getDefaultState());
                                    break;
                                case 8:
                                    world.setBlockState(possibleLocation, Blocks.PINK_TULIP.getDefaultState());
                                    break;
                                case 9:
                                    world.setBlockState(possibleLocation, Blocks.OXEYE_DAISY.getDefaultState());
                                    break;
                                case 10:
                                    world.setBlockState(possibleLocation, Blocks.CORNFLOWER.getDefaultState());
                                    break;
                                case 11:
                                    world.setBlockState(possibleLocation, Blocks.LILY_OF_THE_VALLEY.getDefaultState());
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

}
