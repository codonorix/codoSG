package net.codeup.codosg.arena_creator.arena_signs;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.arena_creator.ArenaCoreCommand;
import net.codeup.codosg.items.PowerStar;
import net.codeup.codosg.object_instances.AllArenas;
import net.codeup.codosg.object_instances.AllJoinSigns;
import net.codeup.codosg.object_instances.AllKits;
import net.codeup.codosg.object_instances.AllPlayers;
import net.codeup.codosg.objects.ArenaObject;
import net.codeup.codosg.objects.KitObject;
import net.codeup.codosg.objects.PlayerObject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
		player.getInventory().clear();
		player.teleport(arenaObject.getWaitingLobby());

		if (arenaObject.getPlayersInGame().size() == 1) {
			startGame(arenaObject);
		}
	}

	private HashMap<Player, Location> spawnLocation = new HashMap<>();

	private void startGame(ArenaObject arenaObject) {
		new BukkitRunnable() {
			final int[] waitingLobbyCounter = {5};

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
		Random random = new Random();
		final int[] waitingCounter = {15};
		final boolean[] gameStarted = {false};
		final int[] mainGameTimer = {200};
		final int[] nextEventTimer = {2};
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
						player.setInvulnerable(true);

						gameStarted[0] = true;

						try {
							new ArenaCoreCommand().loadChests(arenaObject.getName());
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					}
					gameStarted[0] = true;
				}

				if (gameStarted[0]) {
					if(gameStage[0] == 1 && nextEventTimer[0] == 0) {
						gameStage[0] = 2;
//						nextEventTimer[0] = 60;
						nextEventTimer[0] = 2;

						nextEvent[0] = "Get Kit";
						for (Player player : arenaObject.getPlayersInGame()) {
							player.sendMessage(ChatColor.RED + "Grace period has ended!");
							player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
							player.setInvulnerable(false);
						}
					}

					if(gameStage[0] == 2 && nextEventTimer[0] == 0) {
						gameStage[0] = 3;
//						nextEventTimer[0] = 60 * 3;
						nextEventTimer[0] = 2;

						nextEvent[0] = "PowerUp Box";

						for (Player player : arenaObject.getPlayersInGame()) {
							player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);

							PlayerObject playerObject = AllPlayers.getInstance().get(player.getUniqueId());
							if(playerObject.getSelectedKit() == -1) {
								player.sendMessage(ChatColor.RED + "You haven't selected a kit :(");
								continue;
							}

							KitObject kitObject = AllKits.getCommonKits().get(playerObject.getSelectedKit());
							int level = playerObject.getUnlockedKits().get(playerObject.getSelectedKit());

							switch (level) {
								case 1:
									for(ItemStack itemStack : kitObject.getLevelOne())
										player.getInventory().addItem(itemStack);
									break;
								case 2:
									for(ItemStack itemStack : kitObject.getLevelTwo())
										player.getInventory().addItem(itemStack);
									break;
								case 3:
									for(ItemStack itemStack : kitObject.getLevelThree())
										player.getInventory().addItem(itemStack);
									break;
								case 4:
									for(ItemStack itemStack : kitObject.getLevelFour())
										player.getInventory().addItem(itemStack);
									break;
								case 5:
									for(ItemStack itemStack : kitObject.getLevelFive())
										player.getInventory().addItem(itemStack);
									break;
								case 6:
									for(ItemStack itemStack : kitObject.getLevelSix())
										player.getInventory().addItem(itemStack);
									break;
								case 7:
									for(ItemStack itemStack : kitObject.getLevelSeven())
										player.getInventory().addItem(itemStack);
									break;
								case 8:
									for(ItemStack itemStack : kitObject.getLevelEight())
										player.getInventory().addItem(itemStack);
									break;
								case 9:
									for(ItemStack itemStack : kitObject.getLevelNine())
										player.getInventory().addItem(itemStack);
									break;
								case 10:
									for(ItemStack itemStack : kitObject.getLevelTen())
										player.getInventory().addItem(itemStack);
									break;
							}
						}
					}

					if(gameStage[0] == 3 && nextEventTimer[0] == 0) {
						gameStage[0] = 4;
						nextEventTimer[0] = 60 * 3;
						nextEvent[0] = "Chest Refill";

						Location location = arenaObject.getChestLocations().get(random.nextInt(arenaObject.getChestLocations().size() - 1));
						Chest chest = (Chest) location.getBlock().getState();

						chest.getInventory().setItem(12,new PowerStar().powerStar());

						for (Player player : arenaObject.getPlayersInGame()) {
							player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
							player.sendMessage(ChatColor.GREEN + "[!] A powerful star has spawned in one of the chests...");
							player.sendMessage("Location: " + location);
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
