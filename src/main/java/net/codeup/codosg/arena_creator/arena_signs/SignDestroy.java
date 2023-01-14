package net.codeup.codosg.arena_creator.arena_signs;

import net.codeup.codosg.object_instances.AllJoinSigns;
import net.codeup.codosg.yml_reader.JoinSignLoaderAndSaver;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.io.IOException;

public class SignDestroy implements Listener {
	@EventHandler
	public void gameSignDestroy(BlockBreakEvent event) throws IOException {
		if(!(event.getBlock().getState() instanceof Sign)) return;
		Sign sign = (Sign) event.getBlock().getState();

		if(!(sign.getLine(0).contains("⦓JOIN⦔"))) return;

		String arenaName = sign.getLine(1);
		AllJoinSigns.getInstance().get(arenaName).remove(event.getBlock().getLocation());

		new JoinSignLoaderAndSaver().saveSigns();
	}
}
