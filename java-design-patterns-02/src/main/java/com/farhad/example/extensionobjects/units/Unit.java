package com.farhad.example.extensionobjects.units;

import com.farhad.example.extensionobjects.abstractextensions.UnitExtention;

import lombok.Getter;

public class Unit {
	@Getter
	private String name;

	protected UnitExtention unitExtention= null;

	public Unit(String name) {
		this.name = name;
	}

	public UnitExtention getUnitExtention(String extensionName) {
		return null;
	}
}
