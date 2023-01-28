package net.codeup.codosg.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class ArmorItems {
	protected ArrayList<ItemStack> commonItems() {
		ArrayList<ItemStack> itemStacks = new ArrayList<>();
		itemStacks.add(new ItemCreator("Leather Hide", new ArrayList<>(Arrays.asList("It was made out of a cow that had a day job.")), null, Material.LEATHER_HELMET, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Fur Frenzy", new ArrayList<>(Arrays.asList("As much as it says fur, I can promise you it's not.")), null, Material.LEATHER_HELMET, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Skin Crafter", new ArrayList<>(Arrays.asList("It came from silent hill (homecoming was the best)")), null, Material.LEATHER_HELMET, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Hide Shield", new ArrayList<>(Arrays.asList("It's not actually hiding a shield you silly goose.")), null, Material.LEATHER_HELMET, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Tanned Terror", new ArrayList<>(Arrays.asList("*slaps tanning booth*", "This bad boy can hold so many terros in here.")), null, Material.LEATHER_HELMET, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Leather Lid", new ArrayList<>(Arrays.asList("It's on your head making it a lid.")), null, Material.LEATHER_HELMET, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Hide Shank", new ArrayList<>(Arrays.asList("This also, does not hide a shank.")), null, Material.LEATHER_HELMET, 1, 0).generateItem());

		itemStacks.add(new ItemCreator("Leather Vest", new ArrayList<>(Arrays.asList("It's a vest made of leather, classy.")), null, Material.LEATHER_CHESTPLATE, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Hide Defender", new ArrayList<>(Arrays.asList("Defend the hide Clarance!")), null, Material.LEATHER_CHESTPLATE, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Skin Cast", new ArrayList<>(Arrays.asList("It makes you feel the warmth of another human.")), null, Material.LEATHER_CHESTPLATE, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Tanned Torso", new ArrayList<>(Arrays.asList("Just say you got sun burnt.")), null, Material.LEATHER_CHESTPLATE, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Leather Legion", new ArrayList<>(Arrays.asList("This one had some serious ego problems.")), null, Material.LEATHER_CHESTPLATE, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Hide Tunic", new ArrayList<>(Arrays.asList("Again, please STOP TRYING TO HIDE THESE.")), null, Material.LEATHER_CHESTPLATE, 1, 0).generateItem());

		itemStacks.add(new ItemCreator("Leather Breeches", new ArrayList<>(Arrays.asList("Now you can pretend to be the prince.")), null, Material.LEATHER_LEGGINGS, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Hide Pants", new ArrayList<>(Arrays.asList("Okay, please don't hide these. Have some shame.")), null, Material.LEATHER_LEGGINGS, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Fur Fenders", new ArrayList<>(Arrays.asList("You can pet it like it's a bunny.")), null, Material.LEATHER_LEGGINGS, 1, 0).generateItem());
		itemStacks.add(new ItemCreator("Skin Legs", new ArrayList<>(Arrays.asList("Not to be confused for skinny jeans.")), null, Material.LEATHER_LEGGINGS, 1, 0).generateItem());

		return itemStacks;
	}

	protected ArrayList<ItemStack> rareItems() {
		ArrayList<ItemStack> itemStacks = new ArrayList<>();


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
