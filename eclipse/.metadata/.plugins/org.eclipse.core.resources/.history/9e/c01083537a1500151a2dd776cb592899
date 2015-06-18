package com.feelings.feelingsmod;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFeelingsStone<IIconRegister> extends Block
{
	String name = "samstone";
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[2];
		
		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(FeelingsMod.MODID + ":" + "samstone" + i);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		return icons[par2];
	}
	
	public BlockFeelingsStone()
	{
		super(Material.rock);
		setBlockName(FeelingsMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setResistance(5F);
		setStepSound(soundTypeStone);
		setHarvestLevel("pickaxe", 2);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for(int var4 = 0; var4 < 2; ++var4)
		{
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}
}