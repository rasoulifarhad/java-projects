package com.farhad.example.design_principles02.srp.basic_oop.abstract_classes;

public class Bird extends Animal {

	@Override
	void move() {
		System.out.println("Moves by flying.");
	}

	@Override
	void eat() {
		System.out.println("Eats birdfood.");
	}
	
	public static void main(String[] args) {
		Animal bird = new Bird();
		bird.label();
		bird.move();
		bird.eat();
	}
}
