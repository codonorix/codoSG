package net.codeup.codosg.objects;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class PlayerObject {
	private Player player;
	private int wins;
	private int losses;
	private int kills;
	private int assists;
	private int crystals;
	private int darkCrystals;
	private int keys;
	private String currentGame;
	private KitObject selectedKit;
	private ArrayList<HashMap<KitObject, Integer>> unlockedKits;
	private ArrayList<PowerUpObject> unlockedPowerups;

	public PlayerObject(Player player, int wins, int losses, int kills, int assists, int crystals, int darkCrystals, int keys, String currentGame, KitObject selectedKit, ArrayList<HashMap<KitObject, Integer>> unlockedKits, ArrayList<PowerUpObject> unlockedPowerups) {
		this.player = player;
		this.wins = wins;
		this.losses = losses;
		this.kills = kills;
		this.assists = assists;
		this.crystals = crystals;
		this.darkCrystals = darkCrystals;
		this.keys = keys;
		this.currentGame = currentGame;
		this.selectedKit = selectedKit;
		this.unlockedKits = unlockedKits;
		this.unlockedPowerups = unlockedPowerups;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getCrystals() {
		return crystals;
	}

	public void setCrystals(int crystals) {
		this.crystals = crystals;
	}

	public int getDarkCrystals() {
		return darkCrystals;
	}

	public void setDarkCrystals(int darkCrystals) {
		this.darkCrystals = darkCrystals;
	}

	public int getKeys() {
		return keys;
	}

	public void setKeys(int keys) {
		this.keys = keys;
	}

	public String getCurrentGame() {
		return currentGame;
	}

	public void setCurrentGame(String currentGame) {
		this.currentGame = currentGame;
	}

	public KitObject getSelectedKit() {
		return selectedKit;
	}

	public void setSelectedKit(KitObject selectedKit) {
		this.selectedKit = selectedKit;
	}

	public ArrayList<HashMap<KitObject, Integer>> getUnlockedKits() {
		return unlockedKits;
	}

	public void setUnlockedKits(ArrayList<HashMap<KitObject, Integer>> unlockedKits) {
		this.unlockedKits = unlockedKits;
	}

	public ArrayList<PowerUpObject> getUnlockedPowerups() {
		return unlockedPowerups;
	}

	public void setUnlockedPowerups(ArrayList<PowerUpObject> unlockedPowerups) {
		this.unlockedPowerups = unlockedPowerups;
	}

	@Override
	public String toString() {
		return "PlayerObject{" +
				", player=" + player +
				", wins=" + wins +
				", losses=" + losses +
				", kills=" + kills +
				", assists=" + assists +
				", crystals=" + crystals +
				", darkCrystals=" + darkCrystals +
				", keys=" + keys +
				", currentGame='" + currentGame + '\'' +
				", selectedKit=" + selectedKit +
				", unlockedKits=" + unlockedKits +
				", unlockedPowerups=" + unlockedPowerups +
				'}';
	}
}
