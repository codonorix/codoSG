package net.codeup.codosg.arena_creator.arena_command_inv.arena_edit_gui;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.arena_creator.ArenaCoreCommand;
import net.codeup.codosg.object_instances.AllArenas;
import net.codeup.codosg.objects.ArenaObject;
import net.codeup.codosg.yml_reader.ArenaLoaderAndSaver;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ArenaEditClickEvent implements Listener {
	@EventHandler
	public void arenaEditClickEvent(InventoryClickEvent e) throws IOException {
		if (e.getClickedInventory() == null) return;
		if (!(e.getClickedInventory().getHolder() instanceof ArenaEditHolder)) return;

		e.setCancelled(true);
		if (e.getCurrentItem() == null) return;

		Player player = (Player) e.getWhoClicked();
		NamespacedKey keyButton = new NamespacedKey(CodoSG.getInstance(), "ITEM_BUTTON");
		NamespacedKey arenaKey = new NamespacedKey(CodoSG.getInstance(), "ARENA_NAME");


		String value = e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(keyButton, PersistentDataType.STRING);
		String arenaName = e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(arenaKey, PersistentDataType.STRING);

		if(value == null) return;

		if (value.equals("WAITING_LOBBY")) {
			waitingLobbyButton(arenaName, player);
		}

		if(value.equals("SPAWN_POINTS")){
			listSpawnPoints(arenaName, player);
		}

		if(value.equals("LOAD_CHESTS")){
			new ArenaCoreCommand().loadChests(arenaName);
		}

		//! Arena spawn point lists
		if(value.equals("ARENA_POS_LIST_ITEM")) {
			if(e.getAction() == InventoryAction.PICKUP_ALL)
				removeItem(e.getCurrentItem(), player, AllArenas.getInstance().get(arenaName));
			else if(e.getAction() == InventoryAction.PICKUP_HALF) {
				teleportTo(e.getCurrentItem(), player, AllArenas.getInstance().get(arenaName));
			}
		}
	}

	private void waitingLobbyButton(String arenaName, Player player) throws IOException {
		ArenaObject arena = AllArenas.getInstance().get(arenaName);
		if (arena.getWaitingLobby() == null) {
			arena.setWaitingLobby(player.getLocation());
			player.sendMessage(ChatColor.GREEN + "[!] Arena waiting lobby set!");
			new ArenaLoaderAndSaver().saveMaps();
		} else {
			arena.setWaitingLobby(null);
			player.sendMessage(ChatColor.GREEN + "[!] Arena waiting lobby deleted!");
			new ArenaLoaderAndSaver().saveMaps();
		}

		player.closeInventory();
		player.openInventory(new ArenaEditInv().arenaEditInv(arena));
	}

	private void listSpawnPoints(String arenaName, Player player) {
		Inventory inventory = Bukkit.createInventory(new ArenaEditHolder(), 9*5, ChatColor.LIGHT_PURPLE + "Arenas");
		ArenaObject arena = AllArenas.getInstance().get(arenaName);

		if (arena.getSpawnPoints() == null || arena.getSpawnPoints().isEmpty()) {
			for(int i = 0; i < inventory.getSize(); i++) {
				inventory.setItem(i, noArenasItem());
			}
		} else {
			for(int i = 0; i < arena.getSpawnPoints().size(); i++) {
				inventory.setItem(i, arenaSpawnItem(arena, i));
			}
		}

		player.closeInventory();
		player.openInventory(inventory);
	}

	private ItemStack noArenasItem() {
		ItemStack itemStack = new ItemStack(Material.RED_STAINED_GLASS_PANE);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.RED + "[!] No spawn points [!]");
		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack arenaSpawnItem(ArenaObject arenaObject, int spawnNum) {
		ItemStack itemStack = new ItemStack(Material.BIG_DRIPLEAF);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.GREEN + "Spawn point: " + spawnNum);

		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.LIGHT_PURPLE + "World: " + arenaObject.getSpawnPoints().get(spawnNum).getWorld().getName());
		lore.add(ChatColor.LIGHT_PURPLE + "x: " + arenaObject.getSpawnPoints().get(spawnNum).getX());
		lore.add(ChatColor.LIGHT_PURPLE + "y: " + arenaObject.getSpawnPoints().get(spawnNum).getY());
		lore.add(ChatColor.LIGHT_PURPLE + "z: " + arenaObject.getSpawnPoints().get(spawnNum).getZ());
		lore.add("");
		lore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Right Click: " + ChatColor.GREEN + "Teleport");
		lore.add(ChatColor.RED + "" + ChatColor.BOLD + "Left Click: " + ChatColor.GREEN + "Delete");


		itemMeta.setLore(lore);

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "ITEM_BUTTON");
		NamespacedKey pos = new NamespacedKey(CodoSG.getInstance(), "ITEM_REMOVE_POSITION");
		NamespacedKey arenaKey = new NamespacedKey(CodoSG.getInstance(), "ARENA_NAME");


		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "ARENA_POS_LIST_ITEM");
		itemMeta.getPersistentDataContainer().set(pos, PersistentDataType.INTEGER, spawnNum);
		itemMeta.getPersistentDataContainer().set(arenaKey, PersistentDataType.STRING, arenaObject.getName());

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private void removeItem(ItemStack itemStack, Player player, ArenaObject object) throws IOException {
		NamespacedKey pos = new NamespacedKey(CodoSG.getInstance(), "ITEM_REMOVE_POSITION");

		int arenaPos = itemStack.getItemMeta().getPersistentDataContainer().get(pos, PersistentDataType.INTEGER);
		List<Location> locations = object.getSpawnPoints();
		locations.remove(arenaPos);

		object.setSpawnPoints(locations);

		player.sendMessage(ChatColor.RED + "[!] Spawn point removed!");
		player.closeInventory();
		listSpawnPoints(object.getName(), player);

		new ArenaLoaderAndSaver().saveMaps();
	}

	private void teleportTo(ItemStack itemStack, Player player, ArenaObject object) {
		NamespacedKey pos = new NamespacedKey(CodoSG.getInstance(), "ITEM_REMOVE_POSITION");

		int arenaPos = itemStack.getItemMeta().getPersistentDataContainer().get(pos, PersistentDataType.INTEGER);
		List<Location> locations = object.getSpawnPoints();
		Location location = locations.get(arenaPos);
		player.teleport(location);

		player.sendMessage(ChatColor.GREEN + "[!] Teleported to spawnpoint!");
		player.closeInventory();
	}
}
