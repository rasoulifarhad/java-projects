package com.farhad.example.design_principles02.srp.basic_oop.abstract_classes;

public class Fish extends Animal {

	@Override
	void move() {
		System.out.println("Moves by swimming.");
	}

	@Override
	void eat() {
		System.out.println("Eats seafood.");
	}
	
	public static void main(String[] args) {
		Animal fish = new Fish();

		fish.label();
		fish.move();
		fish.eat();
	}
}
