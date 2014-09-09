package net.minecraft.tileentity;

public class TileEntityDropper extends TileEntityDispenser
{
    private static final String __OBFID = "CL_00000353";

    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.field_146020_a : "container.dropper";
    }

    // Cauldron start
    @Override
    public boolean canUpdate()
    {
        return false;
    }
    // Cauldron end
}