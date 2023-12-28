package com.farhad.example.design_principles02.lsp.demo1.bad;

public class Vehicle {
	public enum Direction {

	}

	String name;
	float speed = 100;
	Direction direction;

	
	public Vehicle(String name) {
		this.name = name;
	}

	public void goForward() {
		System.out.println(name + ": go forward...");
	}

	public void reverse() {
		System.out.println(name + ": reverse...");
	}

	public void turnRight() {
		System.out.println(name + ": turn right...");
	}

	public void turnLeft() {
		System.out.println(name + ": turn left...");
	}


}
