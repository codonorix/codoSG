package net.codeup.codosg.commands.admin;

import net.codeup.codosg.object_instances.AllPlayers;
import net.codeup.codosg.objects.PlayerObject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CrystalsGive implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(player.hasPermission("codosg.admin"))) return false;

		Player playerGet = (Player) Bukkit.getOfflinePlayer(args[0]);

		PlayerObject playerObject = AllPlayers.getInstance().get(playerGet.getUniqueId());
		int crystals = playerObject.getCrystals();
		crystals += Integer.parseInt(args[1]);
		playerObject.setCrystals(crystals);

		player.sendMessage(ChatColor.GREEN + "[!] Gave " + playerGet.getDisplayName() + " " + args[1] + " crystals!");
		playerGet.sendMessage(ChatColor.GREEN + "[!] You got " + args[1] + " crystals! You now have " + crystals + " crystals!");
		return false;
	}
}