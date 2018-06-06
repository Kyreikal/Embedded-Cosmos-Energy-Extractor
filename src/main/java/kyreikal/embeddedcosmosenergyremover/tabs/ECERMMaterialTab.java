package kyreikal.embeddedcosmosenergyremover.tabs;

import kyreikal.embeddedcosmosenergyremover.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ECERMMaterialTab extends CreativeTabs
{
	public ECERMMaterialTab(String label)
	{
		super("emermaterialstab");
		
	}
	
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ModItems.STAR_SILTARAN);
	}
}
