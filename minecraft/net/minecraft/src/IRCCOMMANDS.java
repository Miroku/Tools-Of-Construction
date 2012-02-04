package net.minecraft.src;

/*import net.minecraft.client.Minecraft;
import java.io.IOException;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;

public class IRCCOMMANDS {
	public Minecraft mc;
	String server;
	String channel;
	String useless;
	String username;
	Minecraft minecraft;
	World world;
	Session session;
	NetClientHandler netclienthandler;
	private NetClientHandler sendQueue;
	
	
	
	public IRCCOMMANDS(Minecraft minecraft, Session session, NetClientHandler netclienthandler)
	{
		sendQueue = netclienthandler;
		username = session.username;
		mc = minecraft;
	}
	public IRCCOMMANDS(Minecraft mc)
	{
		this.mc = mc;
	}

	public void addChatMessage(String s) {
		mc.ingameGUI.addChatMessageTranslate(s);
		
	}
	 public void sendChatMessage(String s)
	    {
		 if(s.startsWith("~"))
		 {
			 String ircMessage = s.substring(1);
			 MyBotMain.bot.sendMessage(channel,ircMessage);
			 return;
		 }
	    	if(s.toLowerCase().startsWith(".connect"))
	    	{
	    		try{
	    			MyBotMain thisBot =new MyBotMain(username, mc);
	    			new Thread(thisBot).start();
	    			return;
	    		} catch (Exception e) {
	    			addChatMessage("\247cI'm Sorry ,there was an error.");
	    			addChatMessage("\247cPlease wait a minute before trying again.");
	    		}
	    	}
	    	

}
}*/
