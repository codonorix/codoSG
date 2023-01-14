package net.codeup.codosg;

import net.codeup.codosg.achivements.ChallengeAchivements;
import net.codeup.codosg.arena_creator.ArenaCoreCommand;
import net.codeup.codosg.arena_creator.ArenaCreatorCommand;
import net.codeup.codosg.arena_creator.arena_command_inv.arena_edit_gui.ArenaEditClickEvent;
import net.codeup.codosg.arena_creator.arena_signs.SignCreator;
import net.codeup.codosg.arena_creator.arena_signs.SignDestroy;
import net.codeup.codosg.arena_creator.arena_signs.SignJoin;
import net.codeup.codosg.arena_creator.events.ChestPlaceEvent;
import net.codeup.codosg.commands.JoinArena;
import net.codeup.codosg.lobby.JoinEvent;
import net.codeup.codosg.lobby.LeaveEvent;
import net.codeup.codosg.lobby.lobby_events.ItemClickEvent;
import net.codeup.codosg.lobby.lobby_events.LobbyMenuClickEvent;
import net.codeup.codosg.yml_reader.ArenaLoaderAndSaver;
import net.codeup.codosg.yml_reader.JoinSignLoaderAndSaver;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.YamlConfiguration;
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

		//? Maps =====================================================================
		File signs = new File(getDataFolder(), "signs.yml");

		if(!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}

		if(!signs.exists()) {
			try {
				signs.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		//? Users =====================================================================
		File users = new File(getDataFolder(), "users.yml");

		if(!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}

		if(!users.exists()) {
			try {
				users.createNewFile();
				YamlConfiguration loadFile = YamlConfiguration.loadConfiguration(users);
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

		//Load join signs
		try {
			new JoinSignLoaderAndSaver().loadSigns();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		//?================================================================================
		getCommand("createArena").setExecutor(new ArenaCreatorCommand());
		getCommand("arena").setExecutor(new ArenaCoreCommand());
		getCommand("join").setExecutor(new JoinArena());

		Bukkit.getPluginManager().registerEvents(new ChestPlaceEvent(), this);
		Bukkit.getPluginManager().registerEvents(new ArenaEditClickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new SignCreator(), this);
		Bukkit.getPluginManager().registerEvents(new SignDestroy(), this);
		Bukkit.getPluginManager().registerEvents(new SignJoin(), this);
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new ItemClickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LobbyMenuClickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LeaveEvent(), this);

		//?======================| ACHIVE EVENTS |=============================
		Bukkit.getPluginManager().registerEvents(new ChallengeAchivements(), this);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public static CodoSG getInstance() {
		return instance;
	}
}
