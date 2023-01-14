package net.codeup.codosg.achivements;

import net.codeup.codosg.CodoSG;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Chest;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class ChallengeAchivements implements Listener {
	@EventHandler
	public void mythicalItemAchi(PlayerInteractEvent event) {

		if(!(event.getClickedBlock() instanceof Chest)) {
			return;
		}

		for(ItemStack item : ((Chest) event.getClickedBlock()).getBlockInventory()) {
			if(item == null) return;

			ItemMeta itemMeta = item.getItemMeta();

			NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "RARITY_KEY");

			if(!(itemMeta.getPersistentDataContainer().has(key, PersistentDataType.INTEGER))) return;
			if(itemMeta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER) == 5) {
				event.getPlayer().sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "✪" + ChatColor.LIGHT_PURPLE + " Find a Mythical Item " + ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "✪");
			}
		}
	}
}
