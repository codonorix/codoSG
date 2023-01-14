package net.codeup.codosg.lobby;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.object_instances.AllPlayers;
import net.codeup.codosg.objects.PlayerObject;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

public class LeaveEvent implements Listener {
	File users = new File(CodoSG.getInstance().getDataFolder(), "users.yml");
	YamlConfiguration loadFile = YamlConfiguration.loadConfiguration(this.users);
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) throws IOException {
		PlayerObject playerData = AllPlayers.getInstance().get(event.getPlayer().getUniqueId());
		loadFile.set(String.valueOf(event.getPlayer().getUniqueId()), playerData);
		loadFile.save(users);
		AllPlayers.getInstance().remove(event.getPlayer().getUniqueId());
		System.out.println(AllPlayers.getInstance().keySet());
	}
}
