package com.farhad.example.design_principles02.lsp.demo1.bad;

public class Vehicle {
	public enum Direction {

	}
	float speed;
	Direction direction;

	public void goForward() {
		System.out.println("go forward...");
	}

	public void reverse() {
		System.out.println("reverse...");
	}

	public void turnRight() {
		System.out.println("turn right...");
	}

	public void turnLeft() {
		System.out.println("turn left...");
	}


}
