package net.codeup.codosg.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.data.type.Switch;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemCreator {
	protected static ItemStack itemCreator(String name, ArrayList<String> lore, ArrayList<Enchantment> enchantments, Material material, int amount, int rarity) {
		ItemStack itemStack = new ItemStack(material, amount);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(name);
		ArrayList<String> itemDescription = new ArrayList<>();

		if(lore != null) {
			itemDescription.addAll(lore);
		}

		itemDescription.add(addRarity(rarity));
		itemMeta.setLore(itemDescription);

//		if(enchantments != null) itemMeta.addEnchant() TODO - Add enchantment

		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}

	private static String addRarity(int rarity) {
		String output = "";
		switch (rarity) {
			case 0:
				return output + ChatColor.GRAY + "COMMON";
			case 1:
				return output + ChatColor.GREEN + "UNCOMMON";
			case 2:
				return output + ChatColor.BLUE + "RARE";
			case 3:
				return output + ChatColor.DARK_PURPLE + "EPIC";
			case 4:
				return output + ChatColor.GOLD + "Legendary";
			case 5:
				return output + ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "✪" + ChatColor.LIGHT_PURPLE + " MYTHICAL " + ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "✪";
		}
		return "ERR";
	}
}
