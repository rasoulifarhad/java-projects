package com.farhad.example.dp.flyweight;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HealingPotion implements Potion {

	@Override
	public void drink() {
		log.info("you feel healed. (Potion={})", System.identityHashCode(this));
	}
	
}
