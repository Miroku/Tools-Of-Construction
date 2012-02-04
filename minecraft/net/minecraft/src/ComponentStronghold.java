// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, EnumDoorHelper, EnumDoor, Block, 
//            StructureBoundingBox, StructureStrongholdPieces, World, ComponentStrongholdStairs2

abstract class ComponentStronghold extends StructureComponent
{

    protected ComponentStronghold(int i)
    {
        super(i);
    }

    protected void placeDoor(World world, Random random, StructureBoundingBox structureboundingbox, EnumDoor enumdoor, int i, int j, int k)
    {
        switch(EnumDoorHelper.doorEnum[enumdoor.ordinal()])
        {
        case 1: // '\001'
        default:
            fillWithBlocks(world, structureboundingbox, i, j, k, (i + 3) - 1, (j + 3) - 1, k, 0, 0, false);
            break;

        case 2: // '\002'
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i, j, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i, j + 1, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i, j + 2, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i + 1, j + 2, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i + 2, j + 2, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i + 2, j + 1, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i + 2, j, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.doorWood.blockID, 0, i + 1, j, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.doorWood.blockID, 8, i + 1, j + 1, k, structureboundingbox);
            break;

        case 3: // '\003'
            placeBlockAtCurrentPosition(world, 0, 0, i + 1, j, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, 0, 0, i + 1, j + 1, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.fenceIron.blockID, 0, i, j, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.fenceIron.blockID, 0, i, j + 1, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.fenceIron.blockID, 0, i, j + 2, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.fenceIron.blockID, 0, i + 1, j + 2, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.fenceIron.blockID, 0, i + 2, j + 2, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.fenceIron.blockID, 0, i + 2, j + 1, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.fenceIron.blockID, 0, i + 2, j, k, structureboundingbox);
            break;

        case 4: // '\004'
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i, j, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i, j + 1, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i, j + 2, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i + 1, j + 2, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i + 2, j + 2, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i + 2, j + 1, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.stoneBrick.blockID, 0, i + 2, j, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.doorSteel.blockID, 0, i + 1, j, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.doorSteel.blockID, 8, i + 1, j + 1, k, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.button.blockID, func_35009_c(Block.button.blockID, 4), i + 2, j + 1, k + 1, structureboundingbox);
            placeBlockAtCurrentPosition(world, Block.button.blockID, func_35009_c(Block.button.blockID, 3), i + 2, j + 1, k - 1, structureboundingbox);
            break;
        }
    }

    protected EnumDoor getRandomDoor(Random random)
    {
        int i = random.nextInt(5);
        switch(i)
        {
        case 0: // '\0'
        case 1: // '\001'
        default:
            return EnumDoor.OPENING;

        case 2: // '\002'
            return EnumDoor.WOOD_DOOR;

        case 3: // '\003'
            return EnumDoor.GRATES;

        case 4: // '\004'
            return EnumDoor.IRON_DOOR;
        }
    }

    protected StructureComponent func_35028_a(ComponentStrongholdStairs2 componentstrongholdstairs2, List list, Random random, int i, int j)
    {
        switch(coordBaseMode)
        {
        case 2: // '\002'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, boundingBox.minX + i, boundingBox.minY + j, boundingBox.minZ - 1, coordBaseMode, func_35012_c());

        case 0: // '\0'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, boundingBox.minX + i, boundingBox.minY + j, boundingBox.maxZ + 1, coordBaseMode, func_35012_c());

        case 1: // '\001'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, boundingBox.minX - 1, boundingBox.minY + j, boundingBox.minZ + i, coordBaseMode, func_35012_c());

        case 3: // '\003'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, boundingBox.maxX + 1, boundingBox.minY + j, boundingBox.minZ + i, coordBaseMode, func_35012_c());
        }
        return null;
    }

    protected StructureComponent func_35032_b(ComponentStrongholdStairs2 componentstrongholdstairs2, List list, Random random, int i, int j)
    {
        switch(coordBaseMode)
        {
        case 2: // '\002'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, boundingBox.minX - 1, boundingBox.minY + i, boundingBox.minZ + j, 1, func_35012_c());

        case 0: // '\0'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, boundingBox.minX - 1, boundingBox.minY + i, boundingBox.minZ + j, 1, func_35012_c());

        case 1: // '\001'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, boundingBox.minX + j, boundingBox.minY + i, boundingBox.minZ - 1, 2, func_35012_c());

        case 3: // '\003'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, boundingBox.minX + j, boundingBox.minY + i, boundingBox.minZ - 1, 2, func_35012_c());
        }
        return null;
    }

    protected StructureComponent func_35029_c(ComponentStrongholdStairs2 componentstrongholdstairs2, List list, Random random, int i, int j)
    {
        switch(coordBaseMode)
        {
        case 2: // '\002'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, boundingBox.maxX + 1, boundingBox.minY + i, boundingBox.minZ + j, 3, func_35012_c());

        case 0: // '\0'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, boundingBox.maxX + 1, boundingBox.minY + i, boundingBox.minZ + j, 3, func_35012_c());

        case 1: // '\001'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, boundingBox.minX + j, boundingBox.minY + i, boundingBox.maxZ + 1, 0, func_35012_c());

        case 3: // '\003'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, boundingBox.minX + j, boundingBox.minY + i, boundingBox.maxZ + 1, 0, func_35012_c());
        }
        return null;
    }

    protected static boolean canStrongholdGoDeeper(StructureBoundingBox structureboundingbox)
    {
        return structureboundingbox != null && structureboundingbox.minY > 10;
    }
}
