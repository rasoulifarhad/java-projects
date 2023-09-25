package com.farhad.example.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IvoryTower implements WizardTower {

	@Override
	public void enter(Wizard wizard) {
		log.info("{} enters the tower.", wizard);
	}
	
}
