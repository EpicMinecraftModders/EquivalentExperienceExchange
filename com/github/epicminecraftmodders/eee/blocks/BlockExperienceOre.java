package com.github.epicminecraftmodders.eee.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.epicminecraftmodders.eee.ModEEE;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockExperienceOre extends Block {
	
	public final static String name = "eeeExperienceOre";
	
	public BlockExperienceOre() {
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 3);
		this.setHardness(10f);
		this.setCreativeTab(ModEEE.eeeCreativeTab);
		this.setUnlocalizedName(this.name);
		GameRegistry.registerBlock(this, name);
	}
	
	public static void initClient() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
				Item.getItemFromBlock(ModEEE.experienceOre), 0,
					new ModelResourceLocation(ModEEE.MODID + ":" + name, "inventory"));
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModEEE.experienceShard;
	}

	@Override
	public int quantityDropped(Random random) {
		return 2 + random.nextInt(6);
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		return 3 + fortune + random.nextInt(9);
	}

	@Override
	public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune) {
		if (fortune == 0) {
			return 20;
		} else {
			return 20 * fortune;
		}
	}
}
