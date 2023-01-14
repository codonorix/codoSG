package net.codeup.codosg.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class WeaponItems {
	private ArrayList<ItemStack> instance = null;

	public ArrayList<ItemStack> getInstance() {
		if (instance == null) {
			instance = items();
		}
		return instance;
	}

	private ArrayList<ItemStack> items(){
		ArrayList<ItemStack> itemStacks = new ArrayList<>();
		itemStacks.add(new ItemCreator("Mold covered sword", new ArrayList<>(Arrays.asList("Smells... funny...")), null, Material.WOODEN_SWORD, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Chipped Stone Sword", new ArrayList<>(Arrays.asList("Sharp as a rock.")), null, Material.STONE_SWORD, 1, 2).generateItem());
		itemStacks.add(new ItemCreator("Polished Iron Sword", new ArrayList<>(Arrays.asList("Blind the enemies with its shine.")), null, Material.IRON_SWORD, 1, 5).generateItem());

		return itemStacks;
	}
}
