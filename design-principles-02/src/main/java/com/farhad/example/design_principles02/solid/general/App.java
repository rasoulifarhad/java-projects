package com.farhad.example.design_principles02.solid.general;

import java.util.Arrays;
import java.util.List;

public class App {
	
	public static void main(String[] args) {
		
		List<Vehicle> vehicles = Arrays.asList(new Truck(), new Car());
		vehicles.forEach(v -> v.move());

		CarWash carWash  = new CarWash();
		carWash.wash(new Car());
		carWash.wash(new Truck());

	}
}
