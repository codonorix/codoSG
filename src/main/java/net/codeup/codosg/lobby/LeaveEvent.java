package net.codeup.codosg.lobby;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.codeup.codosg.object_instances.AllPlayers;
import net.codeup.codosg.objects.KitObject;
import net.codeup.codosg.objects.PlayerObject;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;
import java.sql.*;

public class LeaveEvent implements Listener {
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) throws IOException {
		PlayerObject playerData = AllPlayers.getInstance().get(event.getPlayer().getUniqueId());
		Player player = event.getPlayer();
		Gson gson = new Gson();
		try {
			String url = "jdbc:mysql://localhost:3306/code-up-mc";
			String username = "root";
			String password = "root";

			Connection connection = DriverManager.getConnection(url, username, password);

			String selectUuid = "SELECT * FROM cu_sg_playerdata WHERE player_uuid = ?";

			PreparedStatement getUuid = connection.prepareStatement(selectUuid);
			getUuid.setString(1, player.getUniqueId().toString());
			getUuid.executeQuery();

			System.out.println("===================" + player.getUniqueId().toString());

			ResultSet returnedData = getUuid.getResultSet();

			if (returnedData.next()) {
				String updateData = "UPDATE cu_sg_playerdata SET wins = ?, losses = ?, kills = ?, assists = ?, crystals = ?, dark_crystals = ?, selected_kit = ?, unlocked_kits =?, unlocked_powerups = ?, `keys` = ? WHERE player_uuid = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(updateData);

				preparedStatement.setInt(1, playerData.getWins());
				preparedStatement.setInt(2, playerData.getLosses());
				preparedStatement.setInt(3, playerData.getKills());
				preparedStatement.setInt(4, playerData.getAssists());
				preparedStatement.setInt(5, playerData.getCrystals());
				preparedStatement.setInt(6, playerData.getDarkCrystals());
				preparedStatement.setString(7, gson.toJson(playerData.getSelectedKit()));
				preparedStatement.setString(8, gson.toJson(playerData.getUnlockedKits()));
				preparedStatement.setString(9, gson.toJson(playerData.getUnlockedPowerups()));
				preparedStatement.setInt(10, playerData.getKeys());
				preparedStatement.setString(11, player.getUniqueId().toString());
				preparedStatement.executeUpdate();
			} else {
				String insertData = "INSERT INTO cu_sg_playerdata (" +
						"player_uuid, " +
						"wins, " +
						"losses, " +
						"kills, " +
						"assists, " +
						"crystals, " +
						"dark_crystals, " +
						"selected_kit, " +
						"unlocked_kits, " +
						"unlocked_powerups, " +
						"`keys`) " +
						"VALUES (?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement preparedStatement = connection.prepareStatement(insertData);

				preparedStatement.setString(1, player.getUniqueId().toString());
				preparedStatement.setInt(2, playerData.getWins());
				preparedStatement.setInt(3, playerData.getLosses());
				preparedStatement.setInt(4, playerData.getKills());
				preparedStatement.setInt(5, playerData.getAssists());
				preparedStatement.setInt(6, playerData.getCrystals());
				preparedStatement.setInt(7, playerData.getDarkCrystals());
				preparedStatement.setString(8, gson.toJson(playerData.getSelectedKit()));
				preparedStatement.setString(9, gson.toJson(playerData.getUnlockedKits()));
				preparedStatement.setString(10, gson.toJson(playerData.getUnlockedPowerups()));
				preparedStatement.setInt(11, playerData.getKeys());

				preparedStatement.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
