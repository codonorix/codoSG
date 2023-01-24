package net.codeup.codosg.lobby.kit_table;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.arena_creator.arena_command_inv.ListArenasInvHolder;
import net.codeup.codosg.lobby.invintories.LobbyItemInvHolder;
import net.codeup.codosg.object_instances.AllKitTables;
import net.codeup.codosg.object_instances.AllKits;
import net.codeup.codosg.object_instances.AllPlayers;
import net.codeup.codosg.objects.KitObject;
import net.codeup.codosg.objects.PlayerObject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KitTableOpen implements Listener {
	@EventHandler
	public void tableInteract(PlayerInteractEvent event) {
		if (event.getClickedBlock() == null) return;
		if (!(AllKitTables.getInstance().contains(event.getClickedBlock().getLocation()))) return;

		event.setCancelled(true);

		Player player = event.getPlayer();
		PlayerObject playerObject = AllPlayers.getInstance().get(player.getUniqueId());

		if (playerObject.getKeys() < 1) {
			player.sendMessage(ChatColor.RED + "[!] You have no keys. Buy some in the shop or find the in game.");
			return;
		}

		int keys = playerObject.getKeys();
		playerObject.setKeys(keys - 1);

		kitsInv(player);

	}

	private void kitsInv(Player player) {
		final int[] counter = {10};
		final ArrayList<ItemStack> itemStacks = fillerItems();
		final ArrayList<KitObject> kits = new ArrayList<>(AllKits.getCommonKits().values());
		final PlayerObject playerObject = AllPlayers.getInstance().get(player.getUniqueId());
		new BukkitRunnable() {
			@Override
			public void run() {
				Inventory inventory = Bukkit.createInventory(new ListArenasInvHolder(), 9 * 3, "Kit Table");

				for (int i = 0; i < inventory.getSize(); i++) {
					Collections.shuffle(itemStacks);
					inventory.setItem(i, itemStacks.get(1));
				}

				Collections.shuffle(kits);
				ItemStack itemStack = new ItemStack(kits.get(0).getIcon());
				ItemMeta itemMeta = itemStack.getItemMeta();
				itemMeta.setDisplayName(ChatColor.WHITE + kits.get(0).getName());
				itemStack.setItemMeta(itemMeta);
				inventory.setItem(13, itemStack);

				player.openInventory(inventory);

				if (counter[0] <= 0) {
					if(playerObject.getUnlockedKits() == null) {
						playerObject.setUnlockedKits(new HashMap<>());
					}

					if(playerObject.getUnlockedKits().containsKey(kits.get(0).getId())) {
						player.sendMessage(ChatColor.GREEN + "[!] You already have the " + kits.get(0).getName() + " kit!");
						cancel();
						return;
					}
					player.sendMessage(ChatColor.GREEN + "[!] You unlocked the " + kits.get(0).getName() + " kit!");
					HashMap<Integer, Integer> kitObjectsFromUser = playerObject.getUnlockedKits();
					kitObjectsFromUser.put(kits.get(0).getId(), 1);
					playerObject.setUnlockedKits(kitObjectsFromUser);

					cancel();
					return;
				}
				counter[0]--;
			}
		}.runTaskTimer(CodoSG.getInstance(), 0, 10);
	}

	private ArrayList<ItemStack> fillerItems() {
		ArrayList<ItemStack> itemStacks = new ArrayList<>();

		itemStacks.add(new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE));
		itemStacks.add(new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
		itemStacks.add(new ItemStack(Material.PURPLE_STAINED_GLASS_PANE));

		return itemStacks;
	}
}
