package com.feelings.feelingsmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemFeelingsGeneric extends Item 
{ 
        public ItemFeelingsGeneric(String name)
        {
               setUnlocalizedName(FeelingsMod.MODID + "_" + name);
               setTextureName(FeelingsMod.MODID + ":" + name);
               setCreativeTab(CreativeTabs.tabMisc);
        }
}