package com.farhad.example.builder.laptop;

// The BuilderClient associate one of the builder objects with the director via the director’s constructor parameters.
public class BuilderClient {
	
	public static void main(String[] args) {
		LaptopBuilder builder = new LaptopBuilder();
		Director director = new Director(builder);
		director.makeGamingLaptop();
		Laptop laptop = builder.build();
		laptop.info();
	}
}
