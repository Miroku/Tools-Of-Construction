// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagLong extends NBTBase
{

    public long longValue;

    public NBTTagLong(String s)
    {
        super(s);
    }

    public NBTTagLong(String s, long l)
    {
        super(s);
        longValue = l;
    }

    void writeTagContents(DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeLong(longValue);
    }

    void readTagContents(DataInput datainput)
        throws IOException
    {
        longValue = datainput.readLong();
    }

    public byte getType()
    {
        return 4;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(longValue).toString();
    }

    public NBTBase func_40195_b()
    {
        return new NBTTagLong(getKey(), longValue);
    }

    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            NBTTagLong nbttaglong = (NBTTagLong)obj;
            return longValue == nbttaglong.longValue;
        } else
        {
            return false;
        }
    }
}
