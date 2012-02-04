package net.minecraft.echo;
 
import org.lwjgl.opengl.GL11;
 
import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
 
public class ON_or_OFF extends GuiButton{
 
        public ON_or_OFF(int id, int x, int y,int i, int z, String text) {
                super(id,x,y,22,z,text);
 
        }
        public void drawButton(Minecraft mc, int mx, int my){
                        FontRenderer fontrenderer = mc.fontRenderer;
                drawBorderedRect(xPosition, yPosition,xPosition+26,yPosition+10, 1, 0xff5e5e5e, 0xff525252);
                drawSmallString(displayString, xPosition+5, yPosition+3, 0xffffff);
        }
    public void drawBorderedRect(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        drawRect(i + i1, j + i1, k - i1, l - i1, k1);
        drawRect(i + i1, j + i1, k, j, j1);
        drawRect(i, j, i + i1, l, j1);
        drawRect(k, l, k - i1, j + i1, j1);
        drawRect(i, l - i1, k, l, j1);
    }
    public void drawSmallString(String text, int x, int y, int color) {
        FontRenderer fontrenderer = Minecraft.fontRenderer;
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        fontrenderer.drawStringWithShadow(text, x * 2, y * 2, color);
        GL11.glScalef(2F, 2F, 2F);
    }
 
}


//USE LIEK DIZ For you morons call it by:
//controlList.add(new ON_or_OFF(21,LeftSideX+80 , LeftSideY+17,22,9, base.Diamond ? "Disable" : "Enable"));