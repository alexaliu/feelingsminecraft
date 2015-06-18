package com.feelings.feelingsmod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = FeelingsMod.MODID, version = FeelingsMod.VERSION)
public class FeelingsMod
{
    public static final String MODID = "feelings_feelingsmod";
    public static final String VERSION = "1.0";
    
    public static Block FeelingsStone;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    	FeelingsStone = new BlockFeelingsStone();
    	
    	GameRegistry.registerBlock(FeelingsStone, ItemFeelingsStone.class, "FeelingsStone");
    	
    }
}