package com.farhad.example.design_principles02.interface_demo;

public class Cube implements Shape {

	int x = 10;

	@Override
	public double area() {
		return 6 * x * x;
	}

	@Override
	public double volume() {
		return x * x * x;
	}

}
