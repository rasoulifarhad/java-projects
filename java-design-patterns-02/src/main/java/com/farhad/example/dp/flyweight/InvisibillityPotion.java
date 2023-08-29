package com.farhad.example.dp.flyweight;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvisibillityPotion implements Potion {

	@Override
	public void drink() {
		log.info("You become invisible. (Potion={})", System.identityHashCode(this));
	}
	
}
