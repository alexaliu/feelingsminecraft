package com.feelings.feelingsmod;

import net.minecraft.item.ItemAxe;
import net.minecraftforge.fml.common.registry.GameRegistry; 
import net.minecraft.creativetab.CreativeTabs;

public class ItemFeelingsAxe extends ItemAxe
{
	private final String name;
	public ItemFeelingsAxe(ToolMaterial material, String name) 
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