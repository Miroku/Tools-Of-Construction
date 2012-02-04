// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, EntityPlayerSP, GuiIngame, ChatAllowedCharacters

public class GuiConsole extends GuiScreen
{

    protected String message;
    private int updateCounter;
    private static final String allowedCharacters;

    public GuiConsole()
    {
        message = "";
        updateCounter = 0;
    }

    public void initGui()
    {
        Keyboard.enableRepeatEvents(true);
    }

    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }

    public void updateScreen()
    {
        updateCounter++;
    }

    protected void keyTyped(char c, int i)
    {
    	if(c == '\026') {
    	    String cb = GuiScreen.getClipboardString();
    	    if(cb != null) {
    	        message += cb;
    	    }
    	}
    	
        if(i == 1)
        {
            mc.displayGuiScreen(null);
            return;
        }
        if(i == 28)
        {
          String s = message.trim();
          //We will be using this space later.
          mc.displayGuiScreen(null);
          return;
        }
        
        if(i == 14 && message.length() > 0)
        {
            message = message.substring(0, message.length() - 1);
        }
        if(allowedCharacters.indexOf(c) >= 0 && message.length() < 100)
        {
            message += c;
        }
    }

    public void drawScreen(int i, int j, float f)
    {
        drawRect(2, 2, width - 2, 14, 0x800);
        drawString(fontRenderer, (new StringBuilder()).append("# ").append(message).append((updateCounter / 6) % 2 != 0 ? "" : "_").toString(), 4, 4, 0xe0e0e0);
        super.drawScreen(i, j, f);
    }

    protected void mouseClicked(int i, int j, int k)
    {
        super.mouseClicked(i, j, k);
        if(k != 0)
        {
            return;
        }
        if(mc.ingameGUI.field_933_a == null)
        {
            return;
        }
        if(message.length() > 0 && !message.endsWith(" "))
        {
            message += " ";
        }
        message += mc.ingameGUI.field_933_a;
        byte byte0 = 100;
        if(message.length() > byte0)
        {
            message = message.substring(0, byte0);
        }
    }

    static 
    {
        allowedCharacters = ChatAllowedCharacters.allowedCharacters;
    }
}
