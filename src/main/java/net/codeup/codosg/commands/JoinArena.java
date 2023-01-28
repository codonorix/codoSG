package net.codeup.codosg.commands;

import net.codeup.codosg.object_instances.AllArenas;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinArena implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) return false;

		Player player = (Player) sender;
		if(args.length == 0) {
			player.sendMessage(ChatColor.RED + "[!] No arena name!");
			return false;
		}

		if(!(AllArenas.getInstance().containsKey(args[0].toLowerCase()))) {
			player.sendMessage(ChatColor.RED + "[!] Arena does not exist!");
			return false;
		}

		player.teleport(AllArenas.getInstance().get(args[0].toLowerCase()).getArenaObject().getWaitingLobby());
		return false;
	}
}
