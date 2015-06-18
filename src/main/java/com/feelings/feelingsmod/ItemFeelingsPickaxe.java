package com.feelings.feelingsmod;

import net.minecraft.item.ItemPickaxe;

public class ItemFeelingsPickaxe extends ItemPickaxe 
{
	public ItemFeelingsPickaxe(ToolMaterial material, String name) 
	{
		super(material);
		setUnlocalizedName(FeelingsMod.MODID + "_" + name);
		setTextureName(FeelingsMod.MODID + ":" + name);
	}
}