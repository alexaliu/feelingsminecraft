package com.feelings.feelingsmod;

import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry; 
import net.minecraft.creativetab.CreativeTabs;

public class ItemFeelingsSword extends ItemSword 
{
	private final String name;
	public ItemFeelingsSword(ToolMaterial material, String name) 
	{
		super(material);
		this.name = name;
		setUnlocalizedName(FeelingsMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(this, name);
	}
	
	public String getName()
	{
		return name;
	}
}
