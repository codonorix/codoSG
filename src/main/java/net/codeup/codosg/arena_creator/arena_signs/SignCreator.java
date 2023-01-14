package net.codeup.codosg.arena_creator.arena_signs;

import net.codeup.codosg.object_instances.AllArenas;
import net.codeup.codosg.object_instances.AllJoinSigns;
import net.codeup.codosg.yml_reader.JoinSignLoaderAndSaver;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import java.io.IOException;
import java.util.ArrayList;

public class SignCreator implements Listener {
	@EventHandler
	public void arenaSignCreator(SignChangeEvent event) throws IOException {
		if(!(event.getLine(0).equalsIgnoreCase("[sg]"))) return;

		if(!(AllArenas.getInstance().containsKey(event.getLine(1)))) {
			event.setLine(0, ChatColor.RED + "[ERROR]");
			event.setLine(1, "Arena not found.");
			return;
		}
		String arenaName = event.getLine(1);

		event.setLine(0, ChatColor.GREEN + "⦓JOIN⦔");
		event.setLine(1, event.getLine(1));
		event.setLine(2, ChatColor.WHITE + "0/" + AllArenas.getInstance().get(arenaName).getSpawnPoints().size());
		event.setLine(3, ChatColor.LIGHT_PURPLE + "-=+=-");

		if(AllJoinSigns.getInstance().containsKey(arenaName)){
			AllJoinSigns.getInstance().get(arenaName).add(event.getBlock().getLocation());
//			event.getPlayer().sendMessage(String.valueOf(AllJoinSigns.getInstance().get(arenaName)));
		}else{
			ArrayList<Location> locations = new ArrayList<>();
			locations.add(event.getBlock().getLocation());
			AllJoinSigns.getInstance().put(arenaName, locations);
//			event.getPlayer().sendMessage(String.valueOf(AllJoinSigns.getInstance().get(arenaName)));
		}

		new JoinSignLoaderAndSaver().saveSigns();
	}
}
