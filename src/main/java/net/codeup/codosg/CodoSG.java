package net.codeup.codosg;

import net.codeup.codosg.achivements.ChallengeAchivements;
import net.codeup.codosg.arena_creator.ArenaCoreCommand;
import net.codeup.codosg.arena_creator.ArenaCreatorCommand;
import net.codeup.codosg.arena_creator.arena_command_inv.arena_edit_gui.ArenaEditClickEvent;
import net.codeup.codosg.arena_creator.arena_signs.SignCreator;
import net.codeup.codosg.arena_creator.arena_signs.SignDestroy;
import net.codeup.codosg.arena_creator.arena_signs.SignJoin;
import net.codeup.codosg.commands.JoinArena;
import net.codeup.codosg.commands.admin.CrystalsGive;
import net.codeup.codosg.commands.admin.KitTable;
import net.codeup.codosg.lobby.JoinEvent;
import net.codeup.codosg.lobby.LeaveEvent;
import net.codeup.codosg.lobby.events.LobbyCoreEvents;
import net.codeup.codosg.lobby.kit_table.KitTableEffect;
import net.codeup.codosg.lobby.kit_table.KitTableOpen;
import net.codeup.codosg.lobby.lobby_events.ItemClickEvent;
import net.codeup.codosg.lobby.lobby_events.KitClickEvent;
import net.codeup.codosg.lobby.lobby_events.LobbyMenuClickEvent;
import net.codeup.codosg.yml_reader.ArenaLoaderAndSaver;
import net.codeup.codosg.yml_reader.JoinSignLoaderAndSaver;
import net.codeup.codosg.yml_reader.KitTableLoaderAndSaver;
import net.codeup.codosg.yml_reader.PlayerDataSaver;
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

		//? KitTables =====================================================================
		File kitTables = new File(getDataFolder(), "kitTable.yml");

		if(!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}

		if(!kitTables.exists()) {
			try {
				kitTables.createNewFile();
				YamlConfiguration loadFile = YamlConfiguration.loadConfiguration(kitTables);
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
			new KitTableEffect().kitTableEffect();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		//Load KitTables
		try {
			new KitTableLoaderAndSaver().loadTables();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		//?================================================================================
		getCommand("createArena").setExecutor(new ArenaCreatorCommand());
		getCommand("arena").setExecutor(new ArenaCoreCommand());
		getCommand("join").setExecutor(new JoinArena());
		getCommand("kittable").setExecutor(new KitTable());
		getCommand("crystalsgive").setExecutor(new CrystalsGive());


		Bukkit.getPluginManager().registerEvents(new ArenaEditClickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new SignCreator(), this);
		Bukkit.getPluginManager().registerEvents(new SignDestroy(), this);
		Bukkit.getPluginManager().registerEvents(new SignJoin(), this);
		Bukkit.getPluginManager().registerEvents(new ItemClickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LobbyMenuClickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LeaveEvent(), this);
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new KitTable(), this);
		Bukkit.getPluginManager().registerEvents(new KitTableOpen(), this);
		Bukkit.getPluginManager().registerEvents(new KitClickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LobbyCoreEvents(), this);

		//?======================| ACHIVE EVENTS |=============================
		Bukkit.getPluginManager().registerEvents(new ChallengeAchivements(), this);
	}

	@Override
	public void onDisable() {
		try {
			new PlayerDataSaver().saveUsers();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		// Plugin shutdown logic
	}

	public static CodoSG getInstance() {
		return instance;
	}
}
