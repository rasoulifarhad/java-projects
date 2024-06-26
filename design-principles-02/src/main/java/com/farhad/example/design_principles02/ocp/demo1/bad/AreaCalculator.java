package com.farhad.example.design_principles02.ocp.demo1.bad;

public class AreaCalculator {
	
	public float getRectangleArea(Rectangle rectangle) {
		System.out.println("Rectangle:");
		return rectangle.getH() * rectangle.getW();
	}

	public float getCircleArea(Circle circle) {
		System.out.println("Circle:");
		return new Float(circle.getRadius() * circle.getRadius() + Math.PI);
	}

	public static void main(String[] args) {
		
		AreaCalculator areaCalculator = new AreaCalculator();

		System.out.println(
			areaCalculator.getRectangleArea(new Rectangle(2.0f, 3.0f)));

		System.out.println(
			areaCalculator.getCircleArea(new Circle(2.0f)));
	}
}
