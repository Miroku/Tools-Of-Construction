package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;

public class Hack {

    public static boolean done = false;
   
   
    public static List<String> l = new ArrayList<String>();

    public static void onLoop()
    {
        if(!done)
            return;

        new Thread(){
            public void run(){
                done = false;
                try
                {
        Thread.sleep(new Random().nextInt(7500));
       
        
                }

    public void onDupe()
    {
        new Thread(){
            public void run(){
                done = false;
                try
                {
        Minecraft.theMinecraft.ingameGUI.addChatMessage("\247cDuping..");
        Thread.sleep(3000);

        ItemStack i1 = Minecraft.theMinecraft.thePlayer.inventory.getCurrentItem();
        int theInt = i1.stackSize;
        i1.stackSize = i1.stackSize >= 32 ? 64 : i1.stackSize * 2;

        Minecraft.theMinecraft.thePlayer.inventory.setInventorySlotContents(Minecra​ft.theMinecraft.thePlayer.inventory.currentItem, i1);

        Minecraft.theMinecraft.ingameGUI.addChatMessage("\247aDuped! Maximum possible was: \247c" + (i1.stackSize - theInt));

                }
                catch(Exception e)
                {
        e.printStackTrace();
                }
                done = true;
            }
        }.start();
    }
}