package com.farhad.example.proxy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class WizardTowerProxy implements WizardTower {

	private static final int ALLOWED_WIZARD_COUNT = 3;

	private final WizardTower tower;

	private int numberOfWizad = 0;

	@Override
	public void enter(Wizard wizard) {
		if (numberOfWizad < ALLOWED_WIZARD_COUNT) {
			tower.enter(wizard);
			numberOfWizad++;
		} else {
			log.info("{} is not allowed to enter", wizard);
		}
	} 
	

}
