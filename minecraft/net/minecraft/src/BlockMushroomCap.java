// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, BlockFlower, Material

public class BlockMushroomCap extends Block
{

    private int field_35292_a;

    public BlockMushroomCap(int i, Material material, int j, int k)
    {
        super(i, j, material);
        field_35292_a = k;
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(j == 10 && i > 1)
        {
            return blockIndexInTexture - 1;
        }
        if(j >= 1 && j <= 9 && i == 1)
        {
            return blockIndexInTexture - 16 - field_35292_a;
        }
        if(j >= 1 && j <= 3 && i == 2)
        {
            return blockIndexInTexture - 16 - field_35292_a;
        }
        if(j >= 7 && j <= 9 && i == 3)
        {
            return blockIndexInTexture - 16 - field_35292_a;
        }
        if((j == 1 || j == 4 || j == 7) && i == 4)
        {
            return blockIndexInTexture - 16 - field_35292_a;
        }
        if((j == 3 || j == 6 || j == 9) && i == 5)
        {
            return blockIndexInTexture - 16 - field_35292_a;
        }
        if(j == 14)
        {
            return blockIndexInTexture - 16 - field_35292_a;
        }
        if(j == 15)
        {
            return blockIndexInTexture - 1;
        } else
        {
            return blockIndexInTexture;
        }
    }

    public int quantityDropped(Random random)
    {
        int i = random.nextInt(10) - 7;
        if(i < 0)
        {
            i = 0;
        }
        return i;
    }

    public int idDropped(int i, Random random, int j)
    {
        return Block.mushroomBrown.blockID + field_35292_a;
    }
}
