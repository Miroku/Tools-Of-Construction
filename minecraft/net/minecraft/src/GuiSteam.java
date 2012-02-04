// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.awt.MouseInfo;
import java.io.*;
import java.net.*;
import java.util.*;

import org.lwjgl.input.*;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GameSettings, GuiSmallButton, 
//            GuiButton, KeyBinding

public class GuiSteam extends GuiScreen
{

    public GuiSteam(GuiScreen guiscreen)
    {
        screenTitle = "Steam";
        buttonId = -1;
        parentScreen = guiscreen;
    }

    public void initGui()
    {
    	controlList.add(new GuiButton(1, width / 2 - 25, height - 22, 50, 20, "Back"));
        screenTitle = "Steam";
        controlList.clear();
    }    

    protected void actionPerformed(GuiButton guibutton)
    {
    	if(guibutton.id == 1)
    	{
    		mc.displayGuiScreen(null);
    	}
    }

    protected void mouseClicked(int i, int j, int k)
    {
        if(buttonId >= 0)
        {
            options.setKeyBinding(buttonId, -100 + k);
            ((GuiButton)controlList.get(buttonId)).displayString = options.getOptionDisplayString(buttonId);
            buttonId = -1;
            KeyBinding.resetKeyBindingArrayAndHash();
        } else
        {
            super.mouseClicked(i, j, k);
        }
    }
    
    public void drawArrow(int x, int y, int color, boolean up)
    {
    	drawRect(x + 1, y + (up ? -1 : 1), x, y, color);
    	drawRect(x + 2, y + (up ? -2 : 2), x + 1, y, color);
    	drawRect(x + 3, y + (up ? -3 : 3), x + 2, y, color);
    	drawRect(x + 4, y + (up ? -4 : 4), x + 3, y, color);
    	drawRect(x + 5, y + (up ? -3 : 3), x + 4, y, color);
    	drawRect(x + 6, y + (up ? -2 : 2), x + 5, y, color);
    	drawRect(x + 7, y + (up ? -1 : 1), x + 6, y, color);
    }

	public boolean isMouseDown()
	{
		return Mouse.isButtonDown(0);
	}
	
	public static boolean isHovering(int x1, int y1, int x2, int y2)
    {
        int test = 2;
        drawRect(x1 * test, y1 * test, x2 * test, y2 * test, 0x20ff);
        return ((lastX >= x1 && lastX <= x2) && (lastY >= y1 && lastY <= y2));
    }
	
	
	public void drawArrows()
	{
		String name = mc.session.username;
		int nameLength = fontRenderer.getStringWidth(name);
		
		if(isHovering(35, 25, 40, 29) && !isMouseDown())
        {
        	drawArrow(72, 52, 0xffffffff, false);
        }else
        {
        	drawArrow(72, 52, 0xffb0b0b0, false);
        }
		
        if(isHovering(41 + (nameLength), 25, 46, 29) && !isMouseDown())
        {
            drawArrow(82 + (fontRenderer.getStringWidth(name)), 74, 0xffffffff, false);
        }else
        {
        	drawArrow(82 + (fontRenderer.getStringWidth(name)), 74, 0xffb0b0b0, false);
        }
	}
	
	public void drawChatBg(int x, int y, boolean flipcol)
	{
    	drawGradientRect(x + 140, y + 110, x, y, (flipcol ? 0xff272727 : 0xff303030), (flipcol ? 0xff303030 : 0xff272727));
	}
	
    public void drawScreen(int i, int j, float f)
    {
        drawDefaultBackground();
        fontRenderer.drawString("Friends", 2, GuiScreen.height - 11, (isHovering(1, GuiScreen.height - 12, fontRenderer.getStringWidth("Friends") + 2, GuiScreen.height - 3) ? 0xa0a0a0 : 0xffffff));
        fontRenderer.drawString("Message", 50, GuiScreen.height - 11, (isHovering(49, GuiScreen.height - 62, fontRenderer.getStringWidth("Message") + 2, GuiScreen.height - 3) ? 0xa0a0a0 : 0xffffff));
        if(isHovering(1, GuiScreen.height - 12, fontRenderer.getStringWidth("Friends") + 2, GuiScreen.height - 3) && isMouseDown() && !friends)
        {
        	friends = true;
        }
        if(friends)
        {
        	ArrayList msg = new ArrayList();
        	drawGradientRect(10, 20, 110, 210, 0xff303030, 0xff272727);
        	fontRenderer.drawString("_", 90, 21, (isHovering(89, 23, 96, 30) ? 0xffffff : 0xa0a0a0));
        	if((isHovering(89, 23, 96, 30) || isHovering(99, 23, 106, 30)) && isMouseDown())
        	{
        		friends = false;
        	}
        	drawGradientRect(15, 72, 105, 195, 0xff333333, 0xff383838);
        	fontRenderer.drawString("x", 100, 22, (isHovering(99, 23, 106, 30) && !isMouseDown() ? 0xffffff : 0xa0a0a0));
        	GL11.glScalef(0.5F, 0.5F, 0.5F);
        	drawHollowRect(10 * 2, 20 * 2, 110 * 2, 210 * 2, 1, 0xff000000);
        	GL11.glScalef(2F, 2F, 2F);
        	if(friendsTab)
        	{
        		drawRect(46, 62, 80, 71, (isHovering(46, 62, 80, 71) && !isMouseDown() ? 0xff505050 : 0xff444444));
        	}
        	drawGradientRect(15, 62, 45, 72, 0xff404040, 0xff333333);
        	GL11.glScalef(0.5F, 0.5F, 0.5F);
        	fontRenderer.drawString("Friends", 30, 50, 0xa0a0a0);
        	fontRenderer.drawString("FRIENDS", 36, 130, 0xa0a0a0);
        	fontRenderer.drawString("GROUPS", 96, 130, (isHovering(46, 62, 80, 71) && !isMouseDown() ? 0xffffff : 0xa0a0a0));
        	drawRect(30, 68, 70, 108, 0xff99ff66);
        	drawRect(32, 70, 68, 106, 0xff444444);
        	fontRenderer.drawString("+", 33, 400, (isHovering(15, 199, 58, 204) && !isMouseDown() ? 0xffffff : 0xa0a0a0));
        	fontRenderer.drawString("ADD A FRIEND...", 43, 400, (isHovering(15, 199, 58, 204) && !isMouseDown() ? 0xffffff : 0xa0a0a0));
        	fontRenderer.drawString(".", 212, 399, 0xa0a0a0);
        	fontRenderer.drawString(".", 212, 403, 0xa0a0a0);
        	fontRenderer.drawString(".", 208, 403, 0xa0a0a0);
        	fontRenderer.drawString(".", 212, 407, 0xa0a0a0);
        	fontRenderer.drawString(".", 204, 407, 0xa0a0a0);
        	fontRenderer.drawString(".", 208, 407, 0xa0a0a0);
        	fontRenderer.drawString(mc.session.username, 78, 72, 0x99ff66);
        	fontRenderer.drawString("Ingame", 78, 82, 0x99ff66);
        	drawArrows();
        	GL11.glScalef(2F, 2F, 2F);
        	fontRenderer.drawString("?", 23, 40, 0xe0e0e0);
        }
        if(messageWindow)
        {
        	drawChatBg(115, 100, false);
        	GL11.glScalef(0.5F, 0.5F, 0.5F);
        	drawHollowRect(230, 200, 510, 420, 1, 0xff000000);
        	GL11.glScalef(2F, 2F, 2F);
        	fontRenderer.drawString("x", 246, 101, 0xffffff);
        	fontRenderer.drawString("_", 236, 100, 0xffffff);
        	if(isHovering(245, 102, 256, 111) && isMouseDown())
            {
            	friends = true;
            }
	    //Was going to implement an irc chat for the messaging system to actually work, but like I said, this is an abandoned project...
        }
        super.drawScreen(i, j, f);
    }
    public static void SteamAnimateMenu(int ypos, int animlength)
    {
            if(ypos > 0)
            {
                    ypos = 0;
            }
            if(ypos < -40)
            {
                    ypos = -40;
            }
            drawGradientRect(GuiScreen.width - 100, ypos, GuiScreen.width, ypos + 40, 0xff222222, 0xff343434);
            drawHollowRect(GuiScreen.width - 100, ypos, GuiScreen.width, ypos + 40, 1, 0xff222222);
            drawRect(GuiScreen.width - 99, ypos + 30, GuiScreen.width - 1, ypos + 39, 0xff000000);
            drawRect(GuiScreen.width - 95, ypos + 5, GuiScreen.width - 75, ypos + 25, 0xff99ff66);
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            drawRect((GuiScreen.width) * 2 - 188, (ypos * 2) + 12, (GuiScreen.width - 76) * 2, (ypos * 2) + 48, 0xff3399ff);
            fontRenderer.drawString((mc.session.username.startsWith("Player") && mc.session.username.length() == 9 ? "User Not Authenticated" : mc.session.username), GuiScreen.width * 2 - 140, (ypos * 2) + 15, 0x99ff66);
            fontRenderer.drawString("is now playing", GuiScreen.width * 2 - 140, (ypos * 2) + 25, 0xe0e0e0);
            fontRenderer.drawString("Minecraft", GuiScreen.width * 2 - 140, (ypos * 2) + 35, 0x99ff66);
            fontRenderer.drawString("Press Shift+Tab to begin", GuiScreen.width * 2 - 160, (ypos * 2) + 65, 0xe0e0e0);
            GL11.glScalef(4F, 4F, 4F);
            fontRenderer.drawString("F", GuiScreen.width / 2 - 44, (ypos / 2) + 4, 0x000000);
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            drawRect((GuiScreen.width - 94), ypos + 6, (GuiScreen.width - 75), ypos + 16, 0x50ffffff);
            boolean focused = mc.inGameHasFocus;
            boolean animating = false;
			if(Keyboard.isKeyDown(Keyboard.KEY_TAB))//Change if statement to whatever you want to trigger the animation. Change the integer animlength to however long you want it to stay on the screen.
            {
                    animating = true;
            }
            if(animating)
            {
                    int animtime = 5;
					int inty = 5;
					if(animtime < animlength && focused)
                    {
                            animtime++;
                            inty++;
                    }else
                    {
                            if(inty <= 0)
                            {
                                    inty--;
                            }else
                            {
                                    inty = 0;
                            }
                            if(inty <= -40)
                            {
                                    animating = false;
                                    animtime = 0;
                            }
                    }
            }
    }
  
    
    private GuiScreen parentScreen;
    protected String screenTitle;
    private GameSettings options;
    public static int lastX = -1;
	public static int lastY = -1;
	public static boolean friendsTab = true;
	public static boolean messageWindow = true;
	public static boolean groupsTab = false;
	public static boolean friends = true;
    private int buttonId;
}