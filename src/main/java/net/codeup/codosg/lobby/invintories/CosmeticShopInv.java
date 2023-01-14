package net.codeup.codosg.lobby.invintories;

import net.codeup.codosg.CodoSG;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class CosmeticShopInv {
	NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "LOBBY_ITEM");

	public Inventory menu() {
		Inventory inventory = Bukkit.createInventory(new LobbyItemInvHolder(), 9 * 3, ChatColor.LIGHT_PURPLE + "✵ Cosmetics Shop ✵");

		inventory.setItem(10, trails());
		inventory.setItem(12, killMessages());
		inventory.setItem(14, killEffects());
		inventory.setItem(16, deathEffects());

		return inventory;
	}

	private ItemStack trails() {
		ItemStack itemStack = new ItemStack(Material.REDSTONE);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.RED + "Trails");

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "TRAILS");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack killMessages() {
		ItemStack itemStack = new ItemStack(Material.BOOK);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.GOLD + "Kill Messages");

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "KILL_MESSAGES");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack killEffects() {
		ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.AQUA + "Kill Effects");

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "KILL_EFFECTS");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack deathEffects() {
		ItemStack itemStack = new ItemStack(Material.BONE);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.AQUA + "Death Effects");

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "DEATH_EFFECTS");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

}
