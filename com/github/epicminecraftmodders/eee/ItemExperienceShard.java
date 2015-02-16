package com.github.epicminecraftmodders.eee;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemExperienceShard extends Item {

	public final static String name = "eeeExperienceShard";
	
	public ItemExperienceShard() {
		this.setCreativeTab(ModEEE.eeeCreativeTab);
		this.setUnlocalizedName(this.name);
		GameRegistry.registerItem(this, name);
	}
}
