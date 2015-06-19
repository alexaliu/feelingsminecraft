package com.feelings.feelingsmod;

import net.minecraft.item.ItemHoe;
import net.minecraftforge.fml.common.registry.GameRegistry; 
import net.minecraft.creativetab.CreativeTabs;

public class ItemFeelingsHoe extends ItemHoe 
{
	private final String name;
	public ItemFeelingsHoe(ToolMaterial material, String name) 
	{
		super(material);
		this.name = name;
		setUnlocalizedName(FeelingsMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(this, name);
	}
	
	public String getName()
	{
		return name;
	}
}