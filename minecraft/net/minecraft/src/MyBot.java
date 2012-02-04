/*package net.minecraft.src;

import net.minecraft.client.Minecraft;

import org.jibble.pircbot.PircBot;

public class MyBot extends PircBot {
	
	String name;
	Minecraft mc;
	IRCCOMMANDS obj;
	String channel;
	
	public MyBot(String name, Minecraft mc){
		this.name = name;
		this.setName(name);
		this.mc = mc;
		obj = new IRCCOMMANDS(mc);
		
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message)
	{
		obj.addChatMessage("\2476" + channel.toUpperCase() + "\247e " + sender + ": \247f" + message);
		return;
	}
	
	

}
*/