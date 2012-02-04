// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            WeightedRandomChoice

public class WeightedRandom
{

    public WeightedRandom()
    {
    }

    public static int func_35736_a(Collection collection)
    {
        int i = 0;
        for(Iterator iterator = collection.iterator(); iterator.hasNext();)
        {
            WeightedRandomChoice weightedrandomchoice = (WeightedRandomChoice)iterator.next();
            i += weightedrandomchoice.field_35590_d;
        }

        return i;
    }

    public static WeightedRandomChoice func_35734_a(Random random, Collection collection, int i)
    {
        if(i <= 0)
        {
            throw new IllegalArgumentException();
        }
        int j = random.nextInt(i);
        for(Iterator iterator = collection.iterator(); iterator.hasNext();)
        {
            WeightedRandomChoice weightedrandomchoice = (WeightedRandomChoice)iterator.next();
            j -= weightedrandomchoice.field_35590_d;
            if(j < 0)
            {
                return weightedrandomchoice;
            }
        }

        return null;
    }

    public static WeightedRandomChoice func_35733_a(Random random, Collection collection)
    {
        return func_35734_a(random, collection, func_35736_a(collection));
    }

    public static int func_35737_a(WeightedRandomChoice aweightedrandomchoice[])
    {
        int i = 0;
        WeightedRandomChoice aweightedrandomchoice1[] = aweightedrandomchoice;
        int j = aweightedrandomchoice1.length;
        for(int k = 0; k < j; k++)
        {
            WeightedRandomChoice weightedrandomchoice = aweightedrandomchoice1[k];
            i += weightedrandomchoice.field_35590_d;
        }

        return i;
    }

    public static WeightedRandomChoice func_35732_a(Random random, WeightedRandomChoice aweightedrandomchoice[], int i)
    {
        if(i <= 0)
        {
            throw new IllegalArgumentException();
        }
        int j = random.nextInt(i);
        WeightedRandomChoice aweightedrandomchoice1[] = aweightedrandomchoice;
        int k = aweightedrandomchoice1.length;
        for(int l = 0; l < k; l++)
        {
            WeightedRandomChoice weightedrandomchoice = aweightedrandomchoice1[l];
            j -= weightedrandomchoice.field_35590_d;
            if(j < 0)
            {
                return weightedrandomchoice;
            }
        }

        return null;
    }

    public static WeightedRandomChoice func_35735_a(Random random, WeightedRandomChoice aweightedrandomchoice[])
    {
        return func_35732_a(random, aweightedrandomchoice, func_35737_a(aweightedrandomchoice));
    }
}
