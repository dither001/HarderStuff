package com.draco18s.ores.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemDiamondStudAxe extends ItemAxe {

	public ItemDiamondStudAxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setUnlocalizedName("diamond_stud_axe");
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("ores:diamond_stud_axe");
    }

	@Override
	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem) {
		if(repairItem.getItemDamage() == 2) {
			return true;
		}
        return false;
    }
}
