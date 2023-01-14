package net.codeup.codosg.yml_reader;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.object_instances.AllArenas;
import net.codeup.codosg.object_instances.AllJoinSigns;
import net.codeup.codosg.objects.ArenaObject;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JoinSignLoaderAndSaver {
	File signs = new File(CodoSG.getInstance().getDataFolder(), "signs.yml");

	public void loadSigns() throws IOException {
		YamlConfiguration loadFile = YamlConfiguration.loadConfiguration(this.signs);

		if(loadFile.getConfigurationSection("signs") == null) return;

		for (String path : loadFile.getConfigurationSection("signs").getKeys(false)) {
			List<Location> spawnPoints = (List<Location>) loadFile.getList("signs." + path);

			AllJoinSigns.getInstance().put(path, (ArrayList<Location>) spawnPoints);
		}
	}

	public void saveSigns() throws IOException {
		YamlConfiguration modifyFile = YamlConfiguration.loadConfiguration(this.signs);

		for (Map.Entry<String, ArrayList<Location>> entry : AllJoinSigns.getInstance().entrySet()) {
			modifyFile.set("signs." + entry.getKey(), entry.getValue());
		}
		modifyFile.save(signs);
	}
}
