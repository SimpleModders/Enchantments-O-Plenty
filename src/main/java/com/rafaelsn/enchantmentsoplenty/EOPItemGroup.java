package com.rafaelsn.enchantmentsoplenty;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class EOPItemGroup extends ItemGroup {
    public static final ItemGroup instance = new EOPItemGroup(ItemGroup.GROUPS.length, "enchantmentsoplenty");

    private EOPItemGroup(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Blocks.PUMPKIN);
    }

}
