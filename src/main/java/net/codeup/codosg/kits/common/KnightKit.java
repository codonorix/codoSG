package net.codeup.codosg.kits.common;

import net.codeup.codosg.kits.KitItemCreator;
import net.codeup.codosg.objects.KitObject;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class KnightKit {
	KitItemCreator kitItemCreator = new KitItemCreator();
	public KitObject getKit() {
		return new KitObject(0, "Knight", Material.GOLDEN_SWORD, 0, levelOne(),levelTwo(),levelThree(),levelFour(),levelFive(),levelSix(),levelSeven(),levelEight(),levelNine(),levelTen());
	}

	private ArrayList<ItemStack> levelOne() {
		ArrayList<ItemStack> items = new ArrayList<>();
		items.add(kitItemCreator.kitItem(Material.WOODEN_SWORD, ChatColor.WHITE + "Knight Sword", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelTwo() {
		ArrayList<ItemStack> items = new ArrayList<>();
		items.add(kitItemCreator.kitItem(Material.WOODEN_SWORD, ChatColor.WHITE + "Knight Sword", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_HELMET, ChatColor.WHITE + "Knight Helmet", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelThree() {
		ArrayList<ItemStack> items = new ArrayList<>();
		items.add(kitItemCreator.kitItem(Material.WOODEN_SWORD, ChatColor.WHITE + "Knight Sword", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_HELMET, ChatColor.WHITE + "Knight Helmet", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelFour() {
		ArrayList<ItemStack> items = new ArrayList<>();
		items.add(kitItemCreator.kitItem(Material.GOLDEN_SWORD, ChatColor.WHITE + "Knight Sword", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_HELMET, ChatColor.WHITE + "Knight Helmet", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelFive() {
		ArrayList<ItemStack> items = new ArrayList<>();
		items.add(kitItemCreator.kitItem(Material.GOLDEN_SWORD, ChatColor.WHITE + "Knight Sword", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_HELMET, ChatColor.WHITE + "Knight Helmet", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_BOOTS, ChatColor.WHITE + "Knight Boots", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelSix() {
		ArrayList<ItemStack> items = new ArrayList<>();
		items.add(kitItemCreator.kitItem(Material.GOLDEN_SWORD, ChatColor.WHITE + "Knight Sword", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_HELMET, ChatColor.WHITE + "Knight Helmet", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_BOOTS, ChatColor.WHITE + "Knight Boots", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_LEGGINGS, ChatColor.WHITE + "Knight Leggings", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelSeven() {
		ArrayList<ItemStack> items = new ArrayList<>();
		HashMap<Enchantment, Integer> swordEnchants = new HashMap<>();
		swordEnchants.put(Enchantment.DURABILITY, 1);

		items.add(kitItemCreator.kitItem(Material.STONE_SWORD, ChatColor.WHITE + "Knight Sword", swordEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_HELMET, ChatColor.WHITE + "Knight Helmet", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_BOOTS, ChatColor.WHITE + "Knight Boots", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_LEGGINGS, ChatColor.WHITE + "Knight Leggings", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelEight() {
		ArrayList<ItemStack> items = new ArrayList<>();
		HashMap<Enchantment, Integer> swordEnchants = new HashMap<>();
		swordEnchants.put(Enchantment.DURABILITY, 1);

		items.add(kitItemCreator.kitItem(Material.STONE_SWORD, ChatColor.WHITE + "Knight Sword", swordEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_HELMET, ChatColor.WHITE + "Knight Helmet", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_BOOTS, ChatColor.WHITE + "Knight Boots", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Knight Leggings", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_CHESTPLATE, ChatColor.WHITE + "Knight Chestplate", null, 1));

		return items;
	}

	private ArrayList<ItemStack> levelNine() {
		ArrayList<ItemStack> items = new ArrayList<>();
		HashMap<Enchantment, Integer> helmetEnchants = new HashMap<>();
		helmetEnchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

		items.add(kitItemCreator.kitItem(Material.STONE_SWORD, ChatColor.WHITE + "Knight Sword", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_HELMET, ChatColor.WHITE + "Knight Helmet", helmetEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_BOOTS, ChatColor.WHITE + "Knight Boots", helmetEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Knight Leggings", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_CHESTPLATE, ChatColor.WHITE + "Knight Chestplate", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_CARROT, ChatColor.WHITE + "Knight Carrots", null, 1));


		return items;
	}

	private ArrayList<ItemStack> levelTen() {
		ArrayList<ItemStack> items = new ArrayList<>();

		HashMap<Enchantment, Integer> swordEnchants = new HashMap<>();
		swordEnchants.put(Enchantment.DURABILITY, 1);

		HashMap<Enchantment, Integer> helmetEnchants = new HashMap<>();
		helmetEnchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

		HashMap<Enchantment, Integer> chestplateEnchants = new HashMap<>();
		helmetEnchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

		HashMap<Enchantment, Integer> bootEnchants = new HashMap<>();
		bootEnchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		items.add(kitItemCreator.kitItem(Material.IRON_SWORD, ChatColor.WHITE + "Knight Sword", swordEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_HELMET, ChatColor.WHITE + "Knight Helmet", helmetEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_BOOTS, ChatColor.WHITE + "Knight Boots", bootEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Knight Leggings", null, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_CHESTPLATE, ChatColor.WHITE + "Knight Chestplate", chestplateEnchants, 1));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_CARROT, ChatColor.WHITE + "Knight Carrots", null, 2));

		return items;
	}
}


