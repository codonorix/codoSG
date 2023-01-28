package net.codeup.codosg.items;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class ItemInstances {
	private ArrayList<ItemStack> commonItemsinstance = null;

	public ArrayList<ItemStack> getCommonItemsinstance() {
		if (commonItemsinstance == null) {
			commonItemsinstance = generateCommonItems();
		}
		return commonItemsinstance;
	}

	private ArrayList<ItemStack> generateCommonItems() {
		ArrayList<ItemStack> itemStacks = new ArrayList<>();

		itemStacks.addAll(new WeaponItems().commonItems());
		itemStacks.addAll(new ArmorItems().commonItems());

		return itemStacks;
	}
}
