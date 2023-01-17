package net.codeup.codosg.kits.common;

import net.codeup.codosg.kits.KitItemCreator;
import net.codeup.codosg.objects.KitObject;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class ArmorKit {
	KitItemCreator kitItemCreator = new KitItemCreator();
	public KitObject getKit() {
		return new KitObject(2, "Armor", Material.IRON_CHESTPLATE, 0, levelOne(),levelTwo(),levelThree(),levelFour(),levelFive(),levelSix(),levelSeven(),levelEight(),levelNine(),levelTen());
	}

	private ArrayList<ItemStack> levelOne() {
		ArrayList<ItemStack> items = new ArrayList<>();
		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Armor Chestplate", null, 1));
		items.add(kitItemCreator.kitItem(Material.COOKIE, ChatColor.WHITE + "Armor Cookie", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelTwo() {
		ArrayList<ItemStack> items = new ArrayList<>();
		items.add(kitItemCreator.kitItem(Material.LEATHER_HELMET, ChatColor.WHITE + "Armor Helmet", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Armor Chestplate", null, 1));
		items.add(kitItemCreator.kitItem(Material.COOKIE, ChatColor.WHITE + "Armor Cookie", null, 2));

		return items;
	}

	private ArrayList<ItemStack> levelThree() {
		ArrayList<ItemStack> items = new ArrayList<>();
		items.add(kitItemCreator.kitItem(Material.LEATHER_HELMET, ChatColor.WHITE + "Armor Helmet", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Armor Chestplate", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Armor Boots", null, 1));
		items.add(kitItemCreator.kitItem(Material.COOKIE, ChatColor.WHITE + "Armor Cookie", null, 3));

		return items;
	}

	private ArrayList<ItemStack> levelFour() {
		ArrayList<ItemStack> items = new ArrayList<>();
		items.add(kitItemCreator.kitItem(Material.LEATHER_HELMET, ChatColor.WHITE + "Armor Helmet", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Armor Chestplate", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Armor Leggings", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Armor Boots", null, 1));
		items.add(kitItemCreator.kitItem(Material.COOKIE, ChatColor.WHITE + "Armor Cookie", null, 4));

		return items;
	}

	private ArrayList<ItemStack> levelFive() {
		ArrayList<ItemStack> items = new ArrayList<>();

		HashMap<Enchantment, Integer> chestPlateEnchant = new HashMap<>();
		chestPlateEnchant.put(Enchantment.PROTECTION_EXPLOSIONS, 1);
		chestPlateEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

		HashMap<Enchantment, Integer> leggingEnchant = new HashMap<>();
		leggingEnchant.put(Enchantment.PROTECTION_EXPLOSIONS, 1);
		leggingEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

		items.add(kitItemCreator.kitItem(Material.LEATHER_HELMET, ChatColor.WHITE + "Armor Helmet", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Armor Chestplate", chestPlateEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Armor Leggings", leggingEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Armor Boots", null, 1));
		items.add(kitItemCreator.kitItem(Material.COOKIE, ChatColor.WHITE + "Armor Cookie", null, 5));

		return items;
	}

	private ArrayList<ItemStack> levelSix() {
		ArrayList<ItemStack> items = new ArrayList<>();


		HashMap<Enchantment, Integer> helmetEnchant = new HashMap<>();
		helmetEnchant.put(Enchantment.PROTECTION_PROJECTILE, 1);
		helmetEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

		HashMap<Enchantment, Integer> chestPlateEnchant = new HashMap<>();
		chestPlateEnchant.put(Enchantment.PROTECTION_EXPLOSIONS, 1);
		chestPlateEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		HashMap<Enchantment, Integer> leggingEnchant = new HashMap<>();
		leggingEnchant.put(Enchantment.PROTECTION_FIRE, 3);
		leggingEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		HashMap<Enchantment, Integer> bootEnchant = new HashMap<>();
		bootEnchant.put(Enchantment.PROTECTION_FALL, 1);
		bootEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

		items.add(kitItemCreator.kitItem(Material.LEATHER_HELMET, ChatColor.WHITE + "Armor Helmet", helmetEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Armor Chestplate", chestPlateEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Armor Leggings", leggingEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Armor Boots", bootEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.COOKIE, ChatColor.WHITE + "Armor Cookie", null, 6));

		return items;
	}

	private ArrayList<ItemStack> levelSeven() {
		ArrayList<ItemStack> items = new ArrayList<>();


		HashMap<Enchantment, Integer> helmetEnchant = new HashMap<>();
		helmetEnchant.put(Enchantment.PROTECTION_PROJECTILE, 2);
		helmetEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		HashMap<Enchantment, Integer> chestPlateEnchant = new HashMap<>();
		chestPlateEnchant.put(Enchantment.PROTECTION_EXPLOSIONS, 3);
		chestPlateEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);

		HashMap<Enchantment, Integer> leggingEnchant = new HashMap<>();
		leggingEnchant.put(Enchantment.PROTECTION_FIRE, 3);
		leggingEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		HashMap<Enchantment, Integer> bootEnchant = new HashMap<>();
		bootEnchant.put(Enchantment.PROTECTION_FALL, 2);
		bootEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

		items.add(kitItemCreator.kitItem(Material.LEATHER_HELMET, ChatColor.WHITE + "Armor Helmet", helmetEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Armor Chestplate", chestPlateEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Armor Leggings", leggingEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Armor Boots", bootEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.COOKIE, ChatColor.WHITE + "Armor Cookie", null, 7));

		return items;
	}

	private ArrayList<ItemStack> levelEight() {
		ArrayList<ItemStack> items = new ArrayList<>();


		HashMap<Enchantment, Integer> helmetEnchant = new HashMap<>();
		helmetEnchant.put(Enchantment.PROTECTION_PROJECTILE, 3);
		helmetEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		HashMap<Enchantment, Integer> chestPlateEnchant = new HashMap<>();
		chestPlateEnchant.put(Enchantment.PROTECTION_EXPLOSIONS, 4);
		chestPlateEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);

		HashMap<Enchantment, Integer> leggingEnchant = new HashMap<>();
		leggingEnchant.put(Enchantment.PROTECTION_FIRE, 4);
		leggingEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);

		HashMap<Enchantment, Integer> bootEnchant = new HashMap<>();
		bootEnchant.put(Enchantment.PROTECTION_FALL, 3);
		bootEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		items.add(kitItemCreator.kitItem(Material.LEATHER_HELMET, ChatColor.WHITE + "Armor Helmet", helmetEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Armor Chestplate", chestPlateEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Armor Leggings", leggingEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Armor Boots", bootEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.COOKIE, ChatColor.WHITE + "Armor Cookie", null, 8));

		return items;
	}

	private ArrayList<ItemStack> levelNine() {
		ArrayList<ItemStack> items = new ArrayList<>();


		HashMap<Enchantment, Integer> helmetEnchant = new HashMap<>();
		helmetEnchant.put(Enchantment.PROTECTION_PROJECTILE, 4);
		helmetEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		HashMap<Enchantment, Integer> chestPlateEnchant = new HashMap<>();
		chestPlateEnchant.put(Enchantment.PROTECTION_EXPLOSIONS, 5);
		chestPlateEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 4);

		HashMap<Enchantment, Integer> leggingEnchant = new HashMap<>();
		leggingEnchant.put(Enchantment.PROTECTION_FIRE, 5);
		leggingEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);

		HashMap<Enchantment, Integer> bootEnchant = new HashMap<>();
		bootEnchant.put(Enchantment.PROTECTION_FALL, 5);
		bootEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		items.add(kitItemCreator.kitItem(Material.LEATHER_HELMET, ChatColor.WHITE + "Armor Helmet", helmetEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Armor Chestplate", chestPlateEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Armor Leggings", leggingEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Armor Boots", bootEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.COOKIE, ChatColor.WHITE + "Armor Cookie", null, 9));

		return items;
	}

	private ArrayList<ItemStack> levelTen() {
		ArrayList<ItemStack> items = new ArrayList<>();


		HashMap<Enchantment, Integer> helmetEnchant = new HashMap<>();
		helmetEnchant.put(Enchantment.PROTECTION_PROJECTILE, 5);
		helmetEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);

		HashMap<Enchantment, Integer> chestPlateEnchant = new HashMap<>();
		chestPlateEnchant.put(Enchantment.PROTECTION_EXPLOSIONS, 10);
		chestPlateEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 4);

		HashMap<Enchantment, Integer> leggingEnchant = new HashMap<>();
		leggingEnchant.put(Enchantment.PROTECTION_FIRE, 10);
		leggingEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 4);

		HashMap<Enchantment, Integer> bootEnchant = new HashMap<>();
		bootEnchant.put(Enchantment.PROTECTION_FALL, 6);
		bootEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		items.add(kitItemCreator.kitItem(Material.LEATHER_HELMET, ChatColor.WHITE + "Armor Helmet", helmetEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Armor Chestplate", chestPlateEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Armor Leggings", leggingEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Armor Boots", bootEnchant, 1));
		items.add(kitItemCreator.kitItem(Material.COOKIE, ChatColor.WHITE + "Armor Cookie", null, 10));

		return items;
	}
}
