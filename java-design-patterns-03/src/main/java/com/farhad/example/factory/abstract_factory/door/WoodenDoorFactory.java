package com.farhad.example.factory.abstract_factory.door;

public class WoodenDoorFactory implements DoorFactory {

	@Override
	public Door makeDoor() {
		return new WoodenDoor();
	}

	@Override
	public DoorFittingExpert makeFittingExpert() {
		return new Carpenter();
	}

}
