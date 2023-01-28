package net.codeup.codosg.object_instances;

import net.codeup.codosg.objects.ArenaObject;
import net.codeup.codosg.objects.GameObject;

import java.util.HashMap;

public class AllArenas {
	private static HashMap<String, GameObject> instance = null;

	public static HashMap<String, GameObject> getInstance() {
		if(instance == null) {
			instance = new HashMap<>();
		}

		return instance;
	}
}
