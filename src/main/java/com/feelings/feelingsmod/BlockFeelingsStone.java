package com.feelings.feelingsmod;
 
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
 
public class BlockFeelingsStone extends Block
{
private final String name = "tutorialBlock";
public BlockFeelingsStone()
{
super(Material.rock);
GameRegistry.registerBlock(this, name);
setUnlocalizedName(Reference.MODID + "_" + name);
setCreativeTab(CreativeTabs.tabBlock);
}
public String getName()
{
return name;
}
}