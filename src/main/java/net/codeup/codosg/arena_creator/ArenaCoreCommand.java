package net.codeup.codosg.arena_creator;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.arena_creator.arena_command_inv.ListArenasInv;
import net.codeup.codosg.object_instances.AllArenas;
import net.codeup.codosg.objects.ArenaObject;
import net.codeup.codosg.yml_reader.ArenaLoaderAndSaver;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArenaCoreCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;

		if(!(player.hasPermission("codosg.admin"))) {
			player.sendMessage(ChatColor.RED + "[!] You need to be an ADMIN to use this command.");
			return false;
		}

		if(args.length < 1) {
			player.sendMessage(suggestedCommands());
			return false;
		}

		if(args[0].equalsIgnoreCase("list")) {
			ListArenas(player);
			return false;
		}

		if(args[0].equalsIgnoreCase("edit")) {
			try {
				editArena(args, player);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return false;
		}
		return false;
	}

	private void ListArenas(Player player) {
		Inventory inventory = new ListArenasInv().listArenaInv();

		for(ArenaObject arenaObject : AllArenas.getInstance().values()) {
			ItemStack itemStack = new ItemStack(Material.BLUE_STAINED_GLASS, 1);
			ItemMeta itemMeta = itemStack.getItemMeta();

			itemMeta.setDisplayName(arenaObject.getName());

			ArrayList<String> description = new ArrayList<>();

			description.add("Waiting Lobby: " + (arenaObject.getWaitingLobby() == null ? ChatColor.RED + "✘" : ChatColor.GREEN  + "✔"));
			description.add("Spawn Points: " + (arenaObject.getSpawnPoints() == null ? ChatColor.RED + "✘" : ChatColor.GREEN  + "" + arenaObject.getSpawnPoints().size()));
			description.add("Chests: " + (arenaObject.getChestLocations() == null ? ChatColor.RED + "✘" : ChatColor.GREEN  + "" + arenaObject.getChestLocations().size()));

			itemMeta.setLore(description);

			itemStack.setItemMeta(itemMeta);
			inventory.addItem(itemStack);
		}

		player.openInventory(inventory);
	}

	private void editArena(String[] args, Player player) throws IOException {
		if(args.length < 2) {
			player.sendMessage(suggestedEditCommands());
			return;
		}

		if(!AllArenas.getInstance().containsKey(args[1])) {
			player.sendMessage(ChatColor.RED + "[!] Arena " + args[1] + " does not exist!");
			return;
		}

		String arenaName = args[1];

		if(args[2].equalsIgnoreCase("setLobby")) {
			ArenaObject arenaObject = AllArenas.getInstance().get(arenaName);
			arenaObject.setWaitingLobby(player.getLocation());
			player.sendMessage(ChatColor.GREEN + "Waiting lobby set!");
			new ArenaLoaderAndSaver().saveMaps();
			return;
		}

		if(args[2].equalsIgnoreCase("setSpawn")) {
			ArenaObject arenaObject = AllArenas.getInstance().get(arenaName);

			List<Location> locations = new ArrayList<>();

			if(arenaObject.getSpawnPoints() != null) {
				locations = arenaObject.getSpawnPoints();
			}

			locations.add(player.getLocation());
			arenaObject.setSpawnPoints(locations);
			player.sendMessage(ChatColor.GREEN + "Spawn point added!");
			new ArenaLoaderAndSaver().saveMaps();
		}

		if(args[2].equalsIgnoreCase("placeChest")) {
			ArenaObject arenaObject = AllArenas.getInstance().get(arenaName);
			player.getInventory().addItem(chestItem(arenaName));
		}
	}

	private ItemStack chestItem(String arenaName) {
		ItemStack itemStack = new ItemStack(Material.CHEST);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.DARK_PURPLE + arenaName + " chest");
		itemMeta.setLore(new ArrayList<>(Arrays.asList("Place item to add chest to map.")));

		NamespacedKey namespacedKey = new NamespacedKey(CodoSG.getInstance(), arenaName);
		itemMeta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.STRING,arenaName);

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private String suggestedCommands() {
		String output = ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + "———————————————————————\n";
		output += "\n";
		output += ChatColor.GREEN + "list │ List all the current arenas.\n";
		output += ChatColor.GREEN + "edit │ Edit or setup an arena.\n";
		output += ChatColor.GREEN + "remove │ Remove an arena\n";
		output += "\n";
		output += ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + "———————————————————————\n";

		return output;
	}

	private String suggestedEditCommands() {
		String output = ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + "———————————————————————\n";
		output += "\n";
		output += ChatColor.RED + "/arena edit {arena_name} {action}\n";
		output += ChatColor.GREEN + "setLobby │ Sets the map waiting lobby.\n";
		output += ChatColor.GREEN + "setSpawn │ Sets a player spawn location.\n";
		output += ChatColor.GREEN + "placeChest │ Gives you a chest to place that will spawn items.\n";
		output += "\n";
		output += ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + "———————————————————————\n";

		return output;
	}
}
