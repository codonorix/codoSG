package net.codeup.codosg.objects;

import net.codeup.codosg.CodoSG;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class PowerUpObject {
	int id;
	String name;
	ArrayList<String> info;
	Material material;
	int price;

	public PowerUpObject(int id, String name, ArrayList<String> info, Material material, int price) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.material = material;
		this.price = price;
	}

	public ItemStack powerStarItemBuilder() {
		ItemStack itemStack = new ItemStack(this.material);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.GOLD + this.name);

		ArrayList<String> itemDescription = new ArrayList<>();

		if(!(this.info == null)) {
			for(String string : this.info) {
				itemDescription.add(ChatColor.WHITE + string);
			}
		}
		itemMeta.setLore(itemDescription);

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "POWER_UP");
		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, this.id);

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getInfo() {
		return info;
	}

	public void setInfo(ArrayList<String> info) {
		this.info = info;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
