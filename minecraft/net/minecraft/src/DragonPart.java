// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Entity, EntityDragonBase, NBTTagCompound, DamageSource

public class DragonPart extends Entity
{

    public final EntityDragonBase field_40073_a;
    public final String field_40072_b;

    public DragonPart(EntityDragonBase entitydragonbase, String s, float f, float f1)
    {
        super(entitydragonbase.worldObj);
        setSize(f, f1);
        field_40073_a = entitydragonbase;
        field_40072_b = s;
    }

    protected void entityInit()
    {
    }

    protected void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }

    protected void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }

    public boolean canBeCollidedWith()
    {
        return true;
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        return field_40073_a.func_40156_a(this, damagesource, i);
    }

    public boolean func_41004_h(Entity entity)
    {
        return this == entity || field_40073_a == entity;
    }
}
