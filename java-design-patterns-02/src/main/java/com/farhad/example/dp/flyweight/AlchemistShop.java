package com.farhad.example.dp.flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.farhad.example.dp.flyweight.PotionFactory.PotionType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlchemistShop {
	
	private final List<Potion> topShelf;
	private final List<Potion> bottomShelf;

	public AlchemistShop() {
		PotionFactory factory = new PotionFactory();
		topShelf = new ArrayList<>(
			Arrays.asList(
				factory.createPotion(PotionType.INVISIBILITY),
				factory.createPotion(PotionType.INVISIBILITY),
				factory.createPotion(PotionType.HOLY_WATER),
				factory.createPotion(PotionType.HEALING),
				factory.createPotion(PotionType.INVISIBILITY),
				factory.createPotion(PotionType.HOLY_WATER),
				factory.createPotion(PotionType.HEALING),
				factory.createPotion(PotionType.HEALING),
				factory.createPotion(PotionType.INVISIBILITY)));

		bottomShelf = new ArrayList<>(
			Arrays.asList(
				factory.createPotion(PotionType.HEALING),
				factory.createPotion(PotionType.HEALING),
				factory.createPotion(PotionType.HEALING),
				factory.createPotion(PotionType.HOLY_WATER),
				factory.createPotion(PotionType.HOLY_WATER)));
	}

	public List<Potion> getTopShelf() {
		return new ArrayList<>(topShelf);
	}

	public List<Potion> getBottomShelf() {
		return new ArrayList<>(bottomShelf);
	}

	public void drinkPotions() {
		log.info("Drinking top shelf potions\n");
		topShelf.forEach(Potion::drink);
		log.info("Drinking bottom shelf potions\n");
		bottomShelf.forEach(Potion::drink);
	}
}
