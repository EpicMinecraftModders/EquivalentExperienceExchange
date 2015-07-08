package com.github.epicminecraftmodders.eee.items;

import com.github.epicminecraftmodders.eee.ModEEE;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemExperienceDiamond extends Item {

	public static final String name = "eeeExperienceDiamond";
	
	public ItemExperienceDiamond() {
		this.setCreativeTab(ModEEE.eeeCreativeTab);
		this.setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
	}
	
	public static void initBoth() {
		// Do the recipies
		GameRegistry.addRecipe(new ItemStack(ModEEE.experienceDiamond, 1, 0),
				new Object[]{ "AAA", "ABA", "AAA",
					'A', ModEEE.experienceShard,
					'B', Items.diamond});
	}
	
	public static void initClient() {
		// Handle the render
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
				ModEEE.experienceDiamond, 0,
					new ModelResourceLocation(ModEEE.MODID + ":" + name, "inventory"));
	}
	
}
