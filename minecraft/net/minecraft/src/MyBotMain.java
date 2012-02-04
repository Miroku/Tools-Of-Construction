/*package net.minecraft.src;

import java.io.IOException;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.jibble.pircbot.PircBot;

import net.minecraft.client.Minecraft;

public class MyBotMain extends PircBot implements Runnable {

	String server;
	String channel;
	String useless;
	String username;
	Minecraft minecraft;
	World world;
	Session sessions;
	NetClientHandler netclienthandler;
	public static MyBot bot;
	public MyBotMain(String username, Minecraft minecraft) {
		this.username = username;
		this.minecraft = minecraft;
	}
	public void run(){
		try{
			
			bot = new MyBot(username , minecraft);
			bot.setVerbose(true);
			bot.connect(server);
			bot.joinChannel(channel);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (NickAlreadyInUseException e) {
			username = username + "1";
			run();
		} catch (IrcException e) {
			e.printStackTrace();
		}
	}
	

}*/
