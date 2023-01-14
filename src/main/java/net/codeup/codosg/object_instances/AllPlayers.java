package net.codeup.codosg.object_instances;

import net.codeup.codosg.objects.ArenaObject;
import net.codeup.codosg.objects.PlayerObject;

import java.util.HashMap;
import java.util.UUID;

public class AllPlayers {
	private static HashMap<UUID, PlayerObject> instance = null;

	public static HashMap<UUID, PlayerObject> getInstance() {
		if(instance == null) {
			instance = new HashMap<>();
		}

		return instance;
	}
}
