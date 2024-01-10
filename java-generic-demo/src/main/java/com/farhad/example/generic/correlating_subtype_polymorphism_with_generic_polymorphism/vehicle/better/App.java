package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.vehicle.better;

public class App {

	public static void main(String[] args) {
		
		Car car = new Car();
		car.setName("car01");
		car.setLength(2);


		Bus bus = new Bus();
		car.setName("bus01");
		car.setLength(2);

		car.compareTo(car);
		bus.compareTo(bus);
		// car.compareTo(bus); // compile Erroe
	}
}
