package net.codeup.codosg.lobby.kit_table;

import net.codeup.codosg.CodoSG;
import net.codeup.codosg.object_instances.AllKitTables;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Cod;
import org.bukkit.scheduler.BukkitRunnable;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class KitTableEffect {
	public void kitTableEffect() {
		new BukkitRunnable() {
			final int[] degree = {360};
			final int[] degreeTwo = {0};

			@Override
			public void run() {
				for (Location location : AllKitTables.getInstance()) {
					double radians = Math.toRadians(degree[0]);
					double x = cos(radians);
					double z = sin(radians);

					Location location1 = location;

					location1.add(x+0.5, 1, z+0.5);
					location1.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, location1,0);
					location1.subtract(x+0.5, 1, z+0.5);

					Location location2 = location;

					double radiansTwo = Math.toRadians(degreeTwo[0]);
					double xTwo = cos(radiansTwo);
					double zTwo = sin(radiansTwo);

					location2.add(xTwo+0.5, 1, zTwo+0.5);
					location2.getWorld().spawnParticle(Particle.FLAME, location,0);
					location2.subtract(xTwo+0.5, 1, zTwo+0.5);
				}
				degree[0]--;
				degreeTwo[0]++;

				if (degree[0] <= 0) {
					degree[0] = 360;
					degreeTwo[0] = 0;
				}
			}
		}.runTaskTimer(CodoSG.getInstance(), 0, 1);
	}
}
