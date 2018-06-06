package kyreikal.embeddedcosmosenergyremover.items;

import kyreikal.embeddedcosmosenergyremover.Main;
import kyreikal.embeddedcosmosenergyremover.init.ModItems;
import kyreikal.embeddedcosmosenergyremover.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.ECERMMATERIALTAB);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
