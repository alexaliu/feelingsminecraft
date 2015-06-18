package com.feelings.feelingsmod;

import net.minecraft.item.ItemHoe;

public class ItemFeelingsHoe extends ItemHoe 
{
	public ItemFeelingsHoe(ToolMaterial material, String name) 
	{
		super(material);
		setUnlocalizedName(FeelingsMod.MODID + "_" + name);
		setTextureName(FeelingsMod.MODID + ":" + name);
	}
}