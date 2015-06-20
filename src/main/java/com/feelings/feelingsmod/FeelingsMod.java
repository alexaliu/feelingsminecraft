package com.feelings.feelingsmod;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
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
		
		Item itemFeelingsStone = GameRegistry.findItem(FeelingsMod.MODID, "feelingsStone");
		ModelBakery.addVariantName(itemFeelingsStone, "feelingsOre", "feelingsStone", "smoothFeelingsStone"); 
//		ModelBakery.addVariantName(Item.getItemFromBlock(feelingsStone), "feelingsOre", "feelingsStone", "smoothFeelingsStone"); 
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// Code to render textures for items. Only do on Client side, will crash Server
		if(event.getSide() == Side.CLIENT)
		{			
			//items
			renderHelper(feelingsDust);
			renderHelper(feelingsIngot);
			renderHelper(feelingsPickaxe);
			renderHelper(feelingsAxe);
			renderHelper(feelingsHoe);
			renderHelper(feelingsShovel);
			renderHelper(feelingsSword);
			renderHelper(feelingsHelmet);
			renderHelper(feelingsChest);
			renderHelper(feelingsLeggings);
			renderHelper(feelingsBoots);
			
			//blocks
			Item itemFeelingsStone = GameRegistry.findItem(FeelingsMod.MODID, "feelingsStone");
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("feelings_feelingsmod:feelingsOre", "inventory");
		    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemFeelingsStone, BlockFeelingsStone.EnumType.ORE.getMetadata(), itemModelResourceLocation);

		    itemModelResourceLocation = new ModelResourceLocation("feelings_feelingsmod:feelingsStone", "inventory");
		    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemFeelingsStone, BlockFeelingsStone.EnumType.STONE.getMetadata(), itemModelResourceLocation);

		    itemModelResourceLocation = new ModelResourceLocation("feelings_feelingsmod:smoothFeelingsStone", "inventory");
		    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemFeelingsStone, BlockFeelingsStone.EnumType.SMOOTH.getMetadata(), itemModelResourceLocation);

//			renderHelper(feelingsStone);
		}
		
		// Recipes
		GameRegistry.addRecipe(new ItemStack(feelingsPickaxe),
				"AAA",
				" B ",
				" B ",
				'A', feelingsIngot, 'B', Items.stick);
		GameRegistry.addRecipe(new ItemStack(feelingsAxe),
				"AA ",
				"AB ",
				" B ",
				'A', feelingsIngot, 'B', Items.stick);
		GameRegistry.addRecipe(new ItemStack(feelingsHoe),
				"AA ",
				" B ",
				" B ",
				'A', feelingsIngot, 'B', Items.stick);
		GameRegistry.addRecipe(new ItemStack(feelingsShovel),
				" A ",
				" B ",
				" B ",
				'A', feelingsIngot, 'B', Items.stick);
		GameRegistry.addRecipe(new ItemStack(feelingsSword),
				" A ",
				" A ",
				" B ",
				'A', feelingsIngot, 'B', Items.stick);
		GameRegistry.addRecipe(new ItemStack(feelingsHelmet),
				"AAA",
				"A A",
				'A', feelingsIngot);
		GameRegistry.addRecipe(new ItemStack(feelingsChest),
				"A A",
				"AAA",
				"AAA",
				'A', feelingsIngot);
		GameRegistry.addRecipe(new ItemStack(feelingsLeggings),
				"AAA",
				"A A ",
				"A A",
				'A', feelingsIngot);
		GameRegistry.addRecipe(new ItemStack(feelingsBoots),
				"A A",
				"A A",
				'A', feelingsIngot);
	}
	
	private void renderHelper(Item item){
		// substring(26) because the unlocalized name includes the entire modID
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(item, 0, new ModelResourceLocation(FeelingsMod.MODID + 
					":" + item.getUnlocalizedName().substring(26), "inventory"));
	}
	
	private void renderHelper(Block block){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(FeelingsMod.MODID + 
				":" + block.getUnlocalizedName().substring(26), "inventory"));
	}
}