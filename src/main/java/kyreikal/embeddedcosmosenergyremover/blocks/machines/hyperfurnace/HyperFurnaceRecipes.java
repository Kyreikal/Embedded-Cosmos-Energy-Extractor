package kyreikal.embeddedcosmosenergyremover.blocks.machines.hyperfurnace;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Maps;

import kyreikal.embeddedcosmosenergyremover.init.ModBlocks;
import kyreikal.embeddedcosmosenergyremover.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class HyperFurnaceRecipes
{
    private static final HyperFurnaceRecipes INSTANCE = new HyperFurnaceRecipes();
    private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
    //static final ItemStack NETHER_STAR = new ItemStack(Items.NETHER_STAR);
    
    public static HyperFurnaceRecipes getInstance()
    {
        return INSTANCE;
    }
    
    private HyperFurnaceRecipes()
    {
        System.out.println("Testing HyperFurnace Recipes");
        addHyperRecipes(new ItemStack(ModItems.SILTARAN_CRYSTAL), new ItemStack(Items.NETHER_STAR), new ItemStack(ModItems.STAR_SILTARAN), 5.0F);
        //addHyperRecipes(new ItemStack(ModBlocks.SILTARAN_ORE), new ItemStack(ModBlocks.SILTARAN_BLOCK), new ItemStack(ModItems.STAR_SILTARAN), 5.0f);
    }
    
    public void addHyperRecipes(ItemStack input1, ItemStack input2, ItemStack result, float experience)
    {
        System.out.println("Testing Testing");
        if(getHyperResult(input1, input2, false) != ItemStack.EMPTY) return;
        this.smeltingList.put(input1, input2, result);
        this.experienceList.put(result, Float.valueOf(experience));
        System.out.println("Recipe Added");
    }
    
    public ItemStack getHyperResult(ItemStack input1, ItemStack input2, boolean flag)
    {
        for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet())
        {
            if(this.compareItemStacks(input1, (ItemStack)entry.getKey()))
            {
                for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
                {
                    if(this.compareItemStacks(input2, (ItemStack)ent.getKey()))
                    {
                        return (ItemStack)ent.getValue();
                        
                    }
                }
            }
            else if (flag == false)
            {
                return getHyperResult(input2, input1, true);
            }
        }
        
        return ItemStack.EMPTY;
    }//end getHyperResult
    
    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }
    
    public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList()
    {
        return this.smeltingList;
    }
    
    public float getHyperExperience(ItemStack stack)
    {
        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if(this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
            
        }
        
        return 0.0F;
    }
    
}





