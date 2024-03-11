package com.farhad.example.design_principles02.interface_demo;

public class App {

	public static void main(String[] args) {
		
		Shape s1 = new Cube();
		System.out.println("The area of cube is: " + s1.area());
		System.out.println("The volume of cube is: " + s1.volume());
		s1 = new Circle();
		System.out.println("The area of circle is: " + s1.area());
		System.out.println("The volume of circle is: " + s1.volume());
	}
}
