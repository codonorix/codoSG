package net.codeup.codosg.objects;

import org.bukkit.Material;

import java.util.ArrayList;

public class PowerUpObject {
	private int id;
	private String name;
	private Material icon;
	private ArrayList<String> description;
	private int price;

	public PowerUpObject(int id, String name, Material icon, ArrayList<String> description, int price) {
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.description = description;
		this.price = price;
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

	public Material getIcon() {
		return icon;
	}

	public void setIcon(Material icon) {
		this.icon = icon;
	}

	public ArrayList<String> getDescription() {
		return description;
	}

	public void setDescription(ArrayList<String> description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
