package com.github.epicminecraftmodders.eee;

import com.github.epicminecraftmodders.eee.blocks.BlockEEEOres;
import com.github.epicminecraftmodders.eee.blocks.BlockExperienceOre;
import com.github.epicminecraftmodders.eee.items.ItemExperienceDiamond;
import com.github.epicminecraftmodders.eee.items.ItemExperienceOrb;
import com.github.epicminecraftmodders.eee.items.ItemExperienceShard;

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
	public static Block eeeOres;
	
	public static Item experienceShard;
	public static Item experienceOrb;
	public static Item experienceDiamond;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		// Set the creative tab
		eeeCreativeTab = new TabEEE(CreativeTabs.getNextID(), "eee");
		
		// Add the blocks
		//experienceOre = new BlockExperienceOre();
		eeeOres = new BlockEEEOres();
		
		// Add the Items
		experienceShard = new ItemExperienceShard();
		experienceOrb = new ItemExperienceOrb();
		experienceDiamond = new ItemExperienceDiamond();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// The init is handled elsewhere
		InitEEE.doInit(event);
	}
}
