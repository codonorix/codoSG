package net.codeup.codosg.object_instances;

import net.codeup.codosg.objects.ArenaObject;

import java.util.HashMap;

public class AllArenas {
	private static HashMap<String, ArenaObject> instance = null;

	public static HashMap<String, ArenaObject> getInstance() {
		if(instance == null) {
			instance = new HashMap<>();
		}

		return instance;
	}
}
