package net.codeup.codosg.lobby;

import net.codeup.codosg.lobby.lobby_items.LobbyItems;
import org.bukkit.entity.Player;

public class LobbyJoinEvent {
	public void lobbyJoinEvent(Player player) {
		new LobbyItems().giveItems(player);
	}
}
