package net.codeup.codosg;

import net.codeup.codosg.arena_creator.ArenaCoreCommand;
import net.codeup.codosg.arena_creator.ArenaCreatorCommand;
import net.codeup.codosg.arena_creator.events.ChestPlaceEvent;
import net.codeup.codosg.yml_reader.ArenaLoaderAndSaver;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class CodoSG extends JavaPlugin {
	private static CodoSG instance;

	@Override
	public void onEnable() {
		instance = this;


		//? Load Worlds ============================================
		File firstFolder = new File(getServer().getWorldContainer().toURI());
		File[] worlds = firstFolder.listFiles();

		for(File file : worlds) {
			System.out.println("==================================}}}}}" + file.getName());
			try {
				World world = Bukkit.createWorld(WorldCreator.name(file.getName()));
				world.setAutoSave(false);
			}catch (Exception ex){

			}
		}

		//? Maps =====================================================================
		File maps = new File(getDataFolder(), "maps.yml");

		if(!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}

		if(!maps.exists()) {
			try {
				maps.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		//Load Arenas
		try {
			new ArenaLoaderAndSaver().loadMaps();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		//?================================================================================
		getCommand("createArena").setExecutor(new ArenaCreatorCommand());
		getCommand("arena").setExecutor(new ArenaCoreCommand());

		Bukkit.getPluginManager().registerEvents(new ChestPlaceEvent(), this);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public static CodoSG getInstance() {
		return instance;
	}
}
