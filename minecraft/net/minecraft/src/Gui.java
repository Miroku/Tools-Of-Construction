// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Tessellator, FontRenderer

public class Gui
{

    public Gui()
    {
        zLevel = 0.0F;
    }

    protected void func_27100_a(int i, int j, int k, int l)
    {
        if(j < i)
        {
            int i1 = i;
            i = j;
            j = i1;
        }
        drawRect(i, k, j + 1, k + 1, l);
    }

    protected void func_27099_b(int i, int j, int k, int l)
    {
        if(k < j)
        {
            int i1 = j;
            j = k;
            k = i1;
        }
        drawRect(i, j + 1, i + 1, k, l);
    }

    protected static void drawRect(int i, int j, int k, int l, int i1)
    {
        if(i < k)
        {
            int j1 = i;
            i = k;
            k = j1;
        }
        if(j < l)
        {
            int k1 = j;
            j = l;
            l = k1;
        }
        float f = (float)(i1 >> 24 & 0xff) / 255F;
        float f1 = (float)(i1 >> 16 & 0xff) / 255F;
        float f2 = (float)(i1 >> 8 & 0xff) / 255F;
        float f3 = (float)(i1 & 0xff) / 255F;
        Tessellator tessellator = Tessellator.instance;
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f1, f2, f3, f);
        tessellator.startDrawingQuads();
        tessellator.addVertex(i, l, 0.0D);
        tessellator.addVertex(k, l, 0.0D);
        tessellator.addVertex(k, j, 0.0D);
        tessellator.addVertex(i, j, 0.0D);
        tessellator.draw();
        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        GL11.glDisable(3042 /*GL_BLEND*/);
    }
    
    protected void drawHexagon(int i, int j, int k, int l, int col)
    {
    	int leftX = i + ((k - i) / 6);
    	int rightX = k - ((k - i) / 6);
    	int middleY = j + ((l - j) / 2);
    	float f = (float)(col >> 24 & 0xff) / 255F;
        float f1 = (float)(col >> 16 & 0xff) / 255F;
        float f2 = (float)(col >> 8 & 0xff) / 255F;
        float f3 = (float)(col & 0xff) / 255F;
        Tessellator tesselator = Tessellator.instance;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f1,  f2, f3, f);
        GL11.glBegin(GL11.GL_POLYGON);
        GL11.glVertex2d(leftX, j);
        GL11.glVertex2d(rightX, j);
        GL11.glVertex2d(k, middleY);
        GL11.glVertex2d(rightX, l);
        GL11.glVertex2d(leftX, l);
        GL11.glVertex2d(i, middleY);
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    protected static void drawGradientRect(int i, int j, int k, int l, int i1, int j1)
    {
        float f = (float)(i1 >> 24 & 0xff) / 255F;
        float f1 = (float)(i1 >> 16 & 0xff) / 255F;
        float f2 = (float)(i1 >> 8 & 0xff) / 255F;
        float f3 = (float)(i1 & 0xff) / 255F;
        float f4 = (float)(j1 >> 24 & 0xff) / 255F;
        float f5 = (float)(j1 >> 16 & 0xff) / 255F;
        float f6 = (float)(j1 >> 8 & 0xff) / 255F;
        float f7 = (float)(j1 & 0xff) / 255F;
        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425 /*GL_SMOOTH*/);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(f1, f2, f3, f);
        tessellator.addVertex(k, j, 0.0D);
        tessellator.addVertex(i, j, 0.0D);
        tessellator.setColorRGBA_F(f5, f6, f7, f4);
        tessellator.addVertex(i, l, 0.0D);
        tessellator.addVertex(k, l, 0.0D);
        tessellator.draw();
        GL11.glShadeModel(7424 /*GL_FLAT*/);
        GL11.glDisable(3042 /*GL_BLEND*/);
        GL11.glEnable(3008 /*GL_ALPHA_TEST*/);
        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
    }
    
    public static void drawHollowShape(float cx, float cy, float r, int numSegments, int col)
    {
    	GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
        GL11.glBlendFunc(770, 771);
        GL11.glBegin(GL11.GL_LINE_LOOP);
	    float circle = 2F * ((float)Math.PI) / ((float)numSegments);
	    float c = (float) Math.cos(circle);
	    float s = (float) Math.sin(circle);
	    float y = 0;
	    float f = (float)(col >> 24 & 0xff) / 255F;
	    float f1 = (float)(col >> 16 & 0xff) / 255F;
	    float f2 = (float)(col >> 8 & 0xff) / 255F;
	    float f3 = (float)(col & 0xff) / 255F;
	    GL11.glColor4f(f1, f2, f3, f);
	    for(int ii = 0; ii < numSegments; ii++)
	    {
	        float t = r;
	        r = c * r - s * y;
	        y = s * t + c * y;
	        GL11.glVertex2f(cx + r, cy + y);
	    }
	    GL11.glEnd();
    	GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        GL11.glDisable(3042 /*GL_BLEND*/);
    }
    
    public static void drawShape(float cx, float cy, float r, int col)
    {
    	GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
        GL11.glBlendFunc(770, 771);
    	GL11.glBegin(GL11.GL_POLYGON); 	
    	float f = (float)(col >> 24 & 0xff) / 255F;
        float f1 = (float)(col >> 16 & 0xff) / 255F;
        float f2 = (float)(col >> 8 & 0xff) / 255F;
        float f3 = (float)(col & 0xff) / 255F;
        GL11.glColor4f(f1, f2, f3, f);
    	for(float i = 0.1f; i < 2.0F * (float)Math.PI; i += 0.2)
    	{
    	    cx = (float) (cx + (Math.sin(i) / 5) * r);
    	    cy = (float) (cy + (Math.cos(i) / 5) * r);
    	    GL11.glVertex2f(-r + cx, cy);
    	}
    	GL11.glEnd();
    	GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        GL11.glDisable(3042 /*GL_BLEND*/);
    }
    
    public static void drawBorderCircle(float cx, float cy, float r, int col)
    {
    	drawHollowShape(cx, cy, r, 50, col);
    	drawShape(cx, cy, r, col);
    }
    
    public static void drawBorderRect(int i, int j, int k, int l, int i1, int i2)
    {
    	if(i < k)
        {
            int j1 = i;
            i = k;
            k = j1;
        }
    	if(j < l)
        {
            int k1 = j;
            j = l;
            l = k1;
        }
        drawRect(i, j, k, l, i2);
        drawRect(i, j, i - i1, l, i2);
        drawRect(k + i1, j, k, l, i2);
        drawRect(i - i1, j, k + i1, j - i1, i2);
        drawRect(i - i1, l + i1, k + i1, l, i2);
        
    }
    
    public static void drawHollowRect(int i, int j, int k, int l, int i1, int i2)
    {
    	if(i < k)
        {
            int j1 = i;
            i = k;
            k = j1;
        }
    	if(j < l)
        {
            int k1 = j;
            j = l;
            l = k1;
        }
        drawRect(i, j, i - i1, l, i2);
        drawRect(k + i1, j, k, l, i2);
        drawRect(i - i1, j, k + i1, j - i1, i2);
        drawRect(i - i1, l + i1, k + i1, l, i2);
    }

    public void drawCenteredString(FontRenderer fontrenderer, String s, int i, int j, int k)
    {
        fontrenderer.drawStringWithShadow(s, i - fontrenderer.getStringWidth(s) / 2, j, k);
    }

    public void drawString(FontRenderer fontrenderer, String s, int i, int j, int k)
    {
        fontrenderer.drawStringWithShadow(s, i, j, k);
    }

    public void drawTexturedModalRect(int i, int j, int k, int l, int i1, int j1)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(i + 0, j + j1, zLevel, (float)(k + 0) * f, (float)(l + j1) * f1);
        tessellator.addVertexWithUV(i + i1, j + j1, zLevel, (float)(k + i1) * f, (float)(l + j1) * f1);
        tessellator.addVertexWithUV(i + i1, j + 0, zLevel, (float)(k + i1) * f, (float)(l + 0) * f1);
        tessellator.addVertexWithUV(i + 0, j + 0, zLevel, (float)(k + 0) * f, (float)(l + 0) * f1);
        tessellator.draw();
    }

    protected float zLevel;
    
}