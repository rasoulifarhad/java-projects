package com.farhad.example.dp.flyweight;

import java.util.EnumMap;
import java.util.Map;

// actual Flyweight class , which is the factory for creating potions.
public class PotionFactory {
	
	private final Map<PotionType, Potion> potions;
	enum PotionType {
		HEALING, HOLY_WATER, INVISIBILITY;
	}
	public PotionFactory() {
		potions = new EnumMap<>(PotionType.class);
	}

	public Potion createPotion(PotionType potionType) {
		Potion potion = potions.get(potionType);
		if(potion == null) {

			switch (potionType) {
				case HEALING:
					potion = new HealingPotion();
					potions.put(potionType, potion);
					break;
				case HOLY_WATER:
					potion = new HolyWaterPotion();
					potions.put(potionType, potion);
					break;
				case INVISIBILITY:
					potion = new InvisibillityPotion();
					potions.put(potionType, potion);
					break;
			
				default:
					break;
			}
		}
		return potion;
	}

	

}
