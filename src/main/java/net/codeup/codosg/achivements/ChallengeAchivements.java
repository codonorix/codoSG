package net.codeup.codosg.achivements;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChallengeAchivements implements Listener {
	@EventHandler
	public void mythicalItemAchi(PlayerInteractEvent event) {
		return;
//		if(!(event.getClickedBlock().getState() instanceof Chest)) {
//			return;
//		}
//
//		Inventory chestInv = ((Chest) event.getClickedBlock().getState()).getInventory();
//
//		if(chestInv.contains(new PowerStar().powerStar())) {
//			event.getPlayer().sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "✪" + ChatColor.LIGHT_PURPLE + " Find the power star " + ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "✪");
//		}
//
//		for(ItemStack item : ((Chest) event.getClickedBlock()).getBlockInventory()) {
//			if(item == null) return;
//
//			ItemMeta itemMeta = item.getItemMeta();
//
//			NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "RARITY_KEY");
//
//			if(!(itemMeta.getPersistentDataContainer().has(key, PersistentDataType.INTEGER))) return;
//			if(itemMeta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER) == 5) {
//				event.getPlayer().sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "✪" + ChatColor.LIGHT_PURPLE + " Find a Mythical Item " + ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "✪");
//			}
//		}
	}
}
