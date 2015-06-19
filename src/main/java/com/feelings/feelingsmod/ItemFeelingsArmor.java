package com.feelings.feelingsmod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry; 
import net.minecraft.creativetab.CreativeTabs;

public class ItemFeelingsArmor extends ItemArmor
{
	private final String name;
	public ItemFeelingsArmor(ArmorMaterial material, int armorType, String name)
	{
		super(material, 0, armorType);
		this.name = name;
		setUnlocalizedName(FeelingsMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(this, name);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) 
	{
		return FeelingsMod.MODID + ":models/armor/feelingsArmor" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if(itemStack.getItem().equals(FeelingsMod.feelingsHelmet) && player.isInWater())
		{
			player.setAir(20);
		}
	}
	
	public String getName()
	{
		return name;
	}
}