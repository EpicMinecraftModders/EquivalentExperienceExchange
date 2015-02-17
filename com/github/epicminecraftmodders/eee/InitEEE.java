package com.github.epicminecraftmodders.eee;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import com.github.epicminecraftmodders.eee.blocks.BlockExperienceOre;
import com.github.epicminecraftmodders.eee.items.ItemExperienceDiamond;
import com.github.epicminecraftmodders.eee.items.ItemExperienceOrb;
import com.github.epicminecraftmodders.eee.items.ItemExperienceShard;

public class InitEEE {
	
	public static void doInit(FMLInitializationEvent event) {
		// Do the inits for both:
		ItemExperienceDiamond.initBoth();
		ItemExperienceOrb.initBoth();
		
		if (event.getSide().equals(Side.CLIENT)) {
			
			// Do the init for clients
			BlockExperienceOre.initClient();
			ItemExperienceDiamond.initClient();
			ItemExperienceOrb.initClient();
			ItemExperienceShard.initClient();
		}
	}
}
