package com.feelings.feelingsmod;

import net.minecraft.item.ItemSpade;

public class ItemFeelingsShovel extends ItemSpade 
{
	public ItemFeelingsShovel(ToolMaterial material, String name) 
	{
		super(material);
		setUnlocalizedName(FeelingsMod.MODID + "_" + name);
		setTextureName(FeelingsMod.MODID + ":" + name);
	}
}