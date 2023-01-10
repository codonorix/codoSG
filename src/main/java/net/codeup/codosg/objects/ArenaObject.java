package net.codeup.codosg.objects;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class ArenaObject {
	private int id;
	private String name;
	private Location waitingLobby;
	private List<Location> spawnPoints;
	private List<Location> chestLocations;
	private boolean inGame;

	public ArenaObject(int id, String name, Location waitingLobby, List<Location> spawnPoints, List<Location> chestLocations, boolean inGame) {
		this.id = id;
		this.name = name;
		this.waitingLobby = waitingLobby;
		this.spawnPoints = spawnPoints;
		this.chestLocations = chestLocations;
		this.inGame = inGame;
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
}
