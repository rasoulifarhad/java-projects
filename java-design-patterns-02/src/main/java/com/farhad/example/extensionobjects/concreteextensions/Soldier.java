package com.farhad.example.extensionobjects.concreteextensions;

import com.farhad.example.extensionobjects.abstractextensions.SoldierExtension;
import com.farhad.example.extensionobjects.units.SoldierUnit;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@RequiredArgsConstructor
@Slf4j
public class Soldier implements SoldierExtension {

	private final SoldierUnit unit;
	@Override
	public void soldierReady() {
		log.info("[Soldier] {} is ready!", unit.getName());
	}
	
}