// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityCreature, IMob, World, DamageSource, 
//            Potion, PotionEffect, Entity, AxisAlignedBB, 
//            MathHelper, EnumSkyBlock, NBTTagCompound

public abstract class EntityMob extends EntityCreature
    implements IMob
{

    protected int attackStrength;

    public EntityMob(World world)
    {
        super(world);
        attackStrength = 2;
        field_35171_bJ = 5;
    }

    public void onLivingUpdate()
    {
        float f = getEntityBrightness(1.0F);
        if(f > 0.5F)
        {
            entityAge += 2;
        }
        super.onLivingUpdate();
    }

    public void onUpdate()
    {
        super.onUpdate();
        if(!worldObj.multiplayerWorld && worldObj.difficultySetting == 0)
        {
            setEntityDead();
        }
    }

    protected Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = worldObj.getClosestVulnerablePlayerToEntity(this, 16D);
        if(entityplayer != null && canEntityBeSeen(entityplayer))
        {
            return entityplayer;
        } else
        {
            return null;
        }
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        if(super.attackEntityFrom(damagesource, i))
        {
            Entity entity = damagesource.getEntity();
            if(riddenByEntity == entity || ridingEntity == entity)
            {
                return true;
            }
            if(entity != this)
            {
                entityToAttack = entity;
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean attackEntityAsMob(Entity entity)
    {
        int i = attackStrength;
        if(isPotionActive(Potion.potionDamageBoost))
        {
            i += 3 << getActivePotionEffect(Potion.potionDamageBoost).getAmplifier();
        }
        if(isPotionActive(Potion.potionWeakness))
        {
            i -= 2 << getActivePotionEffect(Potion.potionWeakness).getAmplifier();
        }
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), i);
    }

    protected void attackEntity(Entity entity, float f)
    {
        if(attackTime <= 0 && f < 2.0F && entity.boundingBox.maxY > boundingBox.minY && entity.boundingBox.minY < boundingBox.maxY)
        {
            attackTime = 20;
            attackEntityAsMob(entity);
        }
    }

    protected float getBlockPathWeight(int i, int j, int k)
    {
        return 0.5F - worldObj.getLightBrightness(i, j, k);
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }

    protected boolean func_40147_Y()
    {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(boundingBox.minY);
        int k = MathHelper.floor_double(posZ);
        if(worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > rand.nextInt(32))
        {
            return false;
        }
        int l = worldObj.getBlockLightValue(i, j, k);
        if(worldObj.getIsThundering())
        {
            int i1 = worldObj.skylightSubtracted;
            worldObj.skylightSubtracted = 10;
            l = worldObj.getBlockLightValue(i, j, k);
            worldObj.skylightSubtracted = i1;
        }
        return l <= rand.nextInt(8);
    }

    public boolean getCanSpawnHere()
    {
        return func_40147_Y() && super.getCanSpawnHere();
    }
}
