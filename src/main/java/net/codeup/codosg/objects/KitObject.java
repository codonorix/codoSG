package net.codeup.codosg.objects;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class KitObject {
	private int id;
	private String name;
	private Material icon;
	private int rarity;
	private ArrayList<ItemStack> levelOne;
	private ArrayList<ItemStack> levelTwo;
	private ArrayList<ItemStack> levelThree;
	private ArrayList<ItemStack> levelFour;
	private ArrayList<ItemStack> levelFive;
	private ArrayList<ItemStack> levelSix;
	private ArrayList<ItemStack> levelSeven;
	private ArrayList<ItemStack> levelEight;
	private ArrayList<ItemStack> levelNine;
	private ArrayList<ItemStack> levelTen;

	public KitObject(int id, String name, Material icon, int rarity, ArrayList<ItemStack> levelOne, ArrayList<ItemStack> levelTwo, ArrayList<ItemStack> levelThree, ArrayList<ItemStack> levelFour, ArrayList<ItemStack> levelFive, ArrayList<ItemStack> levelSix, ArrayList<ItemStack> levelSeven, ArrayList<ItemStack> levelEight, ArrayList<ItemStack> levelNine, ArrayList<ItemStack> levelTen) {
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.rarity = rarity;
		this.levelOne = levelOne;
		this.levelTwo = levelTwo;
		this.levelThree = levelThree;
		this.levelFour = levelFour;
		this.levelFive = levelFive;
		this.levelSix = levelSix;
		this.levelSeven = levelSeven;
		this.levelEight = levelEight;
		this.levelNine = levelNine;
		this.levelTen = levelTen;
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

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	public ArrayList<ItemStack> getLevelOne() {
		return levelOne;
	}

	public void setLevelOne(ArrayList<ItemStack> levelOne) {
		this.levelOne = levelOne;
	}

	public ArrayList<ItemStack> getLevelTwo() {
		return levelTwo;
	}

	public void setLevelTwo(ArrayList<ItemStack> levelTwo) {
		this.levelTwo = levelTwo;
	}

	public ArrayList<ItemStack> getLevelThree() {
		return levelThree;
	}

	public void setLevelThree(ArrayList<ItemStack> levelThree) {
		this.levelThree = levelThree;
	}

	public ArrayList<ItemStack> getLevelFour() {
		return levelFour;
	}

	public void setLevelFour(ArrayList<ItemStack> levelFour) {
		this.levelFour = levelFour;
	}

	public ArrayList<ItemStack> getLevelFive() {
		return levelFive;
	}

	public void setLevelFive(ArrayList<ItemStack> levelFive) {
		this.levelFive = levelFive;
	}

	public ArrayList<ItemStack> getLevelSix() {
		return levelSix;
	}

	public void setLevelSix(ArrayList<ItemStack> levelSix) {
		this.levelSix = levelSix;
	}

	public ArrayList<ItemStack> getLevelSeven() {
		return levelSeven;
	}

	public void setLevelSeven(ArrayList<ItemStack> levelSeven) {
		this.levelSeven = levelSeven;
	}

	public ArrayList<ItemStack> getLevelEight() {
		return levelEight;
	}

	public void setLevelEight(ArrayList<ItemStack> levelEight) {
		this.levelEight = levelEight;
	}

	public ArrayList<ItemStack> getLevelNine() {
		return levelNine;
	}

	public void setLevelNine(ArrayList<ItemStack> levelNine) {
		this.levelNine = levelNine;
	}

	public ArrayList<ItemStack> getLevelTen() {
		return levelTen;
	}

	public void setLevelTen(ArrayList<ItemStack> levelTen) {
		this.levelTen = levelTen;
	}
}
