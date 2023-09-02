package com.farhad.example.extensionobjects.units;

import java.util.Optional;

import com.farhad.example.extensionobjects.abstractextensions.UnitExtention;
import com.farhad.example.extensionobjects.concreteextensions.Soldier;

public class SoldierUnit extends Unit {

	public SoldierUnit(String name) {
		super(name);
	}

	@Override
	public UnitExtention getUnitExtention(String extensionName) {
		if (extensionName.equals("SoldierExtension")) {
			return Optional.ofNullable(unitExtention)
						.orElseGet(() -> new Soldier(this)) ;
		}
		return super.getUnitExtention(extensionName);
	}

	
}
