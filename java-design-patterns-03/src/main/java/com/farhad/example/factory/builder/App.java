package com.farhad.example.factory.builder;

public class App {

	public static void main(String[] args) {
		
		System.out.println(
				Burger.of(Size.SMALL)
					.withCheese()
					.withTomato()
					.build());		
	}
}
