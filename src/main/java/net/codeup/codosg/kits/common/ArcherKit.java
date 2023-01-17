package net.codeup.codosg.kits.common;

import net.codeup.codosg.kits.KitItemCreator;
import net.codeup.codosg.objects.KitObject;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class ArcherKit {
	KitItemCreator kitItemCreator = new KitItemCreator();
	public KitObject getKit() {
		return new KitObject(1, "Archer", Material.BOW, 0, levelOne(),levelTwo(),levelThree(),levelFour(),levelFive(),levelSix(),levelSeven(),levelEight(),levelNine(),levelTen());
	}

	private ArrayList<ItemStack> levelOne() {
		ArrayList<ItemStack> items = new ArrayList<>();
		HashMap<Enchantment, Integer> bowEnchant = new HashMap<>();
		bowEnchant.put(Enchantment.DURABILITY, 1);

		items.add(kitItemCreator.kitItem(Material.BOW, ChatColor.WHITE + "Archer Bow", bowEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.ARROW, ChatColor.WHITE + "Archer Arrows", null, 6));

		return items;
	}

	private ArrayList<ItemStack> levelTwo() {
		ArrayList<ItemStack> items = new ArrayList<>();
		HashMap<Enchantment, Integer> bowEnchant = new HashMap<>();
		bowEnchant.put(Enchantment.DURABILITY, 1);

		items.add(kitItemCreator.kitItem(Material.BOW, ChatColor.WHITE + "Archer Bow", bowEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.ARROW, ChatColor.WHITE + "Archer Arrows", null, 9));

		return items;
	}

	private ArrayList<ItemStack> levelThree() {
		ArrayList<ItemStack> items = new ArrayList<>();
		HashMap<Enchantment, Integer> bowEnchant = new HashMap<>();
		bowEnchant.put(Enchantment.DURABILITY, 1);

		items.add(kitItemCreator.kitItem(Material.BOW, ChatColor.WHITE + "Archer Bow", bowEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.ARROW, ChatColor.WHITE + "Archer Arrows", null, 16));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Archer Boots", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelFour() {
		ArrayList<ItemStack> items = new ArrayList<>();

		items.add(kitItemCreator.kitItem(Material.BOW, ChatColor.WHITE + "Archer Bow", null, 1));
		items.add(kitItemCreator.kitItem(Material.ARROW, ChatColor.WHITE + "Archer Arrows", null, 16));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Archer Boots", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelFive() {
		ArrayList<ItemStack> items = new ArrayList<>();

		items.add(kitItemCreator.kitItem(Material.BOW, ChatColor.WHITE + "Archer Bow", null, 1));
		items.add(kitItemCreator.kitItem(Material.ARROW, ChatColor.WHITE + "Archer Arrows", null, 16));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Archer Boots", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_HELMET, ChatColor.WHITE + "Archer Helmet", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelSix() {
		ArrayList<ItemStack> items = new ArrayList<>();

		items.add(kitItemCreator.kitItem(Material.BOW, ChatColor.WHITE + "Archer Bow", null, 1));
		items.add(kitItemCreator.kitItem(Material.ARROW, ChatColor.WHITE + "Archer Arrows", null, 16));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Archer Boots", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_HELMET, ChatColor.WHITE + "Archer Helmet", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Archer Leggings", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelSeven() {
		ArrayList<ItemStack> items = new ArrayList<>();
		HashMap<Enchantment, Integer> helmetEnchants = new HashMap<>();
		helmetEnchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		items.add(kitItemCreator.kitItem(Material.BOW, ChatColor.WHITE + "Archer Bow", null, 1));
		items.add(kitItemCreator.kitItem(Material.ARROW, ChatColor.WHITE + "Archer Arrows", null, 18));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Archer Boots", null, 1));
		items.add(kitItemCreator.kitItem(Material.DIAMOND_HELMET, ChatColor.WHITE + "Archer Helmet", helmetEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Archer Leggings", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelEight() {
		ArrayList<ItemStack> items = new ArrayList<>();

		HashMap<Enchantment, Integer> helmetEnchants = new HashMap<>();
		helmetEnchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

		HashMap<Enchantment, Integer> bowEnchants = new HashMap<>();
		bowEnchants.put(Enchantment.ARROW_DAMAGE, 1);

		items.add(kitItemCreator.kitItem(Material.BOW, ChatColor.WHITE + "Archer Bow", bowEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.ARROW, ChatColor.WHITE + "Archer Arrows", null, 22));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Archer Boots", null, 1));
		items.add(kitItemCreator.kitItem(Material.DIAMOND_HELMET, ChatColor.WHITE + "Archer Helmet", helmetEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Archer Leggings", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelNine() {
		ArrayList<ItemStack> items = new ArrayList<>();

		HashMap<Enchantment, Integer> helmetEnchants = new HashMap<>();
		helmetEnchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		HashMap<Enchantment, Integer> bowEnchants = new HashMap<>();
		bowEnchants.put(Enchantment.ARROW_DAMAGE, 1);

		items.add(kitItemCreator.kitItem(Material.BOW, ChatColor.WHITE + "Archer Bow", bowEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.ARROW, ChatColor.WHITE + "Archer Arrows", null, 30));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Archer Boots", null, 1));
		items.add(kitItemCreator.kitItem(Material.DIAMOND_HELMET, ChatColor.WHITE + "Archer Helmet", helmetEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Archer Leggings", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Archer Chestplate", null, 1));


		return items;
	}

	private ArrayList<ItemStack> levelTen() {
		ArrayList<ItemStack> items = new ArrayList<>();

		HashMap<Enchantment, Integer> helmetEnchants = new HashMap<>();
		helmetEnchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);

		HashMap<Enchantment, Integer> bowEnchants = new HashMap<>();
		bowEnchants.put(Enchantment.ARROW_DAMAGE, 2);

		items.add(kitItemCreator.kitItem(Material.BOW, ChatColor.WHITE + "Archer Bow", bowEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.ARROW, ChatColor.WHITE + "Archer Arrows", null, 36));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Archer Boots", null, 1));
		items.add(kitItemCreator.kitItem(Material.DIAMOND_HELMET, ChatColor.WHITE + "Archer Helmet", helmetEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Archer Leggings", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Archer Chestplate", null, 1));


		return items;
	}
}
