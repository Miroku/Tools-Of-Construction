// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Potion

public class PotionHealth extends Potion
{

    public PotionHealth(int i, boolean flag, int j)
    {
        super(i, flag, j);
    }

    public boolean func_40622_b()
    {
        return true;
    }

    public boolean isReady(int i, int j)
    {
        return i >= 1;
    }
}
