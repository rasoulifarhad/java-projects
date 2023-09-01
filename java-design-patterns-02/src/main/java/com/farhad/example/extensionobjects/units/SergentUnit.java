package com.farhad.example.extensionobjects.units;

import java.util.Optional;

import com.farhad.example.extensionobjects.abstractextensions.UnitExtention;
import com.farhad.example.extensionobjects.concreteextensions.Sergent;

public class SergentUnit extends Unit {

	public SergentUnit(String name) {
		super(name);
	}

	@Override
	public UnitExtention getUnitExtention(String extensionName) {
		if( extensionName.equals("SergentExtension") ) {
			return Optional.ofNullable(unitExtention).orElseGet(() -> new Sergent(this));
		}
		return super.getUnitExtention(extensionName);
	}

	
	
}
