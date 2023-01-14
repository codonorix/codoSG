package net.codeup.codosg.lobby.lobby_items;

import net.codeup.codosg.CodoSG;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class LobbyItems {
	public void giveItems(Player player) {
		Inventory inventory = player.getInventory();
		inventory.setItem(0, serverSelector());
		inventory.setItem(1, shopItem());
		inventory.setItem(4, gameCosmetics());
		inventory.setItem(7, profile());
		inventory.setItem(8, irlShop());
	}

	private ItemStack serverSelector() {
		ItemStack itemStack = new ItemStack(Material.COMPASS);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "〘Server Selector〙");

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "LOBBY_ITEM");
		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "SERVER_SELECTOR");

		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}

	private ItemStack shopItem() {
		ItemStack itemStack = new ItemStack(Material.EMERALD);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "〘Game Shop〙");

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "LOBBY_ITEM");
		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "GAME_SHOP_ITEM");

		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}

	private ItemStack gameCosmetics() {
		ItemStack itemStack = new ItemStack(Material.PISTON);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "〘Cosmetics Shop〙");

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "LOBBY_ITEM");
		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "COSMETIC_SHOP_ITEM");

		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}

	private ItemStack profile() {
		ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "〘Profile〙");

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "LOBBY_ITEM");
		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "PROFILE_ITEM");

		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}

	private ItemStack irlShop() {
		ItemStack itemStack = new ItemStack(Material.DIAMOND);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "〘Online Store〙");

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "LOBBY_ITEM");
		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "ONLINE_STORE_ITEM");

		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}
}
