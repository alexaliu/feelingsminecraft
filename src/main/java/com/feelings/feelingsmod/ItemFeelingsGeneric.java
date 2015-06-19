package com.feelings.feelingsmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry; 

public class ItemFeelingsGeneric extends Item 
{ 
	private final String name;
	public ItemFeelingsGeneric(String name)
	{
		this.name = name;
		setUnlocalizedName(FeelingsMod.MODID + "_" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public String getName()
	{
		return name;	
	}
}