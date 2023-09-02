package com.farhad.example.extensionobjects.concreteextensions;

import com.farhad.example.extensionobjects.abstractextensions.CommanderExtension;
import com.farhad.example.extensionobjects.units.CommanderUnit;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Getter
public class Commander implements CommanderExtension {

	private final CommanderUnit unit;

	@Override
	public void commanderReady() {
		log.info("[Commander] {} is ready!", unit.getName());
	}
	
}
