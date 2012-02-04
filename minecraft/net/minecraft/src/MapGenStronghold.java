// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            MapGenStructure, BiomeGenBase, ChunkCoordIntPair, World, 
//            WorldChunkManager, ChunkPosition, StructureStrongholdStart, ComponentStrongholdStairs2, 
//            StructureStart

public class MapGenStronghold extends MapGenStructure
{

    private BiomeGenBase allowedBiomeGenBases[];
    private boolean ranBiomeCheck;
    private ChunkCoordIntPair structureCoords[];

    public MapGenStronghold()
    {
        allowedBiomeGenBases = (new BiomeGenBase[] {
            BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.hills, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.icePlains, BiomeGenBase.iceMountains
        });
        structureCoords = new ChunkCoordIntPair[3];
    }

    protected boolean canSpawnStructureAtCoords(int i, int j)
    {
        if(!ranBiomeCheck)
        {
            rand.setSeed(worldObj.getWorldSeed());
            double d = rand.nextDouble() * 3.1415926535897931D * 2D;
            for(int l = 0; l < structureCoords.length; l++)
            {
                double d1 = (1.25D + rand.nextDouble()) * 32D;
                int j1 = (int)Math.round(Math.cos(d) * d1);
                int k1 = (int)Math.round(Math.sin(d) * d1);
                ArrayList arraylist = new ArrayList();
                BiomeGenBase abiomegenbase[] = allowedBiomeGenBases;
                int l1 = abiomegenbase.length;
                for(int i2 = 0; i2 < l1; i2++)
                {
                    BiomeGenBase biomegenbase = abiomegenbase[i2];
                    arraylist.add(biomegenbase);
                }

                ChunkPosition chunkposition = worldObj.getWorldChunkManager().func_35556_a((j1 << 4) + 8, (k1 << 4) + 8, 112, arraylist, rand);
                if(chunkposition != null)
                {
                    j1 = chunkposition.x >> 4;
                    k1 = chunkposition.z >> 4;
                } else
                {
                    System.out.println((new StringBuilder()).append("Placed stronghold in INVALID biome at (").append(j1).append(", ").append(k1).append(")").toString());
                }
                structureCoords[l] = new ChunkCoordIntPair(j1, k1);
                d += 6.2831853071795862D / (double)structureCoords.length;
            }

            ranBiomeCheck = true;
        }
        ChunkCoordIntPair achunkcoordintpair[] = structureCoords;
        int k = achunkcoordintpair.length;
        for(int i1 = 0; i1 < k; i1++)
        {
            ChunkCoordIntPair chunkcoordintpair = achunkcoordintpair[i1];
            if(i == chunkcoordintpair.chunkXPos && j == chunkcoordintpair.chunkZPos)
            {
                return true;
            }
        }

        return false;
    }

    protected List func_40482_a()
    {
        ArrayList arraylist = new ArrayList();
        ChunkCoordIntPair achunkcoordintpair[] = structureCoords;
        int i = achunkcoordintpair.length;
        for(int j = 0; j < i; j++)
        {
            ChunkCoordIntPair chunkcoordintpair = achunkcoordintpair[j];
            if(chunkcoordintpair != null)
            {
                arraylist.add(chunkcoordintpair.func_40737_a(64));
            }
        }

        return arraylist;
    }

    protected StructureStart getStructureStart(int i, int j)
    {
        StructureStrongholdStart structurestrongholdstart;
        for(structurestrongholdstart = new StructureStrongholdStart(worldObj, rand, i, j); structurestrongholdstart.func_40560_b().isEmpty() || ((ComponentStrongholdStairs2)structurestrongholdstart.func_40560_b().get(0)).field_40009_b == null; structurestrongholdstart = new StructureStrongholdStart(worldObj, rand, i, j)) { }
        return structurestrongholdstart;
    }
}
