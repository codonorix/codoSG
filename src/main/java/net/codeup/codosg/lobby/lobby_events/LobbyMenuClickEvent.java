package net.codeup.codosg.lobby.lobby_events;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.lobby.invintories.LobbyItemInvHolder;
import net.codeup.codosg.object_instances.AllKits;
import net.codeup.codosg.object_instances.AllPlayers;
import net.codeup.codosg.objects.KitObject;
import net.codeup.codosg.objects.PlayerObject;
import net.codeup.codosg.yml_reader.PlayerDataSaver;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LobbyMenuClickEvent implements Listener {
	@EventHandler
	public void onLobbyMenuClick(InventoryClickEvent event) throws IOException {
		if(event.getClickedInventory() == null) return;
		if(event.getCurrentItem() == null) return;
		if(!(event.getClickedInventory().getHolder() instanceof LobbyItemInvHolder)) return;

		event.setCancelled(true);

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "LOBBY_ITEM");
		if(event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.STRING) == null) return;

		if(event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.STRING).equals("COMMON_KITS")) {
			commonKits((Player) event.getWhoClicked());
		}

		if(event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.STRING).equals("BUY_KEY")) {
			buyKey((Player) event.getWhoClicked());
		}

	}

	private void commonKits(Player player) {
		Inventory inventory = Bukkit.createInventory(new LobbyItemInvHolder(), 9*5, "Common Kits");
		PlayerObject playerObject = AllPlayers.getInstance().get(player.getUniqueId());
		for(KitObject kitObject : AllKits.getCommonKits()) {
			if(playerObject.getUnlockedKits() == null) playerObject.setUnlockedKits(new HashMap<>());
			if(playerObject.getUnlockedKits().containsKey(kitObject)) {
				ItemStack itemStack = new ItemStack(kitObject.getIcon());
				ItemMeta itemMeta = itemStack.getItemMeta();

				itemMeta.setDisplayName(ChatColor.GREEN + kitObject.getName() + " | " + playerObject.getUnlockedKits().get(kitObject));

				NamespacedKey namespacedKey = new NamespacedKey(CodoSG.getInstance(), "KIT_ITEM");
				itemMeta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.INTEGER, kitObject.getId());

				ArrayList<String> lore = new ArrayList<>();
				lore.add(ChatColor.GREEN + "Left click -> " + ChatColor.BOLD + "Select kit");
				lore.add(ChatColor.LIGHT_PURPLE + "Right click -> " + ChatColor.BOLD + "Upgrade kit");

				itemMeta.setLore(lore);
				itemStack.setItemMeta(itemMeta);
				inventory.addItem(itemStack);
				continue;
			}
			ItemStack itemStack = new ItemStack(kitObject.getIcon());
			ItemMeta itemMeta = itemStack.getItemMeta();
			itemMeta.setDisplayName(ChatColor.GREEN + kitObject.getName() + " | " + ChatColor.RED + "LOCKED");
			NamespacedKey namespacedKey = new NamespacedKey(CodoSG.getInstance(), "KIT_ITEM");
			itemMeta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.INTEGER, kitObject.getId());
			itemStack.setItemMeta(itemMeta);
			inventory.addItem(itemStack);
		}

		player.openInventory(inventory);
	}

	private void buyKey(Player player) throws IOException {
		PlayerObject playerObject = AllPlayers.getInstance().get(player.getUniqueId());

		if(playerObject.getCrystals() < 2500) {
			player.sendMessage(ChatColor.RED + "[!] You don't have enough crystals!");
			return;
		}

		int crystals = playerObject.getCrystals() - 2500;
		playerObject.setCrystals(crystals);

		int keys = playerObject.getKeys();
		keys++;
		playerObject.setKeys(keys);

//		new PlayerDataSaver().saveTables(player);
		player.sendMessage(ChatColor.GREEN + "[!] You bought a key! You now have " + ChatColor.LIGHT_PURPLE + keys + ChatColor.GREEN + " keys!");
	}
}
