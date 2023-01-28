package net.codeup.codosg.object_instances;

import net.codeup.codosg.objects.PlayerObject;
import net.codeup.codosg.objects.PowerUpObject;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class AllPowerups {
	private static HashMap<Integer, PowerUpObject> instance = null;

	public static HashMap<Integer, PowerUpObject> getInstance() {
		if(instance == null) {
			instance = new HashMap<>();

			instance.put(0, new PowerUpObject(0, "Assassin", null, Material.IRON_SWORD, 0));
			instance.put(1, new PowerUpObject(1, "Jedi Knight", null,Material.END_ROD,0));
			instance.put(2, new PowerUpObject(2, "Statis", null,Material.BLUE_ICE,0));
			instance.put(3, new PowerUpObject(3, "Vault Hunter", null,Material.IRON_BLOCK,0));
			instance.put(4, new PowerUpObject(4, "Gremlin", null,Material.ZOMBIE_HEAD,0));
			instance.put(5, new PowerUpObject(5, "Roulette", null,Material.POTATO,0));
			instance.put(6, new PowerUpObject(6, "Ninja", null,Material.BLACK_DYE,0));
			instance.put(7, new PowerUpObject(7, "Robin Hood", null,Material.BOW,0));
			instance.put(8, new PowerUpObject(8, "Nocturne", null,Material.ENDER_EYE,0));
			instance.put(9, new PowerUpObject(9, "Sweg Move", null,Material.GOAT_HORN,0));
		}

		return instance;
	}
}
