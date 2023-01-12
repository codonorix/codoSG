package net.codeup.codosg.arena_creator.arena_command_inv.arena_edit_gui;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.objects.ArenaObject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class ArenaEditInv {
	public Inventory arenaEditInv(ArenaObject arenaObject) {
		Inventory inventory = Bukkit.createInventory(new ArenaEditHolder(), 9, ChatColor.LIGHT_PURPLE + arenaObject.getName());
		inventory.setItem(3, waitingLobby(arenaObject));
		inventory.setItem(4, listSpawnPoints(arenaObject));
		inventory.setItem(5, loadChests(arenaObject));

		return inventory;
	}

	private ItemStack waitingLobby(ArenaObject arenaObject) {
		ItemStack itemStack = new ItemStack(Material.CLOCK);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Waiting Lobby");

		ArrayList<String> list = new ArrayList<>();

		if(arenaObject.getWaitingLobby() == null) {
			list.add(ChatColor.RED + "No waiting lobby set!");
			list.add(ChatColor.GREEN + "");
			list.add(ChatColor.GREEN + "Click to set the lobby!");
		}else {
			list.add(ChatColor.WHITE + "Location: ");
			list.add(ChatColor.WHITE + "World: " + ChatColor.LIGHT_PURPLE + "" + arenaObject.getWaitingLobby().getWorld().getName());
			list.add(ChatColor.WHITE + "X: " + ChatColor.LIGHT_PURPLE + "" + arenaObject.getWaitingLobby().getX());
			list.add(ChatColor.WHITE + "Y: " + ChatColor.LIGHT_PURPLE + "" + arenaObject.getWaitingLobby().getY());
			list.add(ChatColor.WHITE + "Z: " + ChatColor.LIGHT_PURPLE + "" + arenaObject.getWaitingLobby().getZ());
			list.add("");
			list.add(ChatColor.RED + "" + ChatColor.BOLD + "Click to remove spawn");
		}
		itemMeta.setLore(list);

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "ITEM_BUTTON");
		NamespacedKey arenaKey = new NamespacedKey(CodoSG.getInstance(), "ARENA_NAME");

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "WAITING_LOBBY");
		itemMeta.getPersistentDataContainer().set(arenaKey, PersistentDataType.STRING, arenaObject.getName());

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack listSpawnPoints(ArenaObject arenaObject) {
		ItemStack itemStack = new ItemStack(Material.RESPAWN_ANCHOR);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Spawn Points");

		ArrayList<String> list = new ArrayList<>();

		list.add(ChatColor.GREEN + "Click to view all map spawn points!");
		itemMeta.setLore(list);

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "ITEM_BUTTON");
		NamespacedKey arenaKey = new NamespacedKey(CodoSG.getInstance(), "ARENA_NAME");

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "SPAWN_POINTS");
		itemMeta.getPersistentDataContainer().set(arenaKey, PersistentDataType.STRING, arenaObject.getName());

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack loadChests(ArenaObject arenaObject) {
		ItemStack itemStack = new ItemStack(Material.CHEST);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Load Chests");

		ArrayList<String> list = new ArrayList<>();

		list.add(ChatColor.GREEN + "Click to load all the chests in a map.");
		itemMeta.setLore(list);

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "ITEM_BUTTON");
		NamespacedKey arenaKey = new NamespacedKey(CodoSG.getInstance(), "ARENA_NAME");

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "LOAD_CHESTS");
		itemMeta.getPersistentDataContainer().set(arenaKey, PersistentDataType.STRING, arenaObject.getName());

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}
}
