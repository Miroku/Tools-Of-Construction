// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, Block, World, 
//            IBlockAccess, TileEntityDispenser, EntityPlayer, ItemStack, 
//            ModLoader, Item, EntityArrow, EntityEgg, 
//            EntitySnowball, ItemPotion, EntityPotion, EntityItem, 
//            EntityLiving, MathHelper, TileEntity

public class BlockDispenser extends BlockContainer
{

    private Random random;

    protected BlockDispenser(int i)
    {
        super(i, Material.rock);
        random = new Random();
        blockIndexInTexture = 45;
    }

    public int tickRate()
    {
        return 4;
    }

    public int idDropped(int i, Random random, int j)
    {
        return Block.dispenser.blockID;
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        super.onBlockAdded(world, i, j, k);
        setDispenserDefaultDirection(world, i, j, k);
    }

    private void setDispenserDefaultDirection(World world, int i, int j, int k)
    {
        if(!world.multiplayerWorld)
        {
            int l = world.getBlockId(i, j, k - 1);
            int i1 = world.getBlockId(i, j, k + 1);
            int j1 = world.getBlockId(i - 1, j, k);
            int k1 = world.getBlockId(i + 1, j, k);
            byte byte0 = 3;
            if(Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
            {
                byte0 = 3;
            }
            if(Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
            {
                byte0 = 2;
            }
            if(Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
            {
                byte0 = 5;
            }
            if(Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
            {
                byte0 = 4;
            }
            world.setBlockMetadataWithNotify(i, j, k, byte0);
        }
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(l == 1)
        {
            return blockIndexInTexture + 17;
        }
        if(l == 0)
        {
            return blockIndexInTexture + 17;
        } else
        {
            int i1 = iblockaccess.getBlockMetadata(i, j, k);
            return l == i1 ? blockIndexInTexture + 1 : blockIndexInTexture;
        }
    }

    public int getBlockTextureFromSide(int i)
    {
        return i != 1 ? i != 0 ? i != 3 ? blockIndexInTexture : blockIndexInTexture + 1 : blockIndexInTexture + 17 : blockIndexInTexture + 17;
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.multiplayerWorld)
        {
            return true;
        }
        TileEntityDispenser tileentitydispenser = (TileEntityDispenser)world.getBlockTileEntity(i, j, k);
        if(tileentitydispenser != null)
        {
            entityplayer.displayGUIDispenser(tileentitydispenser);
        }
        return true;
    }

    private void dispenseItem(World world, int i, int j, int k, Random random)
    {
        int l = world.getBlockMetadata(i, j, k);
        int i1 = 0;
        int j1 = 0;
        if(l == 3)
        {
            j1 = 1;
        } else
        if(l == 2)
        {
            j1 = -1;
        } else
        if(l == 5)
        {
            i1 = 1;
        } else
        {
            i1 = -1;
        }
        TileEntityDispenser tileentitydispenser = (TileEntityDispenser)world.getBlockTileEntity(i, j, k);
        if(tileentitydispenser != null)
        {
            ItemStack itemstack = tileentitydispenser.getRandomStackFromInventory();
            double d = (double)i + (double)i1 * 0.59999999999999998D + 0.5D;
            double d1 = (double)j + 0.5D;
            double d2 = (double)k + (double)j1 * 0.59999999999999998D + 0.5D;
            if(itemstack == null)
            {
                world.playAuxSFX(1001, i, j, k, 0);
            } else
            {
                boolean flag = ModLoader.DispenseEntity(world, d, d1, d2, i1, j1, itemstack);
                if(!flag)
                {
                    if(itemstack.itemID == Item.arrow.shiftedIndex)
                    {
                        EntityArrow entityarrow = new EntityArrow(world, d, d1, d2);
                        entityarrow.setArrowHeading(i1, 0.10000000149011612D, j1, 1.1F, 6F);
                        entityarrow.doesArrowBelongToPlayer = true;
                        world.entityJoinedWorld(entityarrow);
                        world.playAuxSFX(1002, i, j, k, 0);
                    } else
                    if(itemstack.itemID == Item.egg.shiftedIndex)
                    {
                        EntityEgg entityegg = new EntityEgg(world, d, d1, d2);
                        entityegg.setThrowableHeading(i1, 0.10000000149011612D, j1, 1.1F, 6F);
                        world.entityJoinedWorld(entityegg);
                        world.playAuxSFX(1002, i, j, k, 0);
                    } else
                    if(itemstack.itemID == Item.snowball.shiftedIndex)
                    {
                        EntitySnowball entitysnowball = new EntitySnowball(world, d, d1, d2);
                        entitysnowball.setThrowableHeading(i1, 0.10000000149011612D, j1, 1.1F, 6F);
                        world.entityJoinedWorld(entitysnowball);
                        world.playAuxSFX(1002, i, j, k, 0);
                    } else
                    if(itemstack.itemID == Item.potion.shiftedIndex && ItemPotion.func_40433_c(itemstack.getItemDamage()))
                    {
                        EntityPotion entitypotion = new EntityPotion(world, d, d1, d2, itemstack.getItemDamage());
                        entitypotion.setThrowableHeading(i1, 0.10000000149011612D, j1, 1.375F, 3F);
                        world.entityJoinedWorld(entitypotion);
                        world.playAuxSFX(1002, i, j, k, 0);
                    } else
                    {
                        EntityItem entityitem = new EntityItem(world, d, d1 - 0.29999999999999999D, d2, itemstack);
                        double d3 = random.nextDouble() * 0.10000000000000001D + 0.20000000000000001D;
                        entityitem.motionX = (double)i1 * d3;
                        entityitem.motionY = 0.20000000298023224D;
                        entityitem.motionZ = (double)j1 * d3;
                        entityitem.motionX += random.nextGaussian() * 0.0074999998323619366D * 6D;
                        entityitem.motionY += random.nextGaussian() * 0.0074999998323619366D * 6D;
                        entityitem.motionZ += random.nextGaussian() * 0.0074999998323619366D * 6D;
                        world.entityJoinedWorld(entityitem);
                        world.playAuxSFX(1000, i, j, k, 0);
                    }
                }
                world.playAuxSFX(2000, i, j, k, i1 + 1 + (j1 + 1) * 3);
            }
        }
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        if(l > 0 && Block.blocksList[l].canProvidePower())
        {
            boolean flag = world.isBlockIndirectlyGettingPowered(i, j, k) || world.isBlockIndirectlyGettingPowered(i, j + 1, k);
            if(flag)
            {
                world.scheduleBlockUpdate(i, j, k, blockID, tickRate());
            }
        }
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(!world.multiplayerWorld && (world.isBlockIndirectlyGettingPowered(i, j, k) || world.isBlockIndirectlyGettingPowered(i, j + 1, k)))
        {
            dispenseItem(world, i, j, k, random);
        }
    }

    public TileEntity getBlockEntity()
    {
        return new TileEntityDispenser();
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if(l == 0)
        {
            world.setBlockMetadataWithNotify(i, j, k, 2);
        }
        if(l == 1)
        {
            world.setBlockMetadataWithNotify(i, j, k, 5);
        }
        if(l == 2)
        {
            world.setBlockMetadataWithNotify(i, j, k, 3);
        }
        if(l == 3)
        {
            world.setBlockMetadataWithNotify(i, j, k, 4);
        }
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        TileEntityDispenser tileentitydispenser = (TileEntityDispenser)world.getBlockTileEntity(i, j, k);
        if(tileentitydispenser != null)
        {
            for(int l = 0; l < tileentitydispenser.getSizeInventory(); l++)
            {
                ItemStack itemstack = tileentitydispenser.getStackInSlot(l);
                if(itemstack != null)
                {
                    float f = random.nextFloat() * 0.8F + 0.1F;
                    float f1 = random.nextFloat() * 0.8F + 0.1F;
                    float f2 = random.nextFloat() * 0.8F + 0.1F;
                    while(itemstack.stackSize > 0) 
                    {
                        int i1 = random.nextInt(21) + 10;
                        if(i1 > itemstack.stackSize)
                        {
                            i1 = itemstack.stackSize;
                        }
                        itemstack.stackSize -= i1;
                        EntityItem entityitem = new EntityItem(world, (float)i + f, (float)j + f1, (float)k + f2, new ItemStack(itemstack.itemID, i1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (float)random.nextGaussian() * f3;
                        entityitem.motionY = (float)random.nextGaussian() * f3 + 0.2F;
                        entityitem.motionZ = (float)random.nextGaussian() * f3;
                        world.entityJoinedWorld(entityitem);
                    }
                }
            }

        }
        super.onBlockRemoval(world, i, j, k);
    }
}
