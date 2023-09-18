package com.farhad.example.design_principles02.srp.basic_oop.static_polymorphism;

public class Bird {
	public void fly() {
		System.out.println("The bird is flying");
	}

	public void fly(int height) {
		System.out.println("The bird is flying " + height + " feet high.");
	}
	public void fly(String name, int height) {
		System.out.println("The " + name + " is flying " + height + " feet high.");
	}

	public static void main(String[] args) {
		Bird bird = new Bird();

		bird.fly();
		bird.fly(10_000);
		bird.fly("eagle", 10_000);
	}
}
