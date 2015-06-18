package com.feelings.feelingsmod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
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
    
    //Blocks
    public static Block feelingsStone;
    
    //Items
    public static Item feelingsdust;
    public static Item feelingsingot;
    
    //Tools
    public static Item feelingspickaxe;
    public static Item feelingsaxe;
    public static Item feelingshoe;
    public static Item feelingsshovel;
    public static Item feelingssword;
    
    //Armor
    public static Item feelingshelmet;
    public static Item feelingschest;
    public static Item feelingsleggings;
    public static Item feelingsboots;
    
    //Materials
    ToolMaterial feelingsium = EnumHelper.addToolMaterial("feelingsium", 3, 1000, 9.5F, 3.5F, 10);
    ArmorMaterial feelingsarmor = EnumHelper.addArmorMaterial("feelingsarmor", 20, new int[] { 3, 7, 6, 3 }, 10);
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	//Block init
    	feelingsStone = new BlockFeelingsStone();
    	
    	//Block Registry
    	GameRegistry.registerBlock(feelingsStone, ItemFeelingsStone.class, "feelingsStone");
    	
    	//Item init
        feelingsdust = new ItemFeelingsGeneric("feelingsdust");
        feelingsingot = new ItemFeelingsGeneric("feelingsingot");
        
        //Tool init
        feelingspickaxe = new ItemFeelingsPickaxe(feelingsium, "feelingspickaxe");
        feelingsaxe = new ItemFeelingsAxe(feelingsium, "feelingsaxe");
        feelingshoe = new ItemFeelingsHoe(feelingsium, "feelingshoe");
        feelingsshovel = new ItemFeelingsShovel(feelingsium, "feelingsshovel");
        feelingssword = new ItemFeelingsSword(feelingsium, "feelingssword");
        
        //Armor init
        feelingshelmet = new ItemFeelingsArmor(feelingsarmor, 0, "feelingshelmet");
        feelingschest = new ItemFeelingsArmor(feelingsarmor, 1, "feelingschestplate");
        feelingsleggings = new ItemFeelingsArmor(feelingsarmor, 2, "feelingsleggings");
        feelingsboots = new ItemFeelingsArmor(feelingsarmor, 3, "feelingsboots");
    	
    	//Item Registry
        GameRegistry.registerItem(feelingsdust, "feelingsDust");
        GameRegistry.registerItem(feelingsingot, "feelingsIngot");
        
        //Tool Registry
        GameRegistry.registerItem(feelingspickaxe, "feelingsPickaxe");
        GameRegistry.registerItem(feelingsaxe, "feelingssAxe");
        GameRegistry.registerItem(feelingshoe, "feelingssHoe");
        GameRegistry.registerItem(feelingsshovel, "feelingssShovel");
        GameRegistry.registerItem(feelingssword, "feelingssSword");
        
        //Armor Registry
        GameRegistry.registerItem(feelingshelmet, "feelingssHelmet");
        GameRegistry.registerItem(feelingschest, "feelingssChest");
        GameRegistry.registerItem(feelingsleggings, "feelingssLeggings");
        GameRegistry.registerItem(feelingsboots, "feelingssBoots");

    }
}