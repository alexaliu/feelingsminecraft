package com.feelings.feelingsmod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemFeelingsStone extends ItemBlock
{
	public ItemFeelingsStone(Block block)
	{
		super(block);
		setMaxDamage(0);
	    setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		BlockFeelingsStone.EnumType type = BlockFeelingsStone.EnumType.byMetadata(itemstack.getMetadata());
	    return super.getUnlocalizedName() + "." + type.getUnlocalizedName();
	    
//		String name = "";
//		switch(itemstack.getItemDamage())
//		{
//		case 0:
//			name = "ore";
//			break;
//		case 1:
//			name = "wall";
//			break;
//		default:
//			System.out.println("Invalid metadata for Block FeelingsStone");
//			name = "broken";
//			break;
//		}
//		return getUnlocalizedName() + "." + name;
	}
}
