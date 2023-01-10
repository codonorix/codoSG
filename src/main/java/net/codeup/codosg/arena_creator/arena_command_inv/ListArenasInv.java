package net.codeup.codosg.arena_creator.arena_command_inv;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class ListArenasInv {
	public Inventory listArenaInv() {
		return Bukkit.createInventory(new ListArenasInvHolder(), 9, ChatColor.LIGHT_PURPLE + "All Arenas");
	}
}
