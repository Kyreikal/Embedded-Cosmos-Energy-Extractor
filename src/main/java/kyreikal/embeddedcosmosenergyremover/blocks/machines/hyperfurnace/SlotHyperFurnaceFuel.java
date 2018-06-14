package kyreikal.embeddedcosmosenergyremover.blocks.machines.hyperfurnace;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotHyperFurnaceFuel extends Slot
{
    public SlotHyperFurnaceFuel(IInventory inventory, int index, int x, int y)
    {
        super(inventory, index, x, y);
        
    }
    
    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return TileEntityHyperFurnace.isItemFuel(stack);
    }
    
    @Override
    public int getItemStackLimit(ItemStack stack)
    {
        return super.getItemStackLimit(stack);
    }
}
