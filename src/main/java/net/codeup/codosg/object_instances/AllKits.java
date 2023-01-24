package net.codeup.codosg.object_instances;

import net.codeup.codosg.kits.common.ArcherKit;
import net.codeup.codosg.kits.common.ArmorKit;
import net.codeup.codosg.kits.common.BakerKit;
import net.codeup.codosg.kits.common.KnightKit;
import net.codeup.codosg.objects.KitObject;
import java.util.HashMap;

public class AllKits {
	private static HashMap<Integer, KitObject> commonKits = null;
	private static HashMap<String, KitObject> rareKits = null;
	private static HashMap<String, KitObject> epicKits = null;


	public static HashMap<Integer, KitObject> getCommonKits() {
		if(commonKits == null) {
			HashMap<Integer, KitObject> allKits = new HashMap<>();
			KitObject knight = new KnightKit().getKit();
			KitObject archer = new ArcherKit().getKit();
			KitObject armor = new ArmorKit().getKit();
			KitObject baker = new BakerKit().getKit();

			allKits.put(knight.getId(), knight);
			allKits.put(archer.getId(), archer);
			allKits.put(armor.getId(), armor);
			allKits.put(baker.getId(), baker);

			commonKits = allKits;
		}
		return commonKits;
	}
}

