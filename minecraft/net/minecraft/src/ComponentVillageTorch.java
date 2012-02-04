// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            World

public class ComponentVillageTorch extends ComponentVillage
{

    private int field_35100_a;

    public ComponentVillageTorch(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35100_a = -1;
        coordBaseMode = j;
        boundingBox = structureboundingbox;
    }

    public void buildComponent(StructureComponent structurecomponent, List list, Random random)
    {
    }

    public static StructureBoundingBox func_35099_a(List list, Random random, int i, int j, int k, int l)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(i, j, k, 0, 0, 0, 3, 4, 2, l);
        if(StructureComponent.getIntersectingStructureComponent(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return structureboundingbox;
        }
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(field_35100_a < 0)
        {
            field_35100_a = getAverageGroundLevel(world, structureboundingbox);
            if(field_35100_a < 0)
            {
                return true;
            }
            boundingBox.offset(0, ((field_35100_a - boundingBox.maxY) + 4) - 1, 0);
        }
        fillWithBlocks(world, structureboundingbox, 0, 0, 0, 2, 3, 1, 0, 0, false);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 1, 0, 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 1, 1, 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.fence.blockID, 0, 1, 2, 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.cloth.blockID, 15, 1, 3, 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.torchWood.blockID, 15, 0, 3, 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.torchWood.blockID, 15, 1, 3, 1, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.torchWood.blockID, 15, 2, 3, 0, structureboundingbox);
        placeBlockAtCurrentPosition(world, Block.torchWood.blockID, 15, 1, 3, -1, structureboundingbox);
        return true;
    }
}
