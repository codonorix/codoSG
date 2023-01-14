package net.codeup.codosg.lobby.lobby_events;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.lobby.invintories.CosmeticShopInv;
import net.codeup.codosg.lobby.invintories.GameShopInv;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ItemClickEvent implements Listener {
	@EventHandler
	public void itemClickEvent(PlayerInteractEvent event) {
		if (event.getItem() == null) return;

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "LOBBY_ITEM");
		PersistentDataContainer container = event.getItem().getItemMeta().getPersistentDataContainer();

		if (!(container.has(key, PersistentDataType.STRING))) return;

		Player player = event.getPlayer();

		if (container.get(key, PersistentDataType.STRING).equals("GAME_SHOP_ITEM")) {
			player.openInventory(new GameShopInv().menu());
			return;
		} else if (container.get(key, PersistentDataType.STRING).equals("COSMETIC_SHOP_ITEM")) {
			player.openInventory(new CosmeticShopInv().menu());
			return;
		}
	}
}
