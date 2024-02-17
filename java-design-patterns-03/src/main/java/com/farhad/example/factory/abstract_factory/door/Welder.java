package com.farhad.example.factory.abstract_factory.door;

public class Welder implements DoorFittingExpert {

	@Override
	public String getDescription() {
		return "I can only fit iron doors!";
	}

}
