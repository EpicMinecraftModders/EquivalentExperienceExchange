package com.github.epicminecraftmodders.eee;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemExperienceShard extends Item {

	public final static String name = "experienceShard";
	
	public ItemExperienceShard() {
		this.setUnlocalizedName(this.name);
		this.setCreativeTab(ModEEE.eeeCreativeTab);
		GameRegistry.registerItem(this, name);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn,
			EntityPlayer playerIn) {
		System.out.println("ItemExperienceShard.onItemRightClick got called...");
		return null;
	}
	
	
}
