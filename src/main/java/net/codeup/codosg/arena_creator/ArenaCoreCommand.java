package net.codeup.codosg.arena_creator;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.arena_creator.arena_command_inv.ListArenasInv;
import net.codeup.codosg.arena_creator.arena_command_inv.arena_edit_gui.ArenaEditInv;
import net.codeup.codosg.items.WeaponItems;
import net.codeup.codosg.object_instances.AllArenas;
import net.codeup.codosg.objects.ArenaObject;
import net.codeup.codosg.yml_reader.ArenaLoaderAndSaver;
import org.bukkit.*;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;
import java.util.*;

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
		if(args.length < 1) {
			player.sendMessage(suggestedEditCommands());
			return;
		}

		if(!AllArenas.getInstance().containsKey(args[1])) {
			player.sendMessage(ChatColor.RED + "[!] Arena " + args[1] + " does not exist!");
			return;
		}

		String arenaName = args[1];


		if(args[2].equalsIgnoreCase("setLobby")) {
			setLobby(player, arenaName);
			return;
		}

		if(args[2].equalsIgnoreCase("setSpawn")) {
			setSpawnPoint(player, arenaName);
			return;
		}

		if(args[2].equalsIgnoreCase("loadChests")) {
			loadChests(player, arenaName);
			return;
		}

		if(args[2].equalsIgnoreCase("gui")) {
			arenaGUI(player,arenaName);
		}

	}

	private void setLobby(Player player, String arenaName) throws IOException {
		ArenaObject arenaObject = AllArenas.getInstance().get(arenaName);
		arenaObject.setWaitingLobby(player.getLocation());
		player.sendMessage(ChatColor.GREEN + "Waiting lobby set!");
		new ArenaLoaderAndSaver().saveMaps();
	}

	private void setSpawnPoint(Player player, String arenaName) throws IOException {
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

	public void loadChests(Player player, String arenaName) throws IOException {
		ArenaObject arenaObject = AllArenas.getInstance().get(arenaName);
		World world = arenaObject.getSpawnPoints().get(0).getWorld();

		ArrayList<Location> chests = new ArrayList<>();
		for(Chunk chunk : world.getLoadedChunks()) {
			for (BlockState blockState : chunk.getTileEntities()) {
				if(blockState instanceof Chest) {
					chests.add(blockState.getLocation());
					Chest chest = (Chest) blockState;
					chest.getBlockInventory().clear();
					ArrayList<ItemStack> itemStacks = new WeaponItems().getInstance();
					Collections.shuffle(itemStacks);
					chest.getBlockInventory().addItem(itemStacks.get(0));
				}
			}
		}

		arenaObject.setChestLocations(chests);
		player.sendMessage("Total chests in arena: " + chests.size());
		new ArenaLoaderAndSaver().saveMaps();
	}

	private void arenaGUI(Player player, String arenaName) {
		ArenaObject arenaObject = AllArenas.getInstance().get(arenaName);
		player.openInventory(new ArenaEditInv().arenaEditInv(arenaObject));
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
		output += ChatColor.GREEN + "loadChests │ Loads all the chests in an arena.\n";
		output += "\n";
		output += ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + "———————————————————————\n";

		return output;
	}
}
