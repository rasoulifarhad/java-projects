package com.farhad.example.factory.abstract_factory.door;

public class App {

	public static void main(String[] args) {
		
		DoorFactory doorFactory = new WoodenDoorFactory();
		
		DoorFittingExpert expert = doorFactory.makeFittingExpert();
		Door door = doorFactory.makeDoor();
		System.out.println(door.getDescription());
		System.out.println(expert.getDescription());
	}
}
