package com.github.epicminecraftmodders.eee;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = ModEEE.MODID, version = ModEEE.VERSION, name = ModEEE.FULLNAME)
public class ModEEE {

	public static final String MODID = "eee";
	public static final String VERSION = "0.1a";
	public static final String FULLNAME = "EquivalentExperienceExchange";
	
	public static CreativeTabs eeeCreativeTab;
	
	public static Block experienceOre;
	
	public static Item experienceShard;
	
	@EventHandler
	public void preinit(FMLInitializationEvent event) {
		
		// Set the creative tab
		eeeCreativeTab = new TabEEE(CreativeTabs.getNextID(), this.FULLNAME);
		
		// Add the blocks
		experienceOre = new BlockExperienceOre();
		
		// Add the Items
		experienceShard = new ItemExperienceShard();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		
		
		if (event.getSide().equals(Side.CLIENT)) {
			
			// Store this in a variable so we don't have such huge lines.
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(experienceOre), 0,
					new ModelResourceLocation(this.MODID + ":" + BlockExperienceOre.name, "inventory"));
			renderItem.getItemModelMesher().register(experienceShard, 0,
					new ModelResourceLocation(this.MODID + ":" + ItemExperienceShard.name, "inventory"));
		}
		
	}
}
