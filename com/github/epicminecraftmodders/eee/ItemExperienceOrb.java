package com.github.epicminecraftmodders.eee;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class ItemExperienceOrb extends Item {
	
	public final static String name = "eeeExperienceOrb";
	
	public ItemExperienceOrb() {
		this.setMaxDamage(1000);
		this.setMaxStackSize(1);
		this.setCreativeTab(ModEEE.eeeCreativeTab);
		this.setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
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
			if (!playerIn.capabilities.isCreativeMode)
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
}
