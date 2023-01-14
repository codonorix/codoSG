package net.codeup.codosg.yml_reader;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.object_instances.AllArenas;
import net.codeup.codosg.objects.ArenaObject;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaLoaderAndSaver {
	File maps = new File(CodoSG.getInstance().getDataFolder(), "maps.yml");

	public void loadMaps() throws IOException {
		YamlConfiguration loadFile = YamlConfiguration.loadConfiguration(this.maps);

		if(loadFile.getConfigurationSection("maps") == null) return;
		for (String path : loadFile.getConfigurationSection("maps").getKeys(false)) {
			int id = loadFile.getInt("maps." + path + ".id");
			String arenaName = loadFile.getString("maps." + path + ".name").toLowerCase();
			Location waitingLobby = loadFile.getLocation("maps." + path + ".waitingLobby");
			List<Location> spawnPoints = (List<Location>) loadFile.getList("maps." + path + ".spawnPoints");
			List<Location> chestLocations = (List<Location>) loadFile.getList("maps." + path + ".chestLocaitons");

			ArenaObject arenaObject = new ArenaObject(id, arenaName, waitingLobby, spawnPoints, chestLocations, false, new ArrayList<>());
			AllArenas.getInstance().put(arenaName, arenaObject);
		}
	}

	public void saveMaps() throws IOException {
		YamlConfiguration modifyFile = YamlConfiguration.loadConfiguration(this.maps);
		for (ArenaObject arena : AllArenas.getInstance().values()) {
			modifyFile.set("maps." + arena.getName(), arena);
		}
		modifyFile.save(maps);
	}
}
