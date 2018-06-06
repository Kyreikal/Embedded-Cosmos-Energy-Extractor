package kyreikal.embeddedcosmosenergyremover.blocks.machines;

import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityHyperFurnace extends TileEntity implements IInventory, ITickable
{
    private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);
    private String customName;
    
    private int burnTime;
    private int currentBurnTime;
    private int cookTime;
    private int totalCookTime;
    
    @Override
    public String getName()
    {
        return this.hasCustomName() ? this.customName : "container.hyper_furnace";
    }

    @Override
    public boolean hasCustomName()
    {
        return this.customName != null && this.customName.isEmpty();
    }
    
    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
    }
    
    @Override
    public int getSizeInventory()
    {
        return this.inventory.size();
    }
    
    @Override
    public boolean isEmpty()
    {
        for(ItemStack stack : this.inventory)
        {
            if(!stack.isEmpty()) return false;
        }
        return true;
    }
    
    @Override
    public ItemStack getStackInSlot(int index)
    {
        return (ItemStack)this.inventory.get(index);
    }
    
    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }
    
    @Override
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }
    
    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        ItemStack itemstack (ItemStack)this.inventory.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackShareTagsEqual(stack, itemstack);
        this.inventory.set(index, stack);
        
        if(stack.getCount() > this.getInventoryStackLimit()) stack.setCount(this.getInventoryStackLimit());
        if(index == 0 && index + 1 == 1 && !flag)
        {
            ItemStack stack1 = (ItemStack)this.inventory.get(index + 1);
            this.totalCookTime = this.getCookTime(stack,stack1);
            this.cookTime = 0;
            this.markDirty();
        }
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inventory);
        this.burnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        this.currentBurnTime = getItemBurnTime((ItemStack)this.inventory.get(2));
        
        if(compound.hasKey("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", (short)this.burnTime);
        compound.setInteger("CookTime", (short)this.cookTime);
        compound.setInteger("CookTimeTotal", (short)this.totalCookTime);
        ItemStackHelper.saveAllItems(compound, this.inventory);
        
        if(this.hasCustomName()) compound.setString("CustomName", this.customName);
        return compound;
    }
    
    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }
    
    public boolean isBurning()
    {
        return this.burnTime > 0;
    }
    
    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory)
    {
        return inventory.getField(0) > 0;
    }
    
    public int getCookTime(ItemStack input1, ItemStack input2)
    {
        return 200;
    }
    
    private boolean canSmelt()
    {
        if(((ItemStack)this.inventory.get(0)).isEmpty() || ((ItemStack)this.invetory.get(1)).isEmpty()) return false;
        
    }
    
}








