package net.codeup.codosg.commands.admin;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.object_instances.AllKitTables;
import net.codeup.codosg.object_instances.AllKits;
import net.codeup.codosg.yml_reader.KitTableLoaderAndSaver;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;
import java.util.List;

public class KitTable implements CommandExecutor, Listener {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(player.hasPermission("codosg.admin"))) return false;

		player.getInventory().addItem(kitTableItem());
		player.sendMessage(String.valueOf(AllKitTables.getInstance()));

		return false;
	}

	private ItemStack kitTableItem() {
		ItemStack itemStack = new ItemStack(Material.ENCHANTING_TABLE, 1);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(ChatColor.AQUA + "Kit Table");

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "KIT_TABLE");
		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "KIT_TABLE");

		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	@EventHandler
	public void kitTablePlace(BlockPlaceEvent event) throws IOException {
		if(event.getItemInHand().getItemMeta().getPersistentDataContainer() == null) return;

		NamespacedKey key = new NamespacedKey(CodoSG.getInstance(), "KIT_TABLE");
		if(!(event.getItemInHand().getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING))) return;

		AllKitTables.getInstance().add(event.getBlockPlaced().getLocation());
		new KitTableLoaderAndSaver().saveTables();

		event.getPlayer().sendMessage(ChatColor.GREEN + "[!] Kit table placed!");
	}

	@EventHandler
	public void kitTableBreak(BlockBreakEvent event) throws IOException {
		if(!(AllKitTables.getInstance().contains(event.getBlock().getLocation()))) return;

		AllKitTables.getInstance().remove(event.getBlock().getLocation());
		new KitTableLoaderAndSaver().saveTables();
		event.getPlayer().sendMessage(ChatColor.GREEN + "[!] Kit table destroyed!");
	}
}
