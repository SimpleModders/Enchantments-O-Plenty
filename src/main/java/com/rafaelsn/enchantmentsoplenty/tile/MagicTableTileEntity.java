package com.rafaelsn.enchantmentsoplenty.tile;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.INameable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;

public class MagicTableTileEntity extends TileEntity implements INameable {

    private ITextComponent customname;

    public MagicTableTileEntity() {
        // TODO
        super(TileEntityType.ENCHANTING_TABLE);
    }

    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (this.hasCustomName()) {
            compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customname));
        }

        return compound;
    }

    public void read(CompoundNBT compound) {
        super.read(compound);
        if (compound.contains("CustomName", 8)) {
            this.customname = ITextComponent.Serializer.fromJson(compound.getString("CustomName"));
        }

    }

    public ITextComponent getName() {
        return (ITextComponent)(this.customname != null ? this.customname : new TranslationTextComponent("container.enchant"));
    }

    public void setCustomName(@Nullable ITextComponent name) {
        this.customname = name;
    }

    @Nullable
    public ITextComponent getCustomName() {
        return this.customname;
    }
}
