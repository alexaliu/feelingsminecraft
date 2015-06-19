package com.feelings.feelingsmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockFeelingsStone extends Block 
{
	private final String name = "feelingsStone";
	
//	@SideOnly(Side.CLIENT)
//	private IIcon[] icons;
	
	public BlockFeelingsStone()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(FeelingsMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setResistance(5F);
		setStepSound(soundTypeStone);
		setHarvestLevel("pickaxe", 2);
	}
	
//	@Override
//	@SideOnly(Side.CLIENT)
//	public void registerBlockIcons(IIconRegister par1IconRegister)
//	{
//		icons = new IIcon[3];
//
//		for (int i = 0; i < icons.length; i++)
//		{
//			icons[i] = par1IconRegister.registerIcon(FeelingsMod.MODID + ":" + name + i);
//		}
//	}
//	
//	@Override
//	@SideOnly(Side.CLIENT)
//	public IIcon getIcon(int par1, int par2)
//	{
//		switch(par2)
//		{
//		case 0:
//			return icons[0];
//		case 1:
//			if(ForgeDirection.getOrientation(par1) == ForgeDirection.UP || ForgeDirection.getOrientation(par1) == ForgeDirection.DOWN)
//				return icons[2];
//			else
//				return icons[1];
//		default:
//			System.out.println("Problems with getting the icon for BlockFeelingsStone");
//			return null;
//		}
//	}
//	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@SideOnly(Side.CLIENT)
//	@Override
//	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
//	{
//		for (int var4 = 0; var4 < 2; ++var4)
//		{
//			par3List.add(new ItemStack(par1, 1, var4));
//		}
//	}
	
	public String getName()
	{
		return name;
	}
}