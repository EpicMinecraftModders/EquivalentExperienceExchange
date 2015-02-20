package com.github.epicminecraftmodders.eee.blocks;

import java.util.List;

import com.github.epicminecraftmodders.eee.ModEEE;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockEEEOres extends Block {
	
	public static final String baseName = "eeeOres";
	public static final String[] subNames = new String[]{
		"eeeExperienceOre",
		"eeePinkOre",
		"eeePurpleOre"};
	
	public BlockEEEOres() {
		super(Material.rock);
		this.setUnlocalizedName(baseName);
		this.setCreativeTab(ModEEE.eeeCreativeTab);
		GameRegistry.registerBlock(this, baseName);
	}
	
	public static void initClient() {
		for (int i = 0; i < subNames.length; i++) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
					Item.getItemFromBlock(ModEEE.eeeOres), i, new ModelResourceLocation(
							ModEEE.MODID + ":" + subNames[i], "inventory"));
		}
	}

	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		for(int i = 0; i < subNames.length; i++) {
			list.add(new ItemStack(itemIn, 1, i));
		}
	}

	@Override
	public int damageDropped(IBlockState state) {
		 return this.getMetaFromState(state);
	}
	
	
}
