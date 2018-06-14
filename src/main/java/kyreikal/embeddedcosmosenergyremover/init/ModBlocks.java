package kyreikal.embeddedcosmosenergyremover.init;

import java.util.ArrayList;
import java.util.List;
import kyreikal.embeddedcosmosenergyremover.blocks.BlockBase;
import kyreikal.embeddedcosmosenergyremover.blocks.SiltaranOre;
import kyreikal.embeddedcosmosenergyremover.blocks.machines.hyperfurnace.HyperFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block SILTARAN_BLOCK = new BlockBase("siltaran_block", Material.IRON);
    public static final Block SILTARAN_ORE = new SiltaranOre("siltaran_ore", Material.IRON);

    public static final Block HYPER_FURNACE = new HyperFurnace("hyper_furnace");
}
