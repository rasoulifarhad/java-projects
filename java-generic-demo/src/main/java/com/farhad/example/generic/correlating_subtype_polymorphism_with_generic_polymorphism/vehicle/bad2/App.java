package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.vehicle.bad2;

public class App {

	public static void main(String[] args) {
		Car car = new Car();
		car.setName("name");
		car.setLength(2);

		Bus bus = new Bus();
		bus.setName("bus");
		bus.setLength(4);


		car.compareTo(bus); // no error
	}
}
