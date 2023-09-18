package com.farhad.example.design_principles02.srp.basic_oop.dynamic_polymorphism;

public class DynamicPolymorphism {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.eat();

		Bird bird = new Bird();
		bird.eat();

		Animal animal2 = new Bird();
		animal2.eat();
	}
}
