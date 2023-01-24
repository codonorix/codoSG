package net.codeup.codosg.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KitItemCreator {
	public ItemStack kitItem(Material material, String name, HashMap<Enchantment, Integer> enchants, int amount) {
		ItemStack itemStack = new ItemStack(material, amount);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(name);

		if(enchants != null) {
			for(Map.Entry<Enchantment, Integer> entry : enchants.entrySet()) {
				itemMeta.addEnchant(entry.getKey(), entry.getValue(), true);
			}
		}

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	public ItemStack potionItem(String name, PotionEffectType potionEffectType, int duriation, int level, int amount) {
		ItemStack itemStack = new ItemStack(Material.POTION, amount);
		PotionMeta itemMeta = (PotionMeta) itemStack.getItemMeta();

		itemMeta.setDisplayName(name);

		itemMeta.setBasePotionData(new PotionData(PotionType.AWKWARD));
		itemMeta.addCustomEffect(new PotionEffect(potionEffectType, duriation * 20, level),true);

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}
}
