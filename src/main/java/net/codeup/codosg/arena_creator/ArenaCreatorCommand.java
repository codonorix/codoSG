package net.codeup.codosg.arena_creator;

import net.codeup.codosg.object_instances.AllArenas;
import net.codeup.codosg.objects.ArenaObject;
import net.codeup.codosg.yml_reader.ArenaLoaderAndSaver;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.io.IOException;

public class ArenaCreatorCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) return false;

		Player player = (Player) sender;
		if(args.length != 1) {
			player.sendMessage(commandSyntax());
			return false;
		}

		if(AllArenas.getInstance().containsKey(args[0])) {
			player.sendMessage(arenaInUse(args[0]));
			return false;
		}

		ArenaObject arenaObject = new ArenaObject(AllArenas.getInstance().size(), args[0], null, null,null,false);
		AllArenas.getInstance().put(args[0], arenaObject);

		try {
			new ArenaLoaderAndSaver().saveMaps();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		player.sendMessage(arenaCreated(args[0]));

		return false;
	}

	private String commandSyntax() {
		String output = ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + "------------------------\n";
		output += "\n";
		output += ChatColor.RED + "Error :(\n";
		output += "\n";
		output += "{} - Required\n";
		output += "[] - Optional\n";
		output += "\n";
		output += ChatColor.RED + "/createArena {arena name}\n";
		output += "\n";
		output += ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + "------------------------\n";

		return output;
	}

	private String arenaInUse(String arenaName) {
		String output = ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + "———————————————————————\n";
		output += "\n";
		output += ChatColor.RED + "Error :(\n";
		output += "\n";
		output += ChatColor.RED + arenaName + " is already used.\n";
		output += "\n";
		output += ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + "———————————————————————\n";

		return output;
	}

	private String arenaCreated(String arenaName) {
		String output = ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + "———————————————————————\n";
		output += "\n";
		output += ChatColor.GREEN + "Success! :)\n";
		output += "\n";
		output += ChatColor.GREEN + arenaName + " has been created.\n";
		output += "\n";
		output += ChatColor.GREEN + "use /arena edit to edit and setup the arena.\n";
		output += "\n";
		output += ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + "———————————————————————\n";

		return output;
	}
}
