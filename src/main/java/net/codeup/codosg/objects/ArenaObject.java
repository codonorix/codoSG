package net.codeup.codosg.objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ArenaObject {
	private int id;
	private String name;
	private Location waitingLobby;
	private List<Location> spawnPoints;
	private List<Location> chestLocations;
	private boolean inGame;
	private List<Player> playersInGame;
	public ArenaObject(int id, String name, Location waitingLobby, List<Location> spawnPoints, List<Location> chestLocations, boolean inGame, List<Player> playersInGame) {
		this.id = id;
		this.name = name;
		this.waitingLobby = waitingLobby;
		this.spawnPoints = spawnPoints;
		this.chestLocations = chestLocations;
		this.inGame = inGame;
		this.playersInGame = playersInGame;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getWaitingLobby() {
		return waitingLobby;
	}

	public void setWaitingLobby(Location waitingLobby) {
		this.waitingLobby = waitingLobby;
	}

	public List<Location> getSpawnPoints() {
		return spawnPoints;
	}

	public void setSpawnPoints(List<Location> spawnPoints) {
		this.spawnPoints = spawnPoints;
	}

	public List<Location> getChestLocations() {
		return chestLocations;
	}

	public void setChestLocations(List<Location> chestLocations) {
		this.chestLocations = chestLocations;
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	public List<Player> getPlayersInGame() {
		return playersInGame;
	}

	public void setPlayersInGame(List<Player> playersInGame) {
		this.playersInGame = playersInGame;
	}

	@Override
	public String toString() {
		return "ArenaObject{" +
				"id=" + id +
				", name='" + name + '\'' +
				", waitingLobby=" + waitingLobby +
				", spawnPoints=" + spawnPoints +
				", chestLocations=" + chestLocations +
				", inGame=" + inGame +
				", playersInGame=" + playersInGame +
				'}';
	}
}
