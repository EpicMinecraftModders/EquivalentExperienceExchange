package com.github.epicminecraftmodders.eee.items;

import com.github.epicminecraftmodders.eee.ModEEE;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;

public class ItemExperienceOrb extends Item {
	
	public final static String name = "eeeExperienceOrb";
	
	public ItemExperienceOrb() {
		this.setContainerItem(ModEEE.experienceOrb);
		this.setCreativeTab(ModEEE.eeeCreativeTab);
		this.setMaxDamage(1000);
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
	}
	
	public static void initBoth() {
		// Recipies for making the Orb
		GameRegistry.addRecipe(new ItemStack(ModEEE.experienceOrb, 1, 0),
				new Object[]{ "ABC", "ADC", "ABC",
					'A', Items.redstone,
					'B', ModEEE.experienceShard,
					'C', Items.glowstone_dust,
					'D', ModEEE.experienceDiamond});
		GameRegistry.addRecipe(new ItemStack(ModEEE.experienceOrb, 1, 0),
				new Object[]{ "ABC", "ADC", "ABC",
					'A', Items.glowstone_dust,
					'B', ModEEE.experienceShard,
					'C', Items.redstone,
					'D', ModEEE.experienceDiamond});
		GameRegistry.addRecipe(new ItemStack(ModEEE.experienceOrb, 1, 0),
				new Object[]{ "AAA", "BDB", "CCC",
					'A', Items.redstone,
					'B', ModEEE.experienceShard,
					'C', Items.glowstone_dust,
					'D', ModEEE.experienceDiamond});
		GameRegistry.addRecipe(new ItemStack(ModEEE.experienceOrb, 1, 0),
				new Object[]{ "AAA", "BDB", "CCC",
					'A', Items.glowstone_dust,
					'B', ModEEE.experienceShard,
					'C', Items.redstone,
					'D', ModEEE.experienceDiamond});
		
		// Recipies for alchemy
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 4),
				new ItemStack(ModEEE.experienceOrb, 1, OreDictionary.WILDCARD_VALUE),
				Blocks.iron_block);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 1),
				new ItemStack(ModEEE.experienceOrb, 1, OreDictionary.WILDCARD_VALUE),
				Blocks.gold_block,
				Blocks.gold_block);
	}
	
	public static void initClient() {
		for (int i = 0; i < 1001; i++) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
						ModEEE.experienceOrb, i,
							new ModelResourceLocation(ModEEE.MODID + ":" + ItemExperienceOrb.name, "inventory"));
		}
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		// TODO Auto-generated method stub
		return super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack stack,
			EntityPlayer playerIn, EntityLivingBase target) {
		System.out.println("Item Stats: D=" + stack.getItemDamage() + " M=" + stack.getMetadata());
		if (stack.getItemDamage() < 981 || playerIn.capabilities.isCreativeMode) {
			target.setFire(10);
			stack.setItemDamage(stack.getItemDamage() + 20);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return true;
	}
	
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		ItemStack temp = itemStack.copy();
		if (temp.getItemDamage() >= 980) {
			temp.stackSize = 0;
		} else {
			temp.setItemDamage(temp.getItemDamage() + 20);
		}
		return temp;
	}
}
