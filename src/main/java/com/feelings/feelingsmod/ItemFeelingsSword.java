package com.feelings.feelingsmod;

import net.minecraft.item.ItemSword;

public class ItemFeelingsSword extends ItemSword 
{
	public ItemFeelingsSword(ToolMaterial material, String name) 
	{
		super(material);
		setUnlocalizedName(FeelingsMod.MODID + "_" + name);
		setTextureName(FeelingsMod.MODID + ":" + name);
	}
}