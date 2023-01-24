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

import java.util.ArrayList;

public class GameShopInv {
	NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "LOBBY_ITEM");
	public Inventory menu() {
		Inventory inventory = Bukkit.createInventory(new LobbyItemInvHolder(), 9*6, ChatColor.LIGHT_PURPLE + "✵ Game Shop ✵");

		//========================| COMMON KITS |========================\\
		inventory.setItem(0, basicKits(false));
		inventory.setItem(1, basicKits(false));
		inventory.setItem(2, basicKits(false));

		inventory.setItem(9, basicKits(false));
		inventory.setItem(10, basicKits(true));
		inventory.setItem(11, basicKits(false));

		inventory.setItem(18, basicKits(false));
		inventory.setItem(19, basicKits(false));
		inventory.setItem(20, basicKits(false));

		//========================| RARE KITS |========================\\
		inventory.setItem(3, rareKits(false));
		inventory.setItem(4, rareKits(false));
		inventory.setItem(5, rareKits(false));

		inventory.setItem(12, rareKits(false));
		inventory.setItem(13, rareKits(true));
		inventory.setItem(14, rareKits(false));

		inventory.setItem(21, rareKits(false));
		inventory.setItem(22, rareKits(false));
		inventory.setItem(23, rareKits(false));

		//========================| EPIC KITS |========================\\
		inventory.setItem(6, epicKits(false));
		inventory.setItem(7, epicKits(false));
		inventory.setItem(8, epicKits(false));

		inventory.setItem(15, epicKits(false));
		inventory.setItem(16, epicKits(true));
		inventory.setItem(17, epicKits(false));

		inventory.setItem(24, epicKits(false));
		inventory.setItem(25, epicKits(false));
		inventory.setItem(26, epicKits(false));

		//========================| POWERUPS |========================\\
		inventory.setItem(27, powerUps(false));
		inventory.setItem(28, powerUps(false));
		inventory.setItem(29, powerUps(false));

		inventory.setItem(36, powerUps(false));
		inventory.setItem(37, powerUps(true));
		inventory.setItem(38, powerUps(false));

		inventory.setItem(45, powerUps(false));
		inventory.setItem(46, powerUps(false));
		inventory.setItem(47, powerUps(false));

		inventory.setItem(40, blank());

		//========================| BUYKEYS |========================\\
		inventory.setItem(33, buyKey(false));
		inventory.setItem(34, buyKey(false));
		inventory.setItem(35, buyKey(false));

		inventory.setItem(42, buyKey(false));
		inventory.setItem(43, buyKey(true));
		inventory.setItem(44, buyKey(false));

		inventory.setItem(51, buyKey(false));
		inventory.setItem(52, buyKey(false));
		inventory.setItem(53, buyKey(false));


		return inventory;
	}

	private ItemStack basicKits(Boolean addTexture) {
		ItemStack itemStack = new ItemStack(Material.APPLE);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.GREEN + "Common Kits");

		if(addTexture) {
			itemMeta.setCustomModelData(1);
		}

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "COMMON_KITS");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack rareKits(Boolean addTexture) {
		ItemStack itemStack = new ItemStack(Material.APPLE);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.BLUE + "Rare Kits");

		if(addTexture) itemMeta.setCustomModelData(2);

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "RARE_KITS");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack epicKits(Boolean addTexture) {
		ItemStack itemStack = new ItemStack(Material.APPLE);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.DARK_PURPLE + "Epic Kits");

		if(addTexture) itemMeta.setCustomModelData(3);
		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "EPIC_KITS");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack powerUps(Boolean addTexture) {
		ItemStack itemStack = new ItemStack(Material.APPLE);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Power Ups");

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "POWER_UPS");

		if(addTexture) itemMeta.setCustomModelData(4);

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack buyKey(Boolean addTexture) {
		ItemStack itemStack = new ItemStack(Material.APPLE);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.AQUA + "Buy a Key");

		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "BUY_KEY");

		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.WHITE + "Buy a Key to use at the kit table");
		lore.add("");
		lore.add(ChatColor.WHITE + "1 key = " + ChatColor.LIGHT_PURPLE + " 2500 Crystals");

		itemMeta.setLore(lore);

		if(addTexture) itemMeta.setCustomModelData(5);

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	private ItemStack blank() {
		ItemStack itemStack = new ItemStack(Material.APPLE);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(" ");

//		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "POWER_UPS");

		itemMeta.setCustomModelData(999);
		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}
}
