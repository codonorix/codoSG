package net.codeup.codosg.lobby.invintories;

import net.codeup.codosg.CodoSG;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class GameShopInv {
	NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "LOBBY_ITEM");
	public Inventory menu() {
		Inventory inventory = Bukkit.createInventory(new LobbyItemInvHolder(), 9*3, ChatColor.LIGHT_PURPLE + "✵ Game Shop ✵");

		inventory.setItem(10, basicKits());
		inventory.setItem(12, rareKits());
		inventory.setItem(14, EpicKits());
		inventory.setItem(16, powerUps());

		return inventory;
	}

	private ItemStack basicKits() {
		ItemStack itemStack = new ItemStack(Material.WOODEN_SWORD);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.GREEN + "Common Kits");

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "COMMON_KITS");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack rareKits() {
		ItemStack itemStack = new ItemStack(Material.IRON_SWORD);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.BLUE + "Rare Kits");

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "RARE_KITS");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack EpicKits() {
		ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.BLUE + "Rare Kits");

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "EPIC_KITS");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack powerUps() {
		ItemStack itemStack = new ItemStack(Material.NETHER_STAR);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Power Ups");

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "POWER_UPS");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}
}
