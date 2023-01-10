package net.codeup.codosg.arena_creator.events;

import net.codeup.codosg.object_instances.AllArenas;
import net.codeup.codosg.objects.ArenaObject;
import net.codeup.codosg.yml_reader.ArenaLoaderAndSaver;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChestPlaceEvent implements Listener {
	@EventHandler
	public void blockPlaceEvent(BlockPlaceEvent event) throws IOException {
		/*
		Create a custom chest with name spaced key using the arena name
		if the block contains a namespaced key that is int he arena list, add it to that arena
		 */

		ItemStack itemStack = event.getItemInHand();

		PersistentDataContainer dataContainer = itemStack.getItemMeta().getPersistentDataContainer();
		if (dataContainer.isEmpty()) return;

		ArenaObject arenaObject = null;
		for (NamespacedKey key : dataContainer.getKeys()) {

			if (AllArenas.getInstance().containsKey(key.getKey())) {
				System.out.println("HERE!!!!!!!");
				arenaObject = AllArenas.getInstance().get(key.getKey());
				break;
			}
		}

		if(arenaObject == null) return;

		List<Location> locations = new ArrayList<>();

		System.out.println(arenaObject);
		if(arenaObject.getChestLocations() != null) {
			locations = arenaObject.getSpawnPoints();
		}


		locations.add(event.getBlockPlaced().getLocation());
		arenaObject.setChestLocations(locations);
		event.getPlayer().sendMessage(ChatColor.GREEN + "[!] Chest added!");

		new ArenaLoaderAndSaver().saveMaps();
	}
}
