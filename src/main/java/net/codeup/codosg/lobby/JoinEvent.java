package net.codeup.codosg.lobby;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.lobby.LobbyJoinEvent;
import net.codeup.codosg.object_instances.AllArenas;
import net.codeup.codosg.object_instances.AllPlayers;
import net.codeup.codosg.objects.KitObject;
import net.codeup.codosg.objects.PlayerObject;
import net.codeup.codosg.objects.PowerUpObject;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
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

		if(loadFile.get(player.getUniqueId().toString()) == null) {
			PlayerObject playerData = createPlayerData(player);
			loadFile.set(player.getUniqueId().toString(), playerData);
			loadFile.save(users);
			addPlayerData(player, playerData);
			return;
		}

		PlayerObject playerObject = loadFile.getObject(player.getUniqueId().toString(), PlayerObject.class);
		AllPlayers.getInstance().put(player.getUniqueId(), playerObject);

		System.out.println(AllPlayers.getInstance().get(player.getUniqueId()));

		player.teleport(new Location(Bukkit.getWorld("world"), -41, -21, -80));
		player.getInventory().clear();
		new LobbyJoinEvent().lobbyJoinEvent(event.getPlayer());

	}

	private PlayerObject createPlayerData(Player player) {
		return new PlayerObject(player,0,0,0,0,0,0,0,null,null,new HashMap<>(),new ArrayList<>());
	}

	private void addPlayerData(Player player, PlayerObject playerObject) {
		AllPlayers.getInstance().put(player.getUniqueId(), playerObject);
	}
}
