package com.feelings.feelingsmod;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item parItem, CreativeTabs parTab, 
			List parListSubItems)
	{
		parListSubItems.add(new ItemStack(this, 1));
	}
	
	public String getName()
	{
		return name;	
	}
}