package kyreikal.embeddedcosmosenergyremover.blocks;

import java.util.Random;

import kyreikal.embeddedcosmosenergyremover.init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class SiltaranOre extends BlockBase
{

	public SiltaranOre(String name, Material material) 
	{
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(3.0f);
		setResistance(6000.0f);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(4.0f);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return ModItems.SILTARAN_CRYSTAL;
	}
	
	@Override
	public int quantityDroppedWithBonus(int bonus, Random rand)
	{
		int j = rand.nextInt(bonus + 1) - 1;
		if (j < 0) j = 0;
		
		return this.quantityDropped(rand)*(j+1);
	}
}
