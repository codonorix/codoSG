package net.codeup.codosg.lobby;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import net.codeup.codosg.object_instances.AllPlayers;
import net.codeup.codosg.objects.KitObject;
import net.codeup.codosg.objects.PlayerObject;
import net.codeup.codosg.objects.PowerUpObject;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class JoinEvent implements Listener {
	@EventHandler
	public void onJoinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		Gson gson = new Gson();

		try {
			String url = "jdbc:mysql://localhost:3306/code-up-mc";
			String username = "root";
			String password = "root";

			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();

			String selectPlayerSQL = "SELECT * FROM cu_sg_playerdata WHERE player_uuid = '" + player.getUniqueId() + "'";
			ResultSet selectPlayer = statement.executeQuery(selectPlayerSQL);

			boolean playerExists = false;
			while(selectPlayer.next()) {
				if(selectPlayer.getString("player_uuid").equals(player.getUniqueId().toString())) {
					playerExists = true;
				}
			}

			if(!playerExists) {
				String insertData = "INSERT INTO cu_sg_playerdata (player_uuid) VALUES (?)";
				PreparedStatement preparedStatement = connection.prepareStatement(insertData);

				preparedStatement.setString(1, player.getUniqueId().toString());

				int rowsAffect = preparedStatement.executeUpdate();
				System.out.println("Added rows");

				preparedStatement.close();
			}
			selectPlayer = statement.executeQuery(selectPlayerSQL);

			int wins = 0, losses = 0, kills = 0, assists = 0, crystals = 0, darkCrystals = 0, keys = 0;
			String currentGame = null;
			int selectedKit = -1;
			HashMap<Integer, Integer> unlockedKits = new HashMap<>();
			ArrayList<Integer> unlockedPowerups = new ArrayList<>();

			Type unlockedKitsType = new TypeToken<HashMap<Integer, Integer>>(){}.getType();
			Type unlockedPowerupsType = new TypeToken<ArrayList<Integer>>(){}.getType();

			while (selectPlayer.next()) {
				System.out.println("AEFAEGFBHEAUJGHAEIUGH" + selectPlayer.getString("player_uuid"));
				wins = selectPlayer.getInt("wins");
				losses = selectPlayer.getInt("losses");
				kills = selectPlayer.getInt("kills");
				assists = selectPlayer.getInt("assists");
				crystals = selectPlayer.getInt("crystals");
				darkCrystals = selectPlayer.getInt("dark_crystals");
				selectedKit = selectPlayer.getInt("selected_kit");
				unlockedKits = gson.fromJson(selectPlayer.getString("unlocked_kits"), unlockedKitsType);
				unlockedPowerups = gson.fromJson(selectPlayer.getString("unlocked_powerups"), unlockedPowerupsType);
				keys = selectPlayer.getInt("keys");

			}

			PlayerObject playerObject = new PlayerObject(player, wins, losses,kills,assists,crystals,darkCrystals,keys, null, selectedKit, unlockedKits, unlockedPowerups);
			System.out.println(playerObject);
			AllPlayers.getInstance().put(player.getUniqueId(), playerObject);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		player.teleport(new Location(Bukkit.getWorld("world"), -41, -21, -80));
		player.getInventory().clear();
		new LobbyJoinEvent().lobbyJoinEvent(event.getPlayer());

	}
}
