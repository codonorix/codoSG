package net.codeup.codosg.kits.common;

import net.codeup.codosg.kits.KitItemCreator;
import net.codeup.codosg.objects.KitObject;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.HashMap;

public class BakerKit {
	KitItemCreator kitItemCreator = new KitItemCreator();
	public KitObject getKit() {
		return new KitObject(3, "Baker", Material.CAKE, 0, levelOne(),levelTwo(),levelThree(),levelFour(),levelFive(),levelSix(),levelSeven(),levelEight(),levelNine(),levelTen());
	}

	private ArrayList<ItemStack> levelOne() {
		ArrayList<ItemStack> items = new ArrayList<>();

		items.add(kitItemCreator.kitItem(Material.WOODEN_SWORD, ChatColor.WHITE + "Baker Knife", null, 1));

		items.add(kitItemCreator.kitItem(Material.BREAD, ChatColor.WHITE + "Bakers Loaf", null, 2));
		items.add(kitItemCreator.kitItem(Material.CAKE, ChatColor.WHITE + "Bakers Cake", null, 1));

		items.add(kitItemCreator.potionItem(ChatColor.WHITE + "Bakers Endurance", PotionEffectType.DAMAGE_RESISTANCE,10,1,1));

		return items;
	}

	private ArrayList<ItemStack> levelTwo() {
		ArrayList<ItemStack> items = new ArrayList<>();

		items.add(kitItemCreator.kitItem(Material.WOODEN_SWORD, ChatColor.WHITE + "Baker Knife", null, 1));

		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Bakers Apron", null, 1));

		items.add(kitItemCreator.kitItem(Material.BREAD, ChatColor.WHITE + "Bakers Loaf", null, 4));
		items.add(kitItemCreator.kitItem(Material.CAKE, ChatColor.WHITE + "Bakers Cake", null, 1));

		items.add(kitItemCreator.potionItem(ChatColor.WHITE + "Bakers Endurance", PotionEffectType.DAMAGE_RESISTANCE,10,1,1));

		return items;
	}

	private ArrayList<ItemStack> levelThree() {
		ArrayList<ItemStack> items = new ArrayList<>();

		items.add(kitItemCreator.kitItem(Material.WOODEN_SWORD, ChatColor.WHITE + "Baker Knife", null, 1));

		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Bakers Apron", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Bakers Pants", null, 1));

		items.add(kitItemCreator.kitItem(Material.BREAD, ChatColor.WHITE + "Bakers Loaf", null, 6));
		items.add(kitItemCreator.kitItem(Material.CAKE, ChatColor.WHITE + "Bakers Cake", null, 2));

		items.add(kitItemCreator.potionItem(ChatColor.WHITE + "Bakers Endurance", PotionEffectType.DAMAGE_RESISTANCE,10,1,1));

		return items;
	}

	private ArrayList<ItemStack> levelFour() {
		ArrayList<ItemStack> items = new ArrayList<>();

		items.add(kitItemCreator.kitItem(Material.WOODEN_SWORD, ChatColor.WHITE + "Baker Knife", null, 1));

		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Bakers Apron", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Bakers Pants", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Bakers Shoes", null, 1));

		items.add(kitItemCreator.kitItem(Material.BREAD, ChatColor.WHITE + "Bakers Loaf", null, 6));
		items.add(kitItemCreator.kitItem(Material.CAKE, ChatColor.WHITE + "Bakers Cake", null, 2));

		items.add(kitItemCreator.potionItem(ChatColor.WHITE + "Bakers Endurance", PotionEffectType.DAMAGE_RESISTANCE,10,1,1));

		return items;
	}

	private ArrayList<ItemStack> levelFive() {
		ArrayList<ItemStack> items = new ArrayList<>();

		items.add(kitItemCreator.kitItem(Material.WOODEN_SWORD, ChatColor.WHITE + "Baker Knife", null, 1));

		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Bakers Apron", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Bakers Pants", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Bakers Shoes", null, 1));

		items.add(kitItemCreator.kitItem(Material.BREAD, ChatColor.WHITE + "Bakers Loaf", null, 10));
		items.add(kitItemCreator.kitItem(Material.CAKE, ChatColor.WHITE + "Bakers Cake", null, 3));

		items.add(kitItemCreator.potionItem(ChatColor.WHITE + "Bakers Endurance", PotionEffectType.DAMAGE_RESISTANCE,10,1,2));

		return items;
	}

	private ArrayList<ItemStack> levelSix() {
		ArrayList<ItemStack> items = new ArrayList<>();

		items.add(kitItemCreator.kitItem(Material.WOODEN_SWORD, ChatColor.WHITE + "Baker Knife", null, 1));

		HashMap<Enchantment, Integer> bootEnchant = new HashMap<>();
		bootEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Bakers Apron", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Bakers Pants", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Bakers Shoes", bootEnchant, 1));

		items.add(kitItemCreator.kitItem(Material.BREAD, ChatColor.WHITE + "Bakers Loaf", null, 12));
		items.add(kitItemCreator.kitItem(Material.CAKE, ChatColor.WHITE + "Bakers Cake", null, 3));

		items.add(kitItemCreator.potionItem(ChatColor.WHITE + "Bakers Endurance", PotionEffectType.DAMAGE_RESISTANCE,10,1,2));

		return items;
	}

	private ArrayList<ItemStack> levelSeven() {
		ArrayList<ItemStack> items = new ArrayList<>();

		HashMap<Enchantment, Integer> swordEnchant = new HashMap<>();
		swordEnchant.put(Enchantment.DURABILITY, 1);

		items.add(kitItemCreator.kitItem(Material.STONE_SWORD, ChatColor.WHITE + "Baker Knife", swordEnchant, 1));

		HashMap<Enchantment, Integer> bootEnchant = new HashMap<>();
		bootEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Bakers Apron", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Bakers Pants", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Bakers Shoes", bootEnchant, 1));

		items.add(kitItemCreator.kitItem(Material.BREAD, ChatColor.WHITE + "Bakers Loaf", null, 16));
		items.add(kitItemCreator.kitItem(Material.CAKE, ChatColor.WHITE + "Bakers Cake", null, 3));

		items.add(kitItemCreator.potionItem(ChatColor.WHITE + "Bakers Endurance", PotionEffectType.DAMAGE_RESISTANCE,10,1,2));

		return items;
	}

	private ArrayList<ItemStack> levelEight() {
		ArrayList<ItemStack> items = new ArrayList<>();

		HashMap<Enchantment, Integer> swordEnchant = new HashMap<>();
		swordEnchant.put(Enchantment.DURABILITY, 1);

		items.add(kitItemCreator.kitItem(Material.STONE_SWORD, ChatColor.WHITE + "Baker Knife", swordEnchant, 1));

		HashMap<Enchantment, Integer> bootEnchant = new HashMap<>();
		bootEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Bakers Apron", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Bakers Pants", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_BOOTS, ChatColor.WHITE + "Bakers Shoes", bootEnchant, 1));

		items.add(kitItemCreator.kitItem(Material.BREAD, ChatColor.WHITE + "Bakers Loaf", null, 20));
		items.add(kitItemCreator.kitItem(Material.CAKE, ChatColor.WHITE + "Bakers Cake", null, 4));

		items.add(kitItemCreator.potionItem(ChatColor.WHITE + "Bakers Endurance", PotionEffectType.DAMAGE_RESISTANCE,10,1,3));

		return items;
	}

	private ArrayList<ItemStack> levelNine() {
		ArrayList<ItemStack> items = new ArrayList<>();

		items.add(kitItemCreator.kitItem(Material.STONE_SWORD, ChatColor.WHITE + "Baker Knife", null, 1));

		HashMap<Enchantment, Integer> bootEnchant = new HashMap<>();
		bootEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Bakers Apron", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Bakers Pants", null, 1));
		items.add(kitItemCreator.kitItem(Material.IRON_BOOTS, ChatColor.WHITE + "Bakers Shoes", bootEnchant, 1));

		items.add(kitItemCreator.kitItem(Material.BREAD, ChatColor.WHITE + "Bakers Loaf", null, 24));
		items.add(kitItemCreator.kitItem(Material.CAKE, ChatColor.WHITE + "Bakers Cake", null, 5));

		items.add(kitItemCreator.potionItem(ChatColor.WHITE + "Bakers Endurance", PotionEffectType.DAMAGE_RESISTANCE,10,1,3));

		return items;
	}

	private ArrayList<ItemStack> levelTen() {
		ArrayList<ItemStack> items = new ArrayList<>();

		HashMap<Enchantment, Integer> swordEnchant = new HashMap<>();
		swordEnchant.put(Enchantment.DURABILITY, 1);

		items.add(kitItemCreator.kitItem(Material.IRON_SWORD, ChatColor.WHITE + "Baker Knife", swordEnchant, 1));

		HashMap<Enchantment, Integer> bootEnchant = new HashMap<>();
		bootEnchant.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

		items.add(kitItemCreator.kitItem(Material.IRON_HELMET, ChatColor.WHITE + "Bakers Hat", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_CHESTPLATE, ChatColor.WHITE + "Bakers Apron", null, 1));
		items.add(kitItemCreator.kitItem(Material.LEATHER_LEGGINGS, ChatColor.WHITE + "Bakers Pants", null, 1));
		items.add(kitItemCreator.kitItem(Material.IRON_BOOTS, ChatColor.WHITE + "Bakers Shoes", bootEnchant, 1));

		items.add(kitItemCreator.kitItem(Material.BREAD, ChatColor.WHITE + "Bakers Loaf", null, 24));
		items.add(kitItemCreator.kitItem(Material.CAKE, ChatColor.WHITE + "Bakers Cake", null, 5));
		items.add(kitItemCreator.kitItem(Material.GOLDEN_APPLE, ChatColor.WHITE + "Bakers Treat Apple", null, 1));

		items.add(kitItemCreator.potionItem(ChatColor.WHITE + "Bakers Endurance", PotionEffectType.DAMAGE_RESISTANCE,10,1,3));

		return items;
	}
}
