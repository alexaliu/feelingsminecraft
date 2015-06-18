package com.feelings.feelingsmod;

import net.minecraft.item.ItemAxe;

public class ItemFeelingsAxe extends ItemAxe 
{
	public ItemFeelingsAxe(ToolMaterial material, String name) 
	{
		super(material);
		setUnlocalizedName(FeelingsMod.MODID + "_" + name);
	}
}