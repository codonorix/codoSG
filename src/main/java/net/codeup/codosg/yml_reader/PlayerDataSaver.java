package net.codeup.codosg.yml_reader;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.object_instances.AllKitTables;
import net.codeup.codosg.object_instances.AllPlayers;
import net.codeup.codosg.objects.PlayerObject;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerDataSaver {
	File users = new File(CodoSG.getInstance().getDataFolder(), "users.yml");

	public void saveUsers() throws IOException {
		YamlConfiguration loadFile = YamlConfiguration.loadConfiguration(this.users);

		for (PlayerObject playerObject : AllPlayers.getInstance().values()) {
			loadFile.set(String.valueOf(playerObject.getPlayer().getUniqueId()), playerObject);
		}
		loadFile.save(users);
		System.out.println(AllPlayers.getInstance().keySet());
	}

	public void saveUsers(Player player) throws IOException {
		YamlConfiguration loadFile = YamlConfiguration.loadConfiguration(this.users);

		loadFile.set(String.valueOf(player.getPlayer().getUniqueId()), AllPlayers.getInstance().get(player.getUniqueId()));
		loadFile.save(users);
		System.out.println(AllPlayers.getInstance().keySet());
	}
}
