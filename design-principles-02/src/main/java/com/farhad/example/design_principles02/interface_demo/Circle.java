package com.farhad.example.design_principles02.interface_demo;

public class Circle implements Shape {

	int radious = 10;

	@Override
	public double area() {
		return Math.PI * radious * radious;
	}

	@Override
	public double volume() {
		return 0;
	}

}
