package com.feelings.feelingsmod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFeelingsArmor extends ItemArmor
{
	public ItemFeelingsArmor(ArmorMaterial material, int armorType, String name)
	{
		super(material, 0, armorType);
		setUnlocalizedName(FeelingsMod.MODID + "_" + name);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) 
	{
		if (stack.getItem() == FeelingsMod.Feelingshelmet || stack.getItem() == FeelingsMod.Feelingschest || stack.getItem() == FeelingsMod.Feelingsboots) 
		{
			return FeelingsMod.MODID + ":models/armor/Feelingsarmor1.png";
		}
		else if(stack.getItem() == FeelingsMod.Feelingsleggings)
		{
			return FeelingsMod.MODID + ":models/armor/Feelingsarmor2.png";
		}
		else
		{
			System.out.println("Invalid Item");
			return null;
		}
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if(itemStack.getItem().getUnlocalizedName() == "Feelingshelmet")
		{
			if(player.isInWater())
			{
				player.setAir(20);
			}
		}
	}
}