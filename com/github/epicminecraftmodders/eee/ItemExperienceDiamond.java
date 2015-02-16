package com.github.epicminecraftmodders.eee;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemExperienceDiamond extends Item {

	public static final String name = "eeeExperienceDiamond";
	
	public ItemExperienceDiamond() {
		this.setCreativeTab(ModEEE.eeeCreativeTab);
		this.setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
	}
	
}
