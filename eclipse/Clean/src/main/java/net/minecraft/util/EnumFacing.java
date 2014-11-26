package net.minecraft.util;

public enum EnumFacing
{
    DOWN(0, 1, 0, -1, 0),
    UP(1, 0, 0, 1, 0),
    NORTH(2, 3, 0, 0, -1),
    SOUTH(3, 2, 0, 0, 1),
    EAST(4, 5, -1, 0, 0),
    WEST(5, 4, 1, 0, 0);

    /** Face order for D-U-N-S-E-W. */
    private final int order_a;

    /** Face order for U-D-S-N-W-E. */
    private final int order_b;
    private final int frontOffsetX;
    private final int frontOffsetY;
    private final int frontOffsetZ;

    /** List of all values in EnumFacing. Order is D-U-N-S-E-W. */
    private static final EnumFacing[] faceList = new EnumFacing[6];

    private EnumFacing(int par3, int par4, int par5, int par6, int par7)
    {
        this.order_a = par3;
        this.order_b = par4;
        this.frontOffsetX = par5;
        this.frontOffsetY = par6;
        this.frontOffsetZ = par7;
    }

    /**
     * Returns a offset that addresses the block in front of this facing.
     */
    public int getFrontOffsetX()
    {
        return this.frontOffsetX;
    }

    public int getFrontOffsetY()
    {
        return this.frontOffsetY;
    }

    /**
     * Returns a offset that addresses the block in front of this facing.
     */
    public int getFrontOffsetZ()
    {
        return this.frontOffsetZ;
    }

    /**
     * Returns the facing that represents the block in front of it.
     */
    public static EnumFacing getFront(int par0)
    {
        return faceList[par0 % faceList.length];
    }

    static
    {
        EnumFacing[] aenumfacing = values();
        int i = aenumfacing.length;

        for (int j = 0; j < i; ++j)
        {
            EnumFacing enumfacing = aenumfacing[j];
            faceList[enumfacing.order_a] = enumfacing;
        }
    }
}
