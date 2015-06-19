package com.feelings.feelingsmod;

import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.common.registry.GameRegistry; 
import net.minecraft.creativetab.CreativeTabs;

public class ItemFeelingsPickaxe extends ItemPickaxe 
{
	private final String name;
	public ItemFeelingsPickaxe(ToolMaterial material, String name) 
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
