package net.codeup.codosg.arena_creator.arena_signs;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.object_instances.AllArenas;
import net.codeup.codosg.object_instances.AllJoinSigns;
import net.codeup.codosg.object_instances.AllPlayers;
import net.codeup.codosg.objects.ArenaObject;
import net.codeup.codosg.objects.PlayerObject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SignJoin implements Listener {
	@EventHandler
	public void onJoinSignClick(PlayerInteractEvent event) {
		if (event.getClickedBlock() == null) return;
		if (!(event.getClickedBlock().getState() instanceof Sign)) return;

		Sign sign = (Sign) event.getClickedBlock().getState();
		Player player = event.getPlayer();

		if (!(sign.getLine(0).contains("⦓JOIN⦔"))) return;
		String arenaName = sign.getLine(1);

		ArrayList<Player> players = (ArrayList<Player>) AllArenas.getInstance().get(arenaName).getPlayersInGame();
		ArenaObject arenaObject = AllArenas.getInstance().get(arenaName);

		if (players.size() >= arenaObject.getSpawnPoints().size()) {
			player.sendMessage(ChatColor.RED + "[!] This game is full!");
			return;
		}

		if (players.size() + 1 == arenaObject.getSpawnPoints().size()) {
			sign.setLine(0, ChatColor.RED + "⦓FULL⦔");
			sign.update();
		}

		players.add(event.getPlayer());
		AllArenas.getInstance().get(arenaName).setPlayersInGame(players);


		for (Location location : AllJoinSigns.getInstance().get(arenaName)) {
			Sign sign1 = (Sign) location.getBlock().getState();
			sign1.setLine(2, ChatColor.WHITE + "" + arenaObject.getPlayersInGame().size() + "/" + arenaObject.getSpawnPoints().size());
			sign1.update();
		}

		gameLogic(AllPlayers.getInstance().get(player.getUniqueId()), AllArenas.getInstance().get(arenaName));
	}

	public void gameLogic(PlayerObject playerObject, ArenaObject arenaObject) {
		Player player = playerObject.getPlayer();
		player.teleport(arenaObject.getWaitingLobby());

		if (arenaObject.getPlayersInGame().size() == 1) {
			startGame(arenaObject);
		}
	}

	private HashMap<Player, Location> spawnLocation = new HashMap<>();

	private void startGame(ArenaObject arenaObject) {
		new BukkitRunnable() {
			final int[] waitingLobbyCounter = {30};

			@Override
			public void run() {
				if (arenaObject.getPlayersInGame().size() < 1) {
					cancel();
					for (Player player : arenaObject.getPlayersInGame()) {
						player.sendMessage(ChatColor.RED + "[!] Not enough players to start the game! Aborting...");
					}
					return;
				}

				if (waitingLobbyCounter[0] == 0) {
					cancel();
					for (int i = 0; i < arenaObject.getPlayersInGame().size(); i++) {
						spawnLocation.put(arenaObject.getPlayersInGame().get(i), arenaObject.getSpawnPoints().get(i));
						arenaObject.getPlayersInGame().get(i).teleport(arenaObject.getSpawnPoints().get(i));
						coreGame(arenaObject);
					}
					return;
				}

				for (Player player : arenaObject.getPlayersInGame()) {
					player.sendMessage(ChatColor.GREEN + "Game starting in " + waitingLobbyCounter[0] + " seconds.");
				}

				waitingLobbyCounter[0]--;
			}
		}.runTaskTimer(CodoSG.getInstance(), 0, 20);
	}

	private void coreGame(ArenaObject arenaObject) {
		final int[] waitingCounter = {15};
		final boolean[] gameStarted = {false};
		final int[] mainGameTimer = {200};
		final int[] nextEventTimer = {15};
		final int[] gameStage = {1};

		/*
		(1) 15 seconds after game start - grace period ends
		(2) 45 seconds after grace period ends - get kit
		(3) 3 minutes after get kit - powerup box spawns
		(4) 3 minutes after powerup - chest refill
		(5) 5 minutes after refill - deathmatch
		(6) 5 minutes after deathmatch = game end
		 */
		final String[] nextEvent = {"Grace Ends"};

		new BukkitRunnable() {
			@Override
			public void run() {
				for (Player player : arenaObject.getPlayersInGame()) {
					player.setScoreboard(gameBoard((ArrayList<Player>) arenaObject.getPlayersInGame(), nextEventTimer[0],nextEvent[0]));
				}

				if (!(waitingCounter[0] <= 0)) {
					for (Map.Entry<Player, Location> entry : spawnLocation.entrySet()) {
						entry.getKey().teleport(entry.getValue());
					}
					waitingCounter[0]--;
				} else if (!gameStarted[0]) {
					for (Player player : arenaObject.getPlayersInGame()) {
						player.sendMessage(ChatColor.GREEN + "The game has started!");
					}
					gameStarted[0] = true;
				}

				if (gameStarted[0]) {
					if(gameStage[0] == 1 && nextEventTimer[0] == 0) {
						gameStage[0] = 2;
						nextEventTimer[0] = 60;
						nextEvent[0] = "Get Kit";
						for (Player player : arenaObject.getPlayersInGame()) {
							player.sendMessage(ChatColor.RED + "Grace period has ended!");
							player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
						}
					}

					if(gameStage[0] == 2 && nextEventTimer[0] == 0) {
						gameStage[0] = 3;
						nextEventTimer[0] = 60 * 3;
						nextEvent[0] = "PowerUp Box";
						for (Player player : arenaObject.getPlayersInGame()) {
							player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
							player.sendMessage(ChatColor.GREEN + "[!] A powerful star has spawned in one of the chests...");
						}
					}

					if(gameStage[0] == 3 && nextEventTimer[0] == 0) {
						gameStage[0] = 4;
						nextEventTimer[0] = 60 * 3;
						nextEvent[0] = "Chest Refill";
						for (Player player : arenaObject.getPlayersInGame()) {
							player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
						}
					}

					if(gameStage[0] == 5 && nextEventTimer[0] == 0) {
						gameStage[0] = 6;
						nextEventTimer[0] = 60 * 5;
						nextEvent[0] = "Death Match";
						for (Player player : arenaObject.getPlayersInGame()) {
							player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
						}
					}

					if(gameStage[0] == 6 && nextEventTimer[0] == 0) {
						gameStage[0] = 7;
						nextEventTimer[0] = 60 * 5;
						nextEvent[0] = "Game End";
						for (Player player : arenaObject.getPlayersInGame()) {
							player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
						}
					}

					nextEventTimer[0]--;
				}


			}
		}.runTaskTimer(CodoSG.getInstance(), 0, 20);
	}

	private Scoreboard gameBoard(ArrayList<Player> players, int timer, String nextEvent) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();

		Objective objective = board.registerNewObjective("inGameBoard", "dummy");

		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "✦ CodoSG ✦");

		Score website = objective.getScore(ChatColor.LIGHT_PURPLE + "code-up.net");
		Score blank = objective.getScore("");
		Score blankTwo = objective.getScore(" ");
		Score nextEventScore = objective.getScore(ChatColor.LIGHT_PURPLE + "Next Event: " + ChatColor.RESET + nextEvent);
		Score countDown = objective.getScore(ChatColor.LIGHT_PURPLE + "❅ Next Event Time: " + ChatColor.RESET + timer);
		Score playersAlive = objective.getScore(ChatColor.LIGHT_PURPLE + "♖ Players Alive: " + ChatColor.RESET + players.size());

		blankTwo.setScore(6);
		nextEventScore.setScore(5);
		countDown.setScore(4);
		playersAlive.setScore(3);
		blank.setScore(2);
		website.setScore(1);

		return board;
	}
}
