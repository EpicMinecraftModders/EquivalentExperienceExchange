package com.github.epicminecraftmodders.eee;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = ModEEE.MODID, version = ModEEE.VERSION, name = ModEEE.FULLNAME)
public class ModEEE {

	public static final String MODID = "eee";
	public static final String VERSION = "0.1a";
	public static final String FULLNAME = "EquivalentExperienceExchange";
	
	public static CreativeTabs eeeCreativeTab;
	
	public static Block experienceOre;
	
	public static Item experienceShard;
	public static Item experienceOrb;
	public static Item experienceDiamond;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		
		// Set the creative tab
		eeeCreativeTab = new TabEEE(CreativeTabs.getNextID(), "eee");
		
		// Add the blocks
		experienceOre = new BlockExperienceOre();
		
		// Add the Items
		experienceShard = new ItemExperienceShard();
		experienceOrb = new ItemExperienceOrb();
		experienceDiamond = new ItemExperienceDiamond();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		// Register the recipes
		GameRegistry.addRecipe(new ItemStack(experienceDiamond, 1, 0),
				new Object[]{ "AAA", "ABA", "AAA",
					'A', experienceShard,
					'B', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(experienceOrb, 1, 1000),
				new Object[]{ "ABC", "ADC", "ABC",
					'A', Items.redstone,
					'B', experienceShard,
					'C', Items.glowstone_dust,
					'D', experienceDiamond});
		GameRegistry.addRecipe(new ItemStack(experienceOrb, 1, 1000),
				new Object[]{ "AAA", "BDB", "CCC",
					'A', Items.redstone,
					'B', experienceShard,
					'C', Items.glowstone_dust,
					'D', experienceDiamond});
		GameRegistry.addRecipe(new ItemStack(experienceOrb, 1, 0),
				new Object[]{ "AAA", "ABA", "AAA",
					'A', experienceShard,
					'B', new ItemStack(experienceOrb, 1, OreDictionary.WILDCARD_VALUE)});
		
		if (event.getSide().equals(Side.CLIENT)) {
			
			// Store this in a variable so we don't have such huge lines.
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			
			// Experience Ore Item Renderer
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(experienceOre), 0,
					new ModelResourceLocation(this.MODID + ":" + BlockExperienceOre.name, "inventory"));
			
			// Experience Shard Item Renderer
			renderItem.getItemModelMesher().register(experienceShard, 0,
					new ModelResourceLocation(this.MODID + ":" + ItemExperienceShard.name, "inventory"));
			
			// Experience Diamond Renderer
			renderItem.getItemModelMesher().register(experienceDiamond, 0,
					new ModelResourceLocation(this.MODID + ":" + ItemExperienceDiamond.name, "inventory"));
			
			// Experience Orb Item Renderer
			for (int i = 0; i < 1001; i++) {
				renderItem.getItemModelMesher().register(experienceOrb, i,
						new ModelResourceLocation(this.MODID + ":" + ItemExperienceOrb.name, "inventory"));
			}
		}
		
	}
}
