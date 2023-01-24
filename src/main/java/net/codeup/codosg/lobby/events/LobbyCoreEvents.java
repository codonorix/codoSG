package net.codeup.codosg.lobby.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class LobbyCoreEvents implements Listener {
	@EventHandler
	public void onHungerLoss(FoodLevelChangeEvent event) {
		if(event.getEntity().getWorld().getName().equals("world")) {
			event.getEntity().setFoodLevel(20);
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if(!(event.getEntity() instanceof Player)) return;


		Player player = (Player) event.getEntity();
		if(player.getWorld().getName().equals("world")) {
			player.setHealth(20);
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void inventoryInteract(InventoryClickEvent event) {
		if(!event.getWhoClicked().getWorld().getName().equals("world")) return;
		if(event.getWhoClicked().getGameMode() == GameMode.CREATIVE) return;
		if(event.getClickedInventory() == null) return;

		if(event.getClickedInventory() instanceof Inventory) {
			event.setCancelled(true);
		}
	}
}
