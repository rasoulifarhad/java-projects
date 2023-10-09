package com.farhad.example.design_principles02.solid.spi_good;

public class App {
	
	public static void main(String[] args) {
		
		Car car  =new Car();
		Bike bike = new Bike();

		printIsMoving(car);
		printIsMoving(bike);

		car.sevMove(true);
		bike.sevMove(true);

		
		printIsMoving(car);
		printIsMoving(bike);
	}

	private static void printIsMoving(Car car) {
		System.out.println(car.engineOn());
	}

	private static void printIsMoving(Bike bike) {
		System.out.println(bike.pedalsMove());
	}

}
