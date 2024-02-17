package com.farhad.example.factory.abstract_factory.door;

public class Carpenter implements DoorFittingExpert {

	@Override
	public String getDescription() {
		return "I can only fit wooden doors!"; 
	}

}
