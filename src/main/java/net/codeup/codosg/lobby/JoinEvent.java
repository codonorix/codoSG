package net.codeup.codosg.lobby;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.lobby.LobbyJoinEvent;
import net.codeup.codosg.object_instances.AllArenas;
import net.codeup.codosg.object_instances.AllPlayers;
import net.codeup.codosg.objects.KitObject;
import net.codeup.codosg.objects.PlayerObject;
import net.codeup.codosg.objects.PowerUpObject;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class JoinEvent implements Listener {
	File users = new File(CodoSG.getInstance().getDataFolder(), "users.yml");
	YamlConfiguration loadFile = YamlConfiguration.loadConfiguration(this.users);
	@EventHandler
	public void onJoinEvent(PlayerJoinEvent event) throws IOException {
		Player player = event.getPlayer();

		if(!(loadFile.contains(String.valueOf(player.getUniqueId())))) {
			PlayerObject playerData = createPlayerData(player);
			loadFile.set(String.valueOf(player.getUniqueId()), playerData);
			loadFile.save(users);
			addPlayerData(player, playerData);
			return;
		}

		String uuidString = String.valueOf(player.getUniqueId());
		int wins = loadFile.getInt(uuidString + ".wins");
		int losses = loadFile.getInt(uuidString + ".losses");
		int kills = loadFile.getInt(uuidString + ".kills");
		int assists = loadFile.getInt(uuidString + ".assists");
		int crystals = loadFile.getInt(uuidString + ".crystals");
		int darkCrystals = loadFile.getInt(uuidString + ".darkCrystals");
		int keys = loadFile.getInt(uuidString + ".keys");
		String currentGame = null;
		KitObject kitObject = (KitObject) loadFile.get(uuidString + ".selectedKit");
		ArrayList<HashMap<KitObject, Integer>> unlockedKits = (ArrayList<HashMap<KitObject, Integer>>) loadFile.getList(uuidString + ".unlockedKits");
		ArrayList<PowerUpObject> unlockedPowerups = (ArrayList<PowerUpObject>) loadFile.getList(uuidString + ".unlockedKits");


		PlayerObject playerObject = new PlayerObject(player, wins,losses,kills,assists,crystals,darkCrystals,keys,currentGame,kitObject,unlockedKits,unlockedPowerups);
		addPlayerData(player, playerObject);
		new LobbyJoinEvent().lobbyJoinEvent(event.getPlayer());
	}

	private PlayerObject createPlayerData(Player player) {
		return new PlayerObject(player,0,0,0,0,0,0,0,null,null,null,null);
	}

	private void addPlayerData(Player player, PlayerObject playerObject) {
		AllPlayers.getInstance().put(player.getUniqueId(), playerObject);
	}
}
