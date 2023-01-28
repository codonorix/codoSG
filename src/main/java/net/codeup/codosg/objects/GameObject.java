package net.codeup.codosg.objects;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GameObject {
	private int id;
	private String gameName;
	ArenaObject arenaObject;
	ArrayList<Player> allPlayers;
	ArrayList<Player> deadPlayers;
	ArrayList<Player> alivePlayers;

	public GameObject(int id, String gameName, ArenaObject arenaObject, ArrayList<Player> allPlayers, ArrayList<Player> deadPlayers, ArrayList<Player> alivePlayers) {
		this.id = id;
		this.gameName = gameName;
		this.arenaObject = arenaObject;
		this.allPlayers = allPlayers;
		this.deadPlayers = deadPlayers;
		this.alivePlayers = alivePlayers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public ArenaObject getArenaObject() {
		return arenaObject;
	}

	public void setArenaObject(ArenaObject arenaObject) {
		this.arenaObject = arenaObject;
	}

	public ArrayList<Player> getAllPlayers() {
		return allPlayers;
	}

	public void setAllPlayers(ArrayList<Player> allPlayers) {
		this.allPlayers = allPlayers;
	}

	public ArrayList<Player> getDeadPlayers() {
		return deadPlayers;
	}

	public void setDeadPlayers(ArrayList<Player> deadPlayers) {
		this.deadPlayers = deadPlayers;
	}

	public ArrayList<Player> getAlivePlayers() {
		return alivePlayers;
	}

	public void setAlivePlayers(ArrayList<Player> alivePlayers) {
		this.alivePlayers = alivePlayers;
	}
}
