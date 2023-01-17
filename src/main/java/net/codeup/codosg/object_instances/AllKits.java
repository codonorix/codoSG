package net.codeup.codosg.object_instances;

import net.codeup.codosg.kits.common.ArcherKit;
import net.codeup.codosg.kits.common.ArmorKit;
import net.codeup.codosg.kits.common.KnightKit;
import net.codeup.codosg.objects.KitObject;
import net.codeup.codosg.objects.PlayerObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class AllKits {
	private static ArrayList<KitObject> commonKits = null;
	private static HashMap<String, KitObject> rareKits = null;
	private static HashMap<String, KitObject> epicKits = null;


	public static ArrayList<KitObject> getCommonKits() {
		if(commonKits == null) {
			ArrayList<KitObject> allKits = new ArrayList<>();
			KitObject knight = new KnightKit().getKit();
			KitObject archer = new ArcherKit().getKit();
			KitObject armor = new ArmorKit().getKit();

			allKits.add(knight);
			allKits.add(archer);
			allKits.add(armor);

			commonKits = allKits;
		}
		return commonKits;
	}

//	public static HashMap<String, KitObject> getRareKits() {
//		if(commonKits == null) {
//			commonKits = new HashMap<>();
//		}
//		return commonKits;
//	}
//
//	public static HashMap<String, KitObject> getEpicKits() {
//		if(commonKits == null) {
//			commonKits = new HashMap<>();
//		}
//		return commonKits;
//	}
}

