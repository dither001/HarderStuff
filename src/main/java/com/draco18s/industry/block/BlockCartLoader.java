package com.draco18s.industry.block;

import net.minecraft.block.BlockHopper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.draco18s.industry.IndustryBase;
import com.draco18s.industry.entities.TileEntityCartLoader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCartLoader extends BlockHopper implements IHopperExtender{
	private IIcon outsideIcon;
	private IIcon insideIcon;
	private IIcon topIcon;
	private IIcon topOutIcon;
	public int renderID;
	private IIcon bottomIcon;

	public BlockCartLoader() {
		super();
		setBlockName("cart_loader");
		setHardness(2.0F);
		setResistance(4.0F);
		setStepSound(soundTypeWood);
		setBlockTextureName("industry:loader2");
	}
	
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityCartLoader();
    }
	
	/*@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (world.isRemote) {
			return true;
		}
		else {
			player.openGui(IndustryBase.instance, 0, world, x, y, z);
			return true;
		}
	}*/

	@Override
	public int getRenderType() {
        return renderID;
    }
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? topIcon : topOutIcon;
    }

	@SideOnly(Side.CLIENT)
    public IIcon hopperIcon(String p_149916_0_) {
        return p_149916_0_.equals("hopper_outside") ? outsideIcon : (p_149916_0_.equals("hopper_inside") ? insideIcon : p_149916_0_.equals("hopper_bottom") ? bottomIcon : null);
    }
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
		outsideIcon = iconRegister.registerIcon("minecraft:hopper_outside");
        topIcon = iconRegister.registerIcon("minecraft:hopper_top");
        insideIcon = iconRegister.registerIcon("minecraft:hopper_inside");
        bottomIcon = iconRegister.registerIcon("minecraft:redstone_block");
        topOutIcon = iconRegister.registerIcon("industry:loader_topoutside");
    }
	
	@SideOnly(Side.CLIENT)
    public String getItemIconName() {
        return "industry:loader";
    }
}
