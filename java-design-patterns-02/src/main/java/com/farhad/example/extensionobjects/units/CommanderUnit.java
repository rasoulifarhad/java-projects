package com.farhad.example.extensionobjects.units;

import java.util.Optional;

import com.farhad.example.extensionobjects.abstractextensions.UnitExtention;
import com.farhad.example.extensionobjects.concreteextensions.Commander;

public class CommanderUnit extends Unit {

	public CommanderUnit(String name) {
		super(name);
	}

	@Override
	public UnitExtention getUnitExtention(String extensionName) {
		if(extensionName.equals("CommanderExtension")) {
			return Optional.ofNullable(unitExtention).orElseGet(() -> new Commander(this));
		}
		return super.getUnitExtention(extensionName);
	}
	
}
