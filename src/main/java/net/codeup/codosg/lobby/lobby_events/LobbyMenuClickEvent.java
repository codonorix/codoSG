package net.codeup.codosg.lobby.lobby_events;

import net.codeup.codosg.lobby.invintories.LobbyItemInvHolder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class LobbyMenuClickEvent implements Listener {
	@EventHandler
	public void onLobbyMenuClick(InventoryClickEvent event) {
		if(event.getClickedInventory() == null) return;
		if(!(event.getClickedInventory().getHolder() instanceof LobbyItemInvHolder)) return;

		event.setCancelled(true);
	}
}
