package com.farhad.example.design_principles02.ocp.demo1.good;

public class AreaCalculator {
	
	public int calculateArea(Shape shape) {
		return shape.calculateArea();
	}

	public static void main(String[] args) {
		
		AreaCalculator areaCalculator = new AreaCalculator();

		System.out.println(
			areaCalculator.calculateArea(new Rectangle(2, 3)));

		System.out.println(
			areaCalculator.calculateArea(new Circle(2)));
	}
}
