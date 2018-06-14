package kyreikal.embeddedcosmosenergyremover.util.handlers;

import kyreikal.embeddedcosmosenergyremover.blocks.machines.hyperfurnace.TileEntityHyperFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler
{
    public static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityHyperFurnace.class, "hyper_furnace");
    }
}
