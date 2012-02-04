// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, EntityPlayer, World, ItemStack

public class ItemSeeds extends Item
{

    private int blockType;
    private int field_40438_b;

    public ItemSeeds(int i, int j, int k)
    {
        super(i);
        blockType = j;
        field_40438_b = k;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(l != 1)
        {
            return false;
        }
        if(!entityplayer.func_35190_e(i, j, k) || !entityplayer.func_35190_e(i, j + 1, k))
        {
            return false;
        }
        int i1 = world.getBlockId(i, j, k);
        if(i1 == field_40438_b && world.isAirBlock(i, j + 1, k))
        {
            world.setBlockWithNotify(i, j + 1, k, blockType);
            itemstack.stackSize--;
            return true;
        } else
        {
            return false;
        }
    }
}
