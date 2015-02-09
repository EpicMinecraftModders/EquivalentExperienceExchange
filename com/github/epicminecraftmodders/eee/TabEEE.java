package com.github.epicminecraftmodders.eee;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabEEE extends CreativeTabs {

	public TabEEE(int index, String label) {
		super(index, label);
	}

	@Override
	public Item getTabIconItem() {
		return ModEEE.experienceShard;
	}

}
