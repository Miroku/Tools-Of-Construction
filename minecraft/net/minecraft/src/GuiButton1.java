// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Gui, RenderEngine

public class GuiButton1 extends Gui
{

    protected int width;
    protected int height;
    public int xPosition;
    public int yPosition;
    public String displayString;
    public int id;
    public boolean enabled;
    public boolean drawButton1;

    public GuiButton1(int i, int j, int k, String s)
    {
        this(i, j, k, 200, 20, s);
    }

    public GuiButton1(int i, int j, int k, int l, int i1, String s)
    {
        width = 200;
        height = 20;
        enabled = true;
        drawButton1 = true;
        id = i;
        xPosition = j;
        yPosition = k;
        width = l;
        height = i1;
        displayString = s;
    }

    protected int getHoverState(boolean flag)
    {
        byte byte0 = 1;
        if(!enabled)
        {
            byte0 = 0;
        } else
        if(flag)
        {
            byte0 = 2;
        }
        return byte0;
    }

    public void drawButton1(Minecraft minecraft, int i, int j)
    {
        if(!drawButton1)
        {
            return;
        }
        FontRenderer fontrenderer = minecraft.fontRenderer;
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, minecraft.renderEngine.getTexture("/gui/gui.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        boolean flag = i >= xPosition && j >= yPosition && i < xPosition + width && j < yPosition + height;
        int k = getHoverState(flag);
        drawTexturedModalRect(xPosition, yPosition, 0, 46 + k * 20, width / 2, height);
        drawTexturedModalRect(xPosition + width / 2, yPosition, 200 - width / 2, 46 + k * 20, width / 2, height);
        mouseDragged(minecraft, i, j);
        if(!enabled)
        {
            drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0xffa0a0a0);
        } else
        if(flag)
        {
            drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0xffffa0);
        } else
        {
            drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0xe0e0e0);
        }
    }

    protected void mouseDragged(Minecraft minecraft, int i, int j)
    {
    }

    public void mouseReleased(int i, int j)
    {
    }

    public boolean mousePressed(Minecraft minecraft, int i, int j)
    {
        return enabled && drawButton1 && i >= xPosition && j >= yPosition && i < xPosition + width && j < yPosition + height;
    }
}
