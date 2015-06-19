package com.feelings.feelingsmod;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = FeelingsMod.MODID, version = FeelingsMod.VERSION)
public class FeelingsMod
{
	public static final String MODID = "feelings_feelingsmod";
	public static final String VERSION = "1.0";

	//Blocks
	public static Block feelingsStone;

	//Items
	public static Item feelingsDust;
	public static Item feelingsIngot;

	//Tools
	public static Item feelingsPickaxe;
	public static Item feelingsAxe;
	public static Item feelingsHoe;
	public static Item feelingsShovel;
	public static Item feelingsSword;

	//Armor
	public static Item feelingsHelmet;
	public static Item feelingsChest;
	public static Item feelingsLeggings;
	public static Item feelingsBoots;

	//Materials
	ToolMaterial feelingsium = EnumHelper.addToolMaterial("feelingsium", 3, 1000, 9.5F, 3.5F, 10);
	ArmorMaterial feelingsArmor = EnumHelper.addArmorMaterial("feelingsArmor", "feelingsArmor1", 20, new int[] { 3, 7, 6, 3 }, 30);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//Block init
		feelingsStone = new BlockFeelingsStone();

		//Item init
		feelingsDust = new ItemFeelingsGeneric("feelingsDust");
		feelingsIngot = new ItemFeelingsGeneric("feelingsIngot");

		//Tool init
		feelingsPickaxe = new ItemFeelingsPickaxe(feelingsium, "feelingsPickaxe");
		feelingsAxe = new ItemFeelingsAxe(feelingsium, "feelingsAxe");
		feelingsHoe = new ItemFeelingsHoe(feelingsium, "feelingsHoe");
		feelingsShovel = new ItemFeelingsShovel(feelingsium, "feelingsShovel");
		feelingsSword = new ItemFeelingsSword(feelingsium, "feelingsSword");

		//Armor init
		feelingsHelmet = new ItemFeelingsArmor(feelingsArmor, 0, "feelingsHelmet");
		feelingsChest = new ItemFeelingsArmor(feelingsArmor, 1, "feelingsChestplate");
		feelingsLeggings = new ItemFeelingsArmor(feelingsArmor, 2, "feelingsLeggings");
		feelingsBoots = new ItemFeelingsArmor(feelingsArmor, 3, "feelingsBoots");
	}

	// Put recipes here
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		if(event.getSide() == Side.CLIENT)
		{
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			
			//items
			renderHelper(feelingsDust, "feelingsDust", renderItem);
			renderHelper(feelingsIngot, "feelingsIngot", renderItem);
			renderHelper(feelingsPickaxe, "feelingsPickaxe", renderItem);
			renderHelper(feelingsAxe, "feelingsAxe", renderItem);
			renderHelper(feelingsHoe, "feelingsHoe", renderItem);
			renderHelper(feelingsShovel, "feelingsShovel", renderItem);
			renderHelper(feelingsSword, "feelingsSword", renderItem);
			renderHelper(feelingsHelmet, "feelingsHelmet", renderItem);
			renderHelper(feelingsChest, "feelingsChestplate", renderItem);
			renderHelper(feelingsLeggings, "feelingsLeggings", renderItem);
			renderHelper(feelingsBoots, "feelingsBoots", renderItem);
			
			//blocks
			renderHelper(Item.getItemFromBlock(feelingsStone), "feelingsStone", renderItem);
		}
	}
	
	private void renderHelper(Item item, String name, RenderItem render){
		render.getItemModelMesher().register(item, 0, new ModelResourceLocation(FeelingsMod.MODID + ":" + name, "inventory"));
	}
}