// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            StructureStrongholdPieceWeight

class StructureStrongholdPieceWeight2 extends StructureStrongholdPieceWeight
{

    StructureStrongholdPieceWeight2(Class class1, int i, int j)
    {
        super(class1, i, j);
    }

    public boolean canSpawnMoreStructuresOfType(int i)
    {
        return super.canSpawnMoreStructuresOfType(i) && i > 4;
    }
}
