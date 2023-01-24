package net.codeup.codosg.items;

import net.codeup.codosg.CodoSG;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class PowerStar {
	public ItemStack powerStar() {
		ItemStack itemStack = new ItemStack(Material.NETHER_STAR);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "⚝ POWER STAR ⚝");

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "POWER_STAR");
		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "POWER_STAR");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}
}
