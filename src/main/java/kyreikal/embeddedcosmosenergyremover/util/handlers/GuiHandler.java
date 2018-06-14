package kyreikal.embeddedcosmosenergyremover.util.handlers;

import kyreikal.embeddedcosmosenergyremover.blocks.machines.hyperfurnace.ContainerHyperFurnace;
import kyreikal.embeddedcosmosenergyremover.blocks.machines.hyperfurnace.GuiHyperFurnace;
import kyreikal.embeddedcosmosenergyremover.blocks.machines.hyperfurnace.TileEntityHyperFurnace;
import kyreikal.embeddedcosmosenergyremover.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == Reference.GUI_HYPER_FURNACE) return new ContainerHyperFurnace(player.inventory, (TileEntityHyperFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == Reference.GUI_HYPER_FURNACE) return new GuiHyperFurnace(player.inventory, (TileEntityHyperFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

}
