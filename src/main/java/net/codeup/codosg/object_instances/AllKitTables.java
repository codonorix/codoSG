package net.codeup.codosg.object_instances;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.HashMap;

public class AllKitTables {
	private static ArrayList<Location> instance = null;

	public static ArrayList<Location> getInstance() {
		if(instance == null) {
			instance = new ArrayList<>();
		}

		return instance;
	}
}
