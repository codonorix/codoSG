package net.codeup.codosg.object_instances;

import net.codeup.codosg.objects.ArenaObject;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.HashMap;

public class AllJoinSigns {
	private static HashMap<String, ArrayList<Location>> instance = null;

	public static HashMap<String, ArrayList<Location>> getInstance() {
		if(instance == null) {
			instance = new HashMap<>();
		}

		return instance;
	}
}
