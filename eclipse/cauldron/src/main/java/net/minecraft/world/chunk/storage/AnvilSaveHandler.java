package net.minecraft.world.chunk.storage;

import java.io.File;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.storage.SaveHandler;
import net.minecraft.world.storage.ThreadedFileIOBase;
import net.minecraft.world.storage.WorldInfo;

public class AnvilSaveHandler extends SaveHandler
{
    private static final String __OBFID = "CL_00000581";

    public AnvilSaveHandler(File p_i2142_1_, String p_i2142_2_, boolean p_i2142_3_)
    {
        super(p_i2142_1_, p_i2142_2_, p_i2142_3_);
    }

    public IChunkLoader getChunkLoader(WorldProvider p_75763_1_)
    {
        File file1 = this.getWorldDirectory();
        // Cauldron start
        // To workaround the issue of Bukkit relying on every world having a seperate container
        // we won't be generating a DIMXX folder for chunk loaders since this name is already generated
        // for the world container with provider.getSaveFolder().
        /*
        File file2;

        if (p_75763_1_.getSaveFolder() != null)
        {
            file2 = new File(file1, p_75763_1_.getSaveFolder());
            file2.mkdirs();
            return new AnvilChunkLoader(file2);
        }
        else
        {
            return new AnvilChunkLoader(file1);
        } */
        return new AnvilChunkLoader(file1);
        // Cauldron end
    }

    public void saveWorldInfoWithPlayer(WorldInfo p_75755_1_, NBTTagCompound p_75755_2_)
    {
        p_75755_1_.setSaveVersion(19133);
        super.saveWorldInfoWithPlayer(p_75755_1_, p_75755_2_);
    }

    public void flush()
    {
        try
        {
            ThreadedFileIOBase.threadedIOInstance.waitForFinish();
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }

        RegionFileCache.clearRegionFileReferences();
    }
}