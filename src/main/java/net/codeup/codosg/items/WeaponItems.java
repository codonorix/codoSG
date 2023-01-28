package net.codeup.codosg.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class WeaponItems {

	protected ArrayList<ItemStack> commonItems() {
		ArrayList<ItemStack> itemStacks = new ArrayList<>();
		itemStacks.add(new ItemCreator("Mold covered sword", new ArrayList<>(Arrays.asList("Smells... funny...")), null, Material.WOODEN_SWORD, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Oakheart Sword", new ArrayList<>(Arrays.asList("Made from the cheapest oak trees!")), null, Material.WOODEN_SWORD, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Birch Strike", new ArrayList<>(Arrays.asList("Strike them with a birch blade! May or may not break in one go.")), null, Material.WOODEN_SWORD, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Ash Bringer!", new ArrayList<>(Arrays.asList("Got it's name because it's only good for turning to ash.")), null, Material.WOODEN_SWORD, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Maplefury", new ArrayList<>(Arrays.asList("Don't let the name confuse you, this is not made out of maple juice")), null, Material.WOODEN_SWORD, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Hickorystorm", new ArrayList<>(Arrays.asList("This would make a good book title.")), null, Material.WOODEN_SWORD, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Redwoodreaper", new ArrayList<>(Arrays.asList("It only reaps red wood, that's it. It's an axe that's actually a sword.")), null, Material.WOODEN_SWORD, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Maplefury", new ArrayList<>(Arrays.asList("Don't let the name confuse you, this is not made out of maple juice")), null, Material.WOODEN_SWORD, 1, 0).generateItem());


		return itemStacks;
	}

	protected ArrayList<ItemStack> rareItems() {
		ArrayList<ItemStack> itemStacks = new ArrayList<>();

		itemStacks.add(new ItemCreator("Chipped Stone Sword", new ArrayList<>(Arrays.asList("Sharp as a rock.")), null, Material.STONE_SWORD, 1, 2).generateItem());
		itemStacks.add(new ItemCreator("Granite prime", new ArrayList<>(Arrays.asList("Kitchen counters are usually made with this stuff.")), null, Material.STONE_SWORD, 1, 2).generateItem());
		itemStacks.add(new ItemCreator("Obsidian edge", new ArrayList<>(Arrays.asList("It's having an identity crisis.")), null, Material.STONE_SWORD, 1, 2).generateItem());
		itemStacks.add(new ItemCreator("Basalt blade", new ArrayList<>(Arrays.asList("It can salt your pasta!.")), null, Material.STONE_SWORD, 1, 2).generateItem());
		itemStacks.add(new ItemCreator("Flint Strike", new ArrayList<>(Arrays.asList("It could have made fire, but it's not an iron sword so tough luck.")), null, Material.STONE_SWORD, 1, 2).generateItem());
		itemStacks.add(new ItemCreator("Sandstone Cutter", new ArrayList<>(Arrays.asList("Devs really wanted this weapon to only work on players", "with the name 'sandstone'.")), null, Material.STONE_SWORD, 1, 2).generateItem());
		itemStacks.add(new ItemCreator("Quartz Blade", new ArrayList<>(Arrays.asList("It's as bright as the devs future (it's black quartz).")), null, Material.STONE_SWORD, 1, 2).generateItem());
		itemStacks.add(new ItemCreator("Limestone Legion", new ArrayList<>(Arrays.asList("It just reminds me of limes.")), null, Material.STONE_SWORD, 1, 2).generateItem());

		return itemStacks;

	}

	protected ArrayList<ItemStack> epicItems() {
		ArrayList<ItemStack> itemStacks = new ArrayList<>();

		itemStacks.add(new ItemCreator("Polished Iron Sword", new ArrayList<>(Arrays.asList("Blind the enemies with its shine.")), null, Material.IRON_SWORD, 1, 5).generateItem());
		itemStacks.add(new ItemCreator("Iron Fang", new ArrayList<>(Arrays.asList("Wait... isn't this supposed to be in another game?.")), null, Material.IRON_SWORD, 1, 5).generateItem());
		itemStacks.add(new ItemCreator("Steel Storm", new ArrayList<>(Arrays.asList("Trust me, you don't wanna be in a steel storm... not fun.")), null, Material.IRON_SWORD, 1, 5).generateItem());
		itemStacks.add(new ItemCreator("Eternal Sword", new ArrayList<>(Arrays.asList("This sword is eternal, till like the game ends.")), null, Material.IRON_SWORD, 1, 5).generateItem());
		itemStacks.add(new ItemCreator("Shadow Strike", new ArrayList<>(Arrays.asList("It's the opposite of the polished iron sword, I'm too lazy to write the rest.")), null, Material.IRON_SWORD, 1, 5).generateItem());
		itemStacks.add(new ItemCreator("Titanium Blade", new ArrayList<>(Arrays.asList("It's from the moon! or uh, Mars...", "maybe pluto? I dunno.")), null, Material.IRON_SWORD, 1, 5).generateItem());

		return itemStacks;
	}
}
