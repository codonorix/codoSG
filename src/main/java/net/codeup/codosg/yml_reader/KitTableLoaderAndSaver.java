package net.codeup.codosg.yml_reader;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.object_instances.AllJoinSigns;
import net.codeup.codosg.object_instances.AllKitTables;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KitTableLoaderAndSaver {
	File kitTables = new File(CodoSG.getInstance().getDataFolder(), "kitTable.yml");

	public void loadTables() throws IOException {
		YamlConfiguration loadFile = YamlConfiguration.loadConfiguration(this.kitTables);

		if (loadFile.get("tables") == null) return;
		ArrayList<Location> locations = (ArrayList<Location>) loadFile.get("tables");

		for (Location location : locations) {
			AllKitTables.getInstance().add(location);
		}
	}

	public void saveTables() throws IOException {
		YamlConfiguration modifyFile = YamlConfiguration.loadConfiguration(this.kitTables);
		modifyFile.set("tables", AllKitTables.getInstance());

//		for (Location location : AllKitTables.getInstance()) {
//		}
		modifyFile.save(kitTables);
	}
}
