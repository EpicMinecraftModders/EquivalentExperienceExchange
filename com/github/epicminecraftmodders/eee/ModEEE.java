package com.github.epicminecraftmodders.eee;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import com.github.derpmods.core.ModDerpMods;

@Mod(modid = ModEEE.MODID, version = ModEEE.VERSION, name = "EquivalentExperienceExchange")
public class ModEEE {

	public static final String MODID = "eee";
	public static final String VERSION = "0.1a";
	
	Block experienceOre;
	
	@EventHandler
	public void preinit(FMLInitializationEvent event) {
		
		experienceOre = new BlockExperienceOre();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		if (event.getSide().equals(Side.CLIENT)) {
			
			// Store this in a variable so we don't have such huge lines.
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(experienceOre), 0,
					new ModelResourceLocation(this.MODID + ":" + BlockExperienceOre.name, "inventory"));
		}
		
	}
}
