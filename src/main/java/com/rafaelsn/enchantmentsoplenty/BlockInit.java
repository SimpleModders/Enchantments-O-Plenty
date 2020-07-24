package com.rafaelsn.enchantmentsoplenty;

import com.rafaelsn.enchantmentsoplenty.blocks.MagicTableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.rafaelsn.enchantmentsoplenty.EnchantmentsOPlenty.MODID;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> JAZZ_LEAVES = BLOCKS.register("jazz_leaves",
            MagicTableBlock::new);
}
