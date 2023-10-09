package com.farhad.example.design_principles02.solid.spi_bad;

public class App {
	
	public static void main(String[] args) {
		
		Car car  =new Car();
		Bike bike = new Bike();

		printIsMoving(car);
		printIsMoving(bike);

		car.engineOn();
		bike.pedalsMove();

		
		printIsMoving(car);
		printIsMoving(bike);
	}

	private static void printIsMoving(Vehicle vehicle) {
		if (vehicle instanceof Car ) {
			System.out.println(vehicle.engineOn());
		} 
		if (vehicle instanceof Bike) {
			System.out.println(vehicle.pedalsMove());
		}
	}
}
