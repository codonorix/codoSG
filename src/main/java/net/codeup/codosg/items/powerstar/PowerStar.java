package net.codeup.codosg.items.powerstar;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.object_instances.AllPowerups;
import net.codeup.codosg.objects.PowerUpObject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class PowerStar implements Listener {
	@EventHandler
	private void onItemClickEvent(PlayerInteractEvent event) {
		if(event.getItem() == null || event.getItem().getItemMeta().getPersistentDataContainer().isEmpty()) return;
		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "POWER_STAR");
		if(!(event.getItem().getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING))) return;

		Player player = event.getPlayer();
		player.openInventory(powerStarInv());
	}

	@EventHandler
	private void onInvClick(InventoryClickEvent event) {
		if(event.getClickedInventory() == null) return;
		if(!(event.getClickedInventory().getHolder() instanceof PowerStarHolder)) return;

		Player player = (Player) event.getWhoClicked();
		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "POWER_UP");

		player.sendMessage(event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER).toString());
		event.setCancelled(true);
	}

	@EventHandler
	private void itemDragEvent(InventoryDragEvent event) {
		if(event.getInventory() == null) return;
		if(!(event.getInventory().getHolder() instanceof PowerStarHolder)) return;


		event.setCancelled(true);
	}

	public ItemStack powerStar() {
		ItemStack itemStack = new ItemStack(Material.NETHER_STAR);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "⚝ POWER STAR ⚝");

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "POWER_STAR");
		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "POWER_STAR");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}



	private Inventory powerStarInv() {
		Inventory inventory = Bukkit.createInventory(new PowerStarHolder(),9*2,"Power ups");

		for(PowerUpObject powerUpObject : AllPowerups.getInstance().values()) {
			inventory.addItem(powerUpObject.powerStarItemBuilder());
		}

		return inventory;
	}

	private boolean doAction(Player player, int action) {
		switch (action) {
			case 0:
				break;
			default:
				return false;
		}
		return false;
	}

	private void assassinPowerUp(Player player) {

	}
}
