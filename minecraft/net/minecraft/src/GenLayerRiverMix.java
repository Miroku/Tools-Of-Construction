// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, BiomeGenBase

public class GenLayerRiverMix extends GenLayer
{

    private GenLayer field_35512_b;
    private GenLayer field_35513_c;

    public GenLayerRiverMix(long l, GenLayer genlayer, GenLayer genlayer1)
    {
        super(l);
        field_35512_b = genlayer;
        field_35513_c = genlayer1;
    }

    public void func_35496_b(long l)
    {
        field_35512_b.func_35496_b(l);
        field_35513_c.func_35496_b(l);
        super.func_35496_b(l);
    }

    public int[] func_35500_a(int i, int j, int k, int l)
    {
        int ai[] = field_35512_b.func_35500_a(i, j, k, l);
        int ai1[] = field_35513_c.func_35500_a(i, j, k, l);
        int ai2[] = IntCache.getIntCache(k * l);
        for(int i1 = 0; i1 < k * l; i1++)
        {
            if(ai[i1] == BiomeGenBase.ocean.biomeID)
            {
                ai2[i1] = ai[i1];
                continue;
            }
            if(ai1[i1] >= 0)
            {
                if(ai[i1] == BiomeGenBase.icePlains.biomeID)
                {
                    ai2[i1] = BiomeGenBase.frozenRiver.biomeID;
                    continue;
                }
                if(ai[i1] == BiomeGenBase.mushroomIsland.biomeID || ai[i1] == BiomeGenBase.mushroomIslandShore.biomeID)
                {
                    ai2[i1] = BiomeGenBase.mushroomIslandShore.biomeID;
                } else
                {
                    ai2[i1] = ai1[i1];
                }
            } else
            {
                ai2[i1] = ai[i1];
            }
        }

        return ai2;
    }
}
