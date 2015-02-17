package com.github.epicminecraftmodders.eee.items;

import com.github.epicminecraftmodders.eee.ModEEE;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
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
	
	public static void initClient() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
				ModEEE.experienceShard, 0,
					new ModelResourceLocation(ModEEE.MODID + ":" + name, "inventory"));
	}
}
