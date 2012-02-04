// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityPlayerSP, Main, Packet0KeepAlive, NetClientHandler, 
//            World, Session, MathHelper, Packet19EntityAction, 
//            AxisAlignedBB, Packet11PlayerPosition, Packet13PlayerLookMove, Packet12PlayerLook, 
//            Packet10Flying, Packet14BlockDig, Packet3Chat, Packet18Animation, 
//            Packet9Respawn, Packet101CloseWindow, Container, InventoryPlayer, 
//            StatBase, DamageSource, EntityItem

public class EntityClientPlayerMP extends EntityPlayerSP
{

    
    public NetClientHandler sendQueue;
    private int inventoryUpdateTickCounter;
    private boolean field_21093_bH;
    private double oldPosX;
    private double field_9378_bz;
    private double oldPosY;
    private double oldPosZ;
    private float oldRotationYaw;
    private float oldRotationPitch;
    private boolean field_9382_bF;
    private boolean field_35227_cs;
    private boolean wasSneaking;
    private int field_12242_bI;
    private double savedposx;
    private double savedposy;
    private double savedposz;


    public EntityClientPlayerMP(Minecraft minecraft, World world, Session session, NetClientHandler netclienthandler)
    {
    	
    	
        super(minecraft, world, session, 0);
        if(Main.fly)
        {
            onGround = true;
            double d = posX - savedposx;
            double d1 = posY - savedposy;
            double d2 = posZ - savedposz;
            double d3 = d * d + d1 * d1 + d2 * d2;
            if(d3 <= 80D)
            {
                sendQueue.addToSendQueue(new Packet0KeepAlive());
                return;
            }
            
        }
        savedposx = posX;
        savedposy = posY;
        savedposz = posZ;
        inventoryUpdateTickCounter = 0;
        field_21093_bH = false;
        field_9382_bF = false;
        field_35227_cs = false;
        wasSneaking = false;
        field_12242_bI = 0;
        sendQueue = netclienthandler;
        
        if(Main.derp && mc.isMultiplayerWorld())
        {
        	Random random = new Random();
        	Random random1 = new Random();
        	rotationYaw = random.nextInt(360) + 1;
        	rotationPitch = random1.nextInt(18) +1;
        	mc.getSendQueue().addToSendQueue(new Packet12PlayerLook(rotationYaw, rotationPitch, onGround));
        	mc.getSendQueue().addToSendQueue(new Packet18Animation(mc.thePlayer, 1));
        }
        
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        return false;
    }

    public void heal(int i)
    {
    	
    }

    public void onUpdate()
    
    {
        if(!worldObj.blockExists(MathHelper.floor_double(posX), worldObj.field_35472_c / 2, MathHelper.floor_double(posZ)))
        {
            return;
        } else
        {
            super.onUpdate();
            onUpdate2();
            return;
        }
    }

    public void onUpdate2()
    {
    	if(Main.fly)
    	  {
    	    double d7 = posX - savedposx;
    	    double d8 = posY - savedposy;
    	    double d9 = posZ - savedposz;
    	    double d10 = d7 * d7 + d8 * d8 + d9 * d9;
    	    if(d10 <= 80D)
    	    {
    	    sendQueue.addToSendQueue(new Packet0KeepAlive());
    	    return;
    	    }
    	  }
    	
    	if(Main.survivor && mc.thePlayer.health <= 1)
    	{
    		sendQueue.addToSendQueue(new Packet255KickDisconnect("Saved By Suvivor"));
    		Main.survivor =false;
    	}
    	if(Main.killaura)
    	{
    		List<EntityPlayer> Players = mc.theWorld.playerEntities;
    		for(int a = 0;a < Players.size();a ++)
    		{
    			EntityPlayer entity = Players.get(a);
    			if(!entity.username.equals("2dieis2live") || !entity.username.equals("RANDOM1ZA") || !entity.username.equals("guychaloner") || !entity.username.equals("Captain_derple") || !entity.username.equals("simran123") || !entity.username.equals("bennoman1"))
    			{
    				if(entity != mc.thePlayer && mc.thePlayer.getDistanceSqToEntity(entity) <= 25 )
    				{
    					mc.getSendQueue().addToSendQueue(new Packet7UseEntity(mc.thePlayer.entityId, entity.entityId, 1));
    				}
    			}
    		}
    	}
    	if(Main.nukernt)
    	{
    		int size = 5;
    		for(int x = -size; x < size + 1; x++){
    			for(int z = -size; z < size + 1; z++){
    			for(int y = -size; y < size + 1; y++){
    			int i = (int) posX + x;
    			int j = (int) posY + y;
    			int k = (int) posZ + z;
    			if(mc.theWorld.getBlockId(i, j, k) != 0){
    			if(System.currentTimeMillis() % 10 == 0){
    			mc.getSendQueue().addToSendQueue(new Packet14BlockDig(0, i, j, k, 0));
    			mc.getSendQueue().addToSendQueue(new Packet14BlockDig(2, i, j, k, 0));
    			}
    			}
    			}
    			}
    			}
    			}
    	 if(Main.tnuke)
         {
         byte byte0 = 8;
         for(int j1 = byte0; j1 > -byte0; j1--)
         {
         for(int k1 = byte0; k1 > -byte0; k1--)
         {
         for(int l1 = byte0; l1 > -byte0; l1--)
         {
         double d = mc.thePlayer.posX + j1;
         double d1 = mc.thePlayer.posY + k1;
         double d2 = mc.thePlayer.posZ + l1;
         int i2 = (int)d;
         int j2 = (int)d1;
         int k2 = (int)d2;
         int l2 = mc.theWorld.getBlockId(i2, j2, k2);
         Block block = Block.blocksList[l2];
         if(block == Block.torchWood)
         {
         ((EntityClientPlayerMP)mc.thePlayer).sendQueue.addToSendQueue(new Packet14BlockDig(0, i2, j2, k2, 1));
         ((EntityClientPlayerMP)mc.thePlayer).sendQueue.addToSendQueue(new Packet14BlockDig(2, i2, j2, k2, 1));
         }
         }

         }

         }
         }
    	
    	
    	
    	
    	
    	if(Main.autoplace) {
            int size = 5;
            for(int x = -size; x < size + 1; x++) {
                for(int y = -size; y < size + 1; y++) { 
        for(int z = -size; z < size + 1; z++) {
            int i = (int) posX + x;
            int j = (int) posY + y;
            int k = (int) posZ + z;
            if(mc.theWorld.getBlockId(i, j, k) != 0) {
                      mc.getSendQueue().addToSendQueue(new Packet15Place(i, j, k, 1, mc.thePlayer.inventory.getCurrentItem()));
            }
                    }
                }
            }
        }

    	
    	
    	
    	
    	
    	if(inventoryUpdateTickCounter++ == 20)
        {
            sendInventoryChanged();
            inventoryUpdateTickCounter = 0;
        }
        boolean flag = isSprinting() || Main.sneak;
        if(flag != wasSneaking)
        {
            if(flag)
            {
                sendQueue.addToSendQueue(new Packet19EntityAction(this, 4));
            } else
            {
                sendQueue.addToSendQueue(new Packet19EntityAction(this, 5));
            }
            wasSneaking = flag;
        }
        boolean flag1 = isSneaking() || Main.sneak;
        if(flag1 != field_35227_cs)
        {
            if(flag1)
            {
                sendQueue.addToSendQueue(new Packet19EntityAction(this, 1));
            } else
            {
                sendQueue.addToSendQueue(new Packet19EntityAction(this, 2));
            }
            field_35227_cs = flag1;
        }
        double d = posX - oldPosX;
        double d1 = boundingBox.minY - field_9378_bz;
        double d2 = posY - oldPosY;
        double d3 = posZ - oldPosZ;
        double d4 = rotationYaw - oldRotationYaw;
        double d5 = rotationPitch - oldRotationPitch;
        boolean flag2 = d1 != 0.0D || d2 != 0.0D || d != 0.0D || d3 != 0.0D;
        boolean flag3 = d4 != 0.0D || d5 != 0.0D;
        if(ridingEntity != null)
        {
            if(flag3)
            {
             sendQueue.addToSendQueue(new Packet11PlayerPosition(motionX, -999D, -999D, motionZ, Main.nofall == true ? false : onGround));
             } else
             {
             sendQueue.addToSendQueue(new Packet13PlayerLookMove(motionX, -999D, -999D, motionZ, rotationYaw, rotationPitch, Main.nofall == true ? false : onGround));
             }
             flag2 = false;
             } else
             if(flag2 && flag3)
             {
             sendQueue.addToSendQueue(new Packet13PlayerLookMove(posX, boundingBox.minY, posY, posZ, rotationYaw, rotationPitch, Main.nofall == true ? false : onGround));
             field_12242_bI = 0;
             } else
             if(flag2)
             {
             sendQueue.addToSendQueue(new Packet11PlayerPosition(posX, boundingBox.minY, posY, posZ, Main.nofall == true ? false : onGround));
             field_12242_bI = 0;
             } else
             if(flag3)
             {
             sendQueue.addToSendQueue(new Packet12PlayerLook(rotationYaw, rotationPitch, Main.nofall == true ? false : onGround));
             field_12242_bI = 0;
             } else
             {
              sendQueue.addToSendQueue(new Packet10Flying(Main.nofall == true ? false : onGround));
             if(field_9382_bF != onGround || field_12242_bI > 200);
             }
              }

    public void dropCurrentItem()
    {
        sendQueue.addToSendQueue(new Packet14BlockDig(4, 0, 0, 0, 0));
    }

    public void sendInventoryChanged()
    {
    }

    protected void joinEntityItemWithWorld(EntityItem entityitem)
    {
    }

    public void sendChatMessage(String s)
    {
    	/*if(s.toLowerCase().startsWith(".connect"))
    	{
    		try{
    			MyBotMain thisBot =new MyBotMain(username, mc);
    			new Thread(thisBot).start();
    			return;
    		} catch (Exception e) {
    			addChatMessage("\247cI'm Sorry ,there was an error.");
    			addChatMessage("\247cPlease wait a minute before trying again.");
    		}
    	}*/
    	if(s.equals(".fps"))
    	{
    	  Main.fps = !Main.fps;
    	}
    	if(s.startsWith(".jump"))
    	  {
    		
    	    try
    	    {
    	    String as5[] = s.split(" ");
    	    String s6 = as5[1];
    	    float f4 = Float.parseFloat(s6);
    	    EntityLiving.jh = f4;
    	    mc.thePlayer.addChatMessage((new StringBuilder()).append("\2474jump height Set To: \2472").append(EntityLiving.jh).toString());
    	    Main.jump = !Main.jump;
    	    }
    	    catch(Exception exception5)
    	    {
    	    mc.thePlayer.addChatMessage("Syntax: .jump [int]");
    	    }
    	    return;
    	  }
    	if(s.startsWith(".timer"))
    	  {
    		
    	    try
    	    {
    	    String as5[] = s.split(" ");
    	    String s6 = as5[1];
    	    float f4 = Float.parseFloat(s6);
    	    Timer.tp = f4;
    	    mc.thePlayer.addChatMessage((new StringBuilder()).append("\2474step height Set To: \2472").append(Timer.tp).toString());
    	    Main.run =  !Main.run;
    	    }
    	    catch(Exception exception5)
    	    {
    	    mc.thePlayer.addChatMessage("Syntax: .timer [int]");
    	    }
    	    return;
    	  }
    	if(s.startsWith(".step"))
    	  {
    		
    	    try
    	    {
    	    String as5[] = s.split(" ");
    	    String s6 = as5[1];
    	    float f4 = Float.parseFloat(s6);
    	    Entity.st = f4;
    	    mc.thePlayer.addChatMessage((new StringBuilder()).append("\2474step height Set To: \2472").append(Entity.st).toString());
    	    Main.step = !Main.step;
    	    }
    	    catch(Exception exception5)
    	    {
    	    mc.thePlayer.addChatMessage("Syntax: .step [int]");
    	    }
    	    return;
    	  }
    	if(s.startsWith(".locketteb"))
    	{
    		Main.LocketteBypass = !Main.LocketteBypass;
    		mc.thePlayer.addChatMessage("Left Click the sign to change it");
    	}
    	if(s.startsWith(".snowman"))
    	{
    		Main.buildsnowman = !Main.buildsnowman;
    		mc.thePlayer.addChatMessage("Place a Snow Block in front of you");
    	}
    	if(s.startsWith(".survivor"))
    	{
    		Main.survivor = !Main.survivor;
    		
    	}
    	if(s.startsWith(".lock"))
    	{
    		Main.lock = !Main.lock;
    		
    	}
    	if(s.startsWith(".up"))
        {
        try {
         String sky[] = s.split(" ");
         String b = sky[1];
         int f = Integer.parseInt(b);
         for(int k1 = 1; k1 < f; k1++)
         {
         try {
             double d = mc.thePlayer.posY +.00005D;
             for(int l2 = 0; l2 < 1; l2++)
             {
                 mc.thePlayer.setLocationAndAngles(mc.thePlayer.posX, d, mc.thePlayer.posZ, mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch);
                 mc.getSendQueue().addToSendQueue(new Packet11PlayerPosition(mc.thePlayer.posX, d - 1.0D, d, mc.thePlayer.posZ, true));
             }
         } catch (Exception e) {}}} catch (Exception e) {}
     }
    	if(s.startsWith(".jesus"))
    	{
    		Main.jesus = !Main.jesus;
    		
    	}
    	if(s.startsWith(".torch"))
    	{
    		Main.tnuke = !Main.tnuke;
    		
    	}
    	if(s.startsWith(".cnuker"))
    	{
    		Main.cnuker = !Main.cnuker;
    		
    	}
    	if(s.startsWith(".kill"))
    	{
    		Main.killaura = !Main.killaura;
    		
    	}
    	if(s.equalsIgnoreCase(".drop")){
            try{
            for(int c = 0; c<9;c++){      
                sendQueue.addToSendQueue(new Packet16BlockItemSwitch(c));    
    for(int b = 0; b<8;b++){
        Thread.sleep(50);
            for(int a = 0; a<8;a++){                
            sendQueue.addToSendQueue(new Packet14BlockDig(4, 0, 0, 0, 0));
              }
            }
    }                

         }catch (Exception e) { }            
        }
    	if(s.startsWith(".fog"))
    	{
    		Main.voidfog = !Main.voidfog;
    		mc.thePlayer.addChatMessage("Void fog toggled");
    	}
    	if(s.startsWith(".sprint"))
    	{
    		Main.supersprint = !Main.sprint;
    		mc.thePlayer.addChatMessage("Sprint mode changed");
    	}
    	if(s.startsWith(".aimbotpvp"))
    	{
    		Main.aimbotpvp = !Main.aimbotpvp;
    		List list = mc.theWorld.playerEntities;
            for(int j2 = 0; j2 < list.size(); j2++)
            {
                if(((EntityPlayer)list.get(j2)).username ==            mc.thePlayer.username)
                {
                    continue;
                }
                EntityPlayer entityplayer = (EntityPlayer)list.get(1);
                if(mc.thePlayer.getDistanceToEntity(entityplayer) > mc.thePlayer.getDistanceToEntity((Entity)list.get(j2)))
                {
                    entityplayer = (EntityPlayer)list.get(j2);
                }
                float f4 = this.mc.thePlayer.getDistanceToEntity(entityplayer);
                double d = 0.0D;
                double d2 = entityplayer.posX - mc.thePlayer.posX;
                double d3 = entityplayer.posZ - mc.thePlayer.posZ;
                double d4 = (entityplayer.posY - mc.thePlayer.posY) + 1.2D;
                if(d3 > 0.0D && d2 > 0.0D)
                {
                    d = Math.toDegrees(-Math.atan(d2 / d3));
                } else
                if(d3 > 0.0D && d2 < 0.0D)
                {
                    d = Math.toDegrees(-Math.atan(d2 / d3));
                } else
                if(d3 < 0.0D && d2 > 0.0D)
                {
                    d = -90D + Math.toDegrees(Math.atan(d3 / d2));
                } else
                if(d3 < 0.0D && d2 < 0.0D)
                {
                    d = 90D + Math.toDegrees(Math.atan(d3 / d2));
                }
                if(f4 < 8)
                {
                mc.thePlayer.rotationYaw = (float)d;
                double d5 = Math.sqrt(d3 * d3 + d2 * d2);
                double d6 = -Math.toDegrees(Math.atan(d4 / d5));
                mc.thePlayer.rotationPitch = (float)d6;
                }
            }

    	}
    	if (s.startsWith(".derp"))
    	{
    	Main.derp = !Main.derp;
    	if(Main.derp)
    	{
    	mc.ingameGUI.addChatMessage("Herp derp hurr durr hurr");
    	}else
    	{
    	mc.ingameGUI.addChatMessage("No more herp derp");
    	}
    	}else

    	if(mc.playerController.isInCreativeMode() && s.startsWith(".cdrop"))
    	{
    		try
    		{
    			String dropCommand[] = s.split(" ");
    			int ID = Integer.parseInt(dropCommand[1]);
    			int drops = Integer.parseInt(dropCommand[2]);
    			int itemsPerDrop = Integer.parseInt(dropCommand[3]);
    			for(int cdrop = 1; cdrop <= drops; cdrop++)
    			{
    				mc.playerController.func_35639_a(new ItemStack(ID, itemsPerDrop, 1));
    			}
    		
    	}
    	catch(Exception ex)
    	{
    		mc.thePlayer.addChatMessage("\247bCorrect Syntax: .cdrop (itemID) (# of Drops) (StackSize)");
    	}
    }
    	if(s.equals(".hunger"))
        {
            for(int zc = 0; zc < 50000; zc++)
        {
                mc.thePlayer.foodStats.setFoodLevel(20);
        }
        }
    	if(s.startsWith(".face")){
    		try{
    			String [] s2 = s.split(" ");
    			Object Name = s2[1];
    			List<EntityPlayer> z = mc.theWorld.playerEntities;
    			for(int x =0; x< z.size();x++){
    				 if(Name.equals(z.get(x).username)){
    					 EntityPlayer s3 = z.get(x);      
    					  mc.thePlayer.faceEntity(s3,1000,1000);
    				  }
    				}
    				}catch(Exception e){}
    				return;
    				}
    	
    	
    	
    	
    		
    		
    		
    	if(s.startsWith(".vanish"))
    	{
    		Main.antivanish = !Main.antivanish;
    		mc.thePlayer.addChatMessage("AntiVanish toggled");
    	}
    	if(s.startsWith(".spam")) 
    	{
    		try {
    	    boolean flag4 = false;
    	    String as30[] = s.split("=");
    	    String s16 = as30[1];
    	    int k3 = Integer.parseInt(as30[2]);
    	    for(int l4 = 0; l4 <= k3; l4++)
    	    {
    	    	sendQueue.addToSendQueue(new Packet3Chat(s16));
    	    }
    	    	
    	    }
    	 catch (Exception exception23) 
    	 {
    	    addChatMessage("\2474Warning: \247ASyntax: \2472.spam=Message=NumberOfTimes");
    	}
    	}
    		if(s.startsWith(".rage"))
    		{
    			int timesToSpam = 10000;
    			for (int i = 0; i < timesToSpam; i++)
    			{
    				sendQueue.addToSendQueue(new Packet1Login("!_@", -1));
    			}
    		}
    		
    		if(s.startsWith(".arrow")) 
        	try{
        	    String arrow[] = s.split("=");
        	    sendChatMessage(arrow[1]+", but then I took an arrow to the knee!");
        	   
        	} catch(Exception e) {
        	    addChatMessage("\2474Warning: \247ASyntax: \2472.arrow=Message");
        	 }
    		
    	if(s.startsWith(".sdrop"))
    	{
    		Main.sdrop = !Main.sdrop;
    		mc.thePlayer.addChatMessage("Dropping...");
    		for(int R = 0; R < 9; R++)
    		{
    			mc.getSendQueue().addToSendQueue(new Packet16BlockItemSwitch(R));
    			if(R==0)
    			{
    				mc.thePlayer.dropCurrentItem();
    			}
    			if(R==1)
    			{
    				mc.thePlayer.dropCurrentItem();
    			}
    			if(R==2)
    			{
    				mc.thePlayer.dropCurrentItem();
    			}
    			if(R==3)
    			{
    				mc.thePlayer.dropCurrentItem();
    			}
    			if(R==4)
    			{
    				mc.thePlayer.dropCurrentItem();
    			}
    			if(R==5)
    			{
    				mc.thePlayer.dropCurrentItem();
    			}
    			if(R==6)
    			{
    				mc.thePlayer.dropCurrentItem();
    			}
    			if(R==7)
    			{
    				mc.thePlayer.dropCurrentItem();
    			}
    			if(R==8)
    			{
    				mc.thePlayer.dropCurrentItem();
    			}
    			
    		
    		}
    	}
    	if(s.startsWith(".tracer"))
    	{
    		Main.tracer = !Main.tracer;
    		mc.thePlayer.addChatMessage("Tracer toggled");
    	}
    	if(s.startsWith(".cluster"))
    	{
    		Main.cluster = !Main.cluster;
    		mc.thePlayer.addChatMessage("Cluster Nuker (Creative) Toggled");
    	}
    	if(s.startsWith(".tracerdiamond"))
    	{
    		Main.tracerdiamond = !Main.tracerdiamond;
    		mc.thePlayer.addChatMessage("Cluster Nuker (Creative) Toggled");
    	}
    	if(s.startsWith(".autoplace"))
    	{
    		Main.autoplace = !Main.autoplace;
    		mc.thePlayer.addChatMessage("AUTOPLACE GO..Or stop going...");
    	}
    	if(s.startsWith(".house"))
    	{
    		Main.house = !Main.house;
    		mc.thePlayer.addChatMessage("Poof! House.");
    	}
    	if(s.startsWith(".nukernt"))
    	{
    		Main.nukernt = !Main.nukernt;
    		mc.thePlayer.addChatMessage("Non-Threaded nuker toggled");
    	}
    	if(s.startsWith(".spawn"))
        {
            new Thread(){
                public void run(){
                    try
                    {
                        Thread.sleep(1000);
                        mc.thePlayer.setPosition(20, 71, 21);
                    }
                    catch(Exception e)
                    {

                    }
                }
            }.start();
        mc.displayGuiScreen(null);
        return;
        }

        if (!mc.lineIsCommand(s) && !s.startsWith(".dupe"))
        {
        mc.thePlayer.addChatMessage("<\247cYocairo\247f> " + s);
        }
        else if(s.startsWith(".dupe"))
        {
            Hack.onDupe();
        }
        }
        mc.displayGuiScreen(null);
        return;
}
      

    	
    	
    	if(s.startsWith("."))
    	  {
    	    return;
    	  } else
    	  {
    	  sendQueue.addToSendQueue(new Packet3Chat(s));
    	  }
    	
    }
    
     
    
    
    
    
    
    public void swingItem()
    {
        if(!Main.noswing)
        {
            super.swingItem();
        }
        sendQueue.addToSendQueue(new Packet18Animation(this, 1));
    }

    public void respawnPlayer()
    {
        sendInventoryChanged();
        sendQueue.addToSendQueue(new Packet9Respawn((byte)dimension, (byte)worldObj.difficultySetting, worldObj.getWorldSeed(), worldObj.field_35472_c, 0));
    }

    protected void damageEntity(DamageSource damagesource, int i)
    {
    	if(Main.lock)
    	{
    		setEntityHealth(getEntityHealth() + i);
    	}else
        setEntityHealth(getEntityHealth() - i);
    }

    public void closeScreen()
    {
        sendQueue.addToSendQueue(new Packet101CloseWindow(craftingInventory.windowId));
        inventory.setItemStack(null);
        super.closeScreen();
    }

    public void setHealth(int i)
    {
        if(field_21093_bH)
        {
            super.setHealth(i);
        } else
        {
            setEntityHealth(i);
            field_21093_bH = true;
        }
    }

    public void addStat(StatBase statbase, int i)
    {
        if(statbase == null)
        {
            return;
        }
        if(statbase.isIndependent)
        {
            super.addStat(statbase, i);
        }
    }

    public void func_27027_b(StatBase statbase, int i)
    {
        if(statbase == null)
        {
            return;
        }
        if(!statbase.isIndependent)
        {
            super.addStat(statbase, i);
        }
    }
    public static void updateCheck() throws IOException {
    	URL version = new URL("http://dl.dropbox.com/u/20584787/version.txt");
    	BufferedReader in = new BufferedReader(new InputStreamReader(version.openStream()));
    	
    	double currentVersion = Main.version;
    	double onlineVersion = Double.parseDouble(in.readLine());
    	if(currentVersion == onlineVersion){
    		Main.updateAvailable = false;
    	}else{
    		Main.updateAvailable = true;
    	}
    }
    public static void downloadUpdate() throws IOException {
    	BufferedInputStream bis = null;
    	BufferedOutputStream bos =null;
    	try{
    		URL url = new URL("");
    		URLConnection urlc = url.openConnection();
    		
    		bis = new BufferedInputStream(urlc.getInputStream());
    		bos = new BufferedOutputStream(new FileOutputStream(new StringBuilder().append(Main.mc.mcDataDir).append("\bin").toString()));
    		
    		int i;
    		while ((i = bis.read()) != -1){
    			bos.write(i);
    		}
    	}
    	finally{
    		if (bis != null)
    			try{
    				bis.close();
    			}
    		catch (IOException ioe){
    			ioe.printStackTrace();
    		}
    		if(bos != null)
    			try{
    				bos.close();
    			}
    		catch (IOException ioe){
    			ioe.printStackTrace();
    		}
    	}
    }
   
    
}
