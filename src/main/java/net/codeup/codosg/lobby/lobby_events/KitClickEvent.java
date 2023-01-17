package net.codeup.codosg.lobby.lobby_events;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.lobby.invintories.LobbyItemInvHolder;
import net.codeup.codosg.object_instances.AllKits;
import net.codeup.codosg.object_instances.AllPlayers;
import net.codeup.codosg.objects.KitObject;
import net.codeup.codosg.objects.PlayerObject;
import net.codeup.codosg.yml_reader.PlayerDataSaver;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;
import java.util.HashMap;

public class KitClickEvent implements Listener {
	int levelTwo = 80;
	int levelThree = 400;
	int levelFour = 1000;
	int levelFive = 3000;
	int levelSix = 12000;
	int levelSeven = 50000;
	int levelEight = 100000;
	int levelNine = 250000;
	int levelTen = 1000000;
	@EventHandler
	public void kitClickEvent(InventoryClickEvent event) throws IOException {
		if(event.getClickedInventory() == null) return;
		if(event.getCurrentItem() == null) return;
		if(!(event.getClickedInventory().getHolder() instanceof LobbyItemInvHolder)) return;

		Player player = (Player) event.getWhoClicked();
		PlayerObject playerObject = AllPlayers.getInstance().get(player.getUniqueId());

		if(event.getCurrentItem().getItemMeta().getPersistentDataContainer() == null) return;

		PersistentDataContainer persistentDataContainer = event.getCurrentItem().getItemMeta().getPersistentDataContainer();

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "KIT_ITEM");

		if(!(persistentDataContainer.has(key, PersistentDataType.INTEGER))) return;

		if(event.isLeftClick()) {
			for (KitObject kitObject : AllKits.getCommonKits()) {
				if (persistentDataContainer.get(key, PersistentDataType.INTEGER) == kitObject.getId()) {
					if (playerObject.getUnlockedKits().containsKey(kitObject)) {
						playerObject.setSelectedKit(kitObject);
						player.sendMessage(ChatColor.GREEN + "[!] Selected " + kitObject.getName() + ".");
						return;
					}

					player.sendMessage(ChatColor.RED + "[!] You haven't unlocked " + kitObject.getName() + ".");
					return;
				}
			}
		} else if (event.isRightClick()) {
			for (KitObject kitObject : AllKits.getCommonKits()) {
				if (persistentDataContainer.get(key, PersistentDataType.INTEGER) == kitObject.getId()) {
					if (playerObject.getUnlockedKits().containsKey(kitObject)) {
						int crystals = playerObject.getCrystals();
						int level = playerObject.getUnlockedKits().get(kitObject);
						HashMap<KitObject, Integer> playerKits = playerObject.getUnlockedKits();
						switch (level + 1) {
							case 2:
								if(!(crystals - levelTwo < 0)) {
									crystals = crystals-levelTwo;
									playerKits.put(kitObject, 2);
									playerObject.setCrystals(crystals);
									player.sendMessage(ChatColor.GREEN + "[!] Upgraded to level 2!");
								}else {
									player.sendMessage(ChatColor.RED + "[!] Not enough crystals!");
								}
								break;
							case 3:
								if(!(crystals - levelThree < 0)) {
									crystals = crystals-levelThree;
									playerKits.put(kitObject, 3);
									playerObject.setCrystals(crystals);
									player.sendMessage(ChatColor.GREEN + "[!] Upgraded to level 3!");
								}else {
									player.sendMessage(ChatColor.RED + "[!] Not enough crystals!");
								}
								break;
							case 4:
								if(!(crystals - levelFour < 0)) {
									crystals = crystals-levelFour;
									playerKits.put(kitObject, 4);
									playerObject.setCrystals(crystals);
									player.sendMessage(ChatColor.GREEN + "[!] Upgraded to level 4!");
								}else {
									player.sendMessage(ChatColor.RED + "[!] Not enough crystals!");
								}
								break;
							case 5:
								if(!(crystals - levelFive < 0)) {
									crystals = crystals-levelFive;
									playerKits.put(kitObject, 5);
									playerObject.setCrystals(crystals);
									player.sendMessage(ChatColor.GREEN + "[!] Upgraded to level 5!");
								}else {
									player.sendMessage(ChatColor.RED + "[!] Not enough crystals!");
								}
								break;
							case 6:
								if(!(crystals - levelSix < 0)) {
									crystals = crystals-levelSix;
									playerKits.put(kitObject, 6);
									playerObject.setCrystals(crystals);
									player.sendMessage(ChatColor.GREEN + "[!] Upgraded to level 6!");
								}else {
									player.sendMessage(ChatColor.RED + "[!] Not enough crystals!");
								}
								break;
							case 7:
								if(!(crystals - levelSeven < 0)) {
									crystals = crystals-levelSeven;
									playerKits.put(kitObject, 7);
									playerObject.setCrystals(crystals);
									player.sendMessage(ChatColor.GREEN + "[!] Upgraded to level 7!");
								}else {
									player.sendMessage(ChatColor.RED + "[!] Not enough crystals!");
								}
								break;
							case 8:
								if(!(crystals - levelEight < 0)) {
									crystals = crystals-levelEight;
									playerKits.put(kitObject, 8);
									playerObject.setCrystals(crystals);
									player.sendMessage(ChatColor.GREEN + "[!] Upgraded to level 8!");
								}else {
									player.sendMessage(ChatColor.RED + "[!] Not enough crystals!");
								}
								break;
							case 9:
								if(!(crystals - levelNine < 0)) {
									crystals = crystals-levelNine;
									playerKits.put(kitObject, 9);
									playerObject.setCrystals(crystals);
									player.sendMessage(ChatColor.GREEN + "[!] Upgraded to level 9!");
								}else {
									player.sendMessage(ChatColor.RED + "[!] Not enough crystals!");
								}
								break;
							case 10:
								if(!(crystals - levelTen < 0)) {
									crystals = crystals-levelTen;
									playerKits.put(kitObject, 10);
									playerObject.setCrystals(crystals);
									player.sendMessage(ChatColor.GREEN + "[!] Upgraded to level 10!");

									for(Player player1 : Bukkit.getServer().getOnlinePlayers()) {
										player1.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "Q " + ChatColor.LIGHT_PURPLE + player.getDisplayName() + " just unlocked " + kitObject.getName() + " level 10!" + ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + " Q");
									}
								}else {
									player.sendMessage(ChatColor.RED + "[!] Not enough crystals!");
								}
								break;
							case 11:
								player.sendMessage(ChatColor.RED + "[!] This kit is the max level!");
								break;
						}
						new PlayerDataSaver().saveUsers(player);
						return;
					}

					player.sendMessage(ChatColor.RED + "[!] You haven't unlocked " + kitObject.getName() + ".");
					return;
				}
			}
		}
	}
}
