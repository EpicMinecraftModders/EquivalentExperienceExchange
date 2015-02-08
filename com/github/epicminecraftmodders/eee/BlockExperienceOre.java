package com.github.epicminecraftmodders.eee;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockExperienceOre extends Block {
	
	public final static String name = "experienceOre";
	
	public BlockExperienceOre() {
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setUnlocalizedName(this.name);
		GameRegistry.registerBlock(this, this.name);
	}
	
}
