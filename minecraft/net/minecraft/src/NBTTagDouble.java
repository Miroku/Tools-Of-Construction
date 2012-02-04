// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagDouble extends NBTBase
{

    public double doubleValue;

    public NBTTagDouble(String s)
    {
        super(s);
    }

    public NBTTagDouble(String s, double d)
    {
        super(s);
        doubleValue = d;
    }

    void writeTagContents(DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeDouble(doubleValue);
    }

    void readTagContents(DataInput datainput)
        throws IOException
    {
        doubleValue = datainput.readDouble();
    }

    public byte getType()
    {
        return 6;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(doubleValue).toString();
    }

    public NBTBase func_40195_b()
    {
        return new NBTTagDouble(getKey(), doubleValue);
    }

    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            NBTTagDouble nbttagdouble = (NBTTagDouble)obj;
            return doubleValue == nbttagdouble.doubleValue;
        } else
        {
            return false;
        }
    }
}
