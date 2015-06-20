package com.feelings.feelingsmod;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockFeelingsStone extends Block 
{
    public static final PropertyEnum TYPE = PropertyEnum.create("type", BlockFeelingsStone.EnumType.class);
	private final String name = "feelingsStone";
	
	public BlockFeelingsStone()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, ItemFeelingsStone.class, name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, BlockFeelingsStone.EnumType.ORE));
		setUnlocalizedName(FeelingsMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setResistance(100F);
		setStepSound(soundTypeStone);
		setHarvestLevel("pickaxe", 2);
	}
	
    /**
     * Get the damage value that this Block should drop
     */
	@Override
    public int damageDropped(IBlockState state)
    {
        return ((BlockFeelingsStone.EnumType)state.getValue(TYPE)).getMetadata();
    }
    
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        BlockFeelingsStone.EnumType[] aenumtype = BlockFeelingsStone.EnumType.values();
       for(BlockFeelingsStone.EnumType type : aenumtype){
            list.add(new ItemStack(itemIn, 1, type.getMetadata()));
        }
    }
    
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TYPE, BlockFeelingsStone.EnumType.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockFeelingsStone.EnumType)state.getValue(TYPE)).getMetadata();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {TYPE});
    }
    
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        List<ItemStack> ret = new java.util.ArrayList<ItemStack>();

        Random rand = world instanceof World ? ((World)world).rand : RANDOM;

        int count = quantityDropped(state, fortune, rand);
        for(int i = 0; i < count; i++)
        {
            Item item = this.getItemDropped(state, rand, fortune);
            if (item != null)
            {
                ret.add(new ItemStack(item, 1, this.damageDropped(state)));
            }
        }
        return ret;
    }
    
 // when the block is placed, set the appropriate facing direction based on which way the player is looking
    // the colour of block is contained in meta, it corresponds to the values we used for getSubBlocks
//    @Override
//    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
//    {
//      EnumColour colour = EnumColour.byMetadata(meta);
//      // find the quadrant the player is facing
//      EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);
//
//      return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing).withProperty(PROPERTYCOLOUR, colour);
//    }

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

	
	public String getName()
	{
		return name;
	}
	
	public static enum EnumType implements IStringSerializable
    {
        ORE(0, "feelingsOre", "ore"),
        STONE(1, "feelingsStone", "stone"),
        SMOOTH(2, "smoothFeelingsStone", "smooth");
        private static final BlockFeelingsStone.EnumType[] META_LOOKUP = new BlockFeelingsStone.EnumType[values().length];
        private final int metadata;
        private final String name;
        private final String unlocalizedName;

//        private static final String __OBFID = "CL_00002068";

        private EnumType(int meta, String name, String unlocalizedName)
        {
            this.metadata = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        public int getMetadata()
        {
            return this.metadata;
        }

        public String toString()
        {
            return this.name;
        }

        /**
         * Returns the matching EnumType for the given metadata.
         */
        public static BlockFeelingsStone.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        static
        {
            BlockFeelingsStone.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
                BlockFeelingsStone.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
}