package net.codeup.codosg.items;

import net.codeup.codosg.CodoSG;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.data.type.Switch;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collections;

public class ItemCreator {
	private String name;
	private ArrayList<String> lore;
	private ArrayList<Enchantment> enchantments;
	private Material material;
	private int amount;
	private int rarity;

	public ItemCreator(String name, ArrayList<String> lore, ArrayList<Enchantment> enchantments, Material material, int amount, int rarity) {
		this.name = name;
		this.lore = lore;
		this.enchantments = enchantments;
		this.material = material;
		this.amount = amount;
		this.rarity = rarity;
	}

	ItemStack generateItem() {
		ItemStack itemStack = new ItemStack(this.getMaterial(), this.getAmount());
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(this.getName());
		ArrayList<String> itemDescription = new ArrayList<>();

		if(this.getLore() != null) {
			for(String lore : this.getLore()) {
				itemDescription.add(ChatColor.WHITE + lore);
			}
		}


		itemDescription.add(addRarity(this.getRarity()));
		itemMeta.setLore(itemDescription);

//		if(enchantments != null) itemMeta.addEnchant() TODO - Add enchantment

		NamespacedKey rarityKey = new NamespacedKey(CodoSG.getInstance(), "RARITY_KEY");
		itemMeta.getPersistentDataContainer().set(rarityKey, PersistentDataType.INTEGER, this.getRarity());

		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}

	private String addRarity(int rarity) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getLore() {
		return lore;
	}

	public void setLore(ArrayList<String> lore) {
		this.lore = lore;
	}

	public ArrayList<Enchantment> getEnchantments() {
		return enchantments;
	}

	public void setEnchantments(ArrayList<Enchantment> enchantments) {
		this.enchantments = enchantments;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
}
