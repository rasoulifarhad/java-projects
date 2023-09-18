package com.farhad.example.design_principles02.srp.basic_oop.interfaces;

public class Eagle implements Animal, Bird {

	@Override
	public void fly() {
		System.out.println("Flies up to 10,000 feet.");
	}

	@Override
	public void eat() {
		System.out.println("Eats reptiles and amphibians.");
	}

	@Override
	public void sound() {
		System.out.println("Has a high-pitched whistling sound.");
	}

	public static void main(String[] args) {
		Eagle eagle = new Eagle();

		eagle.eat();
		eagle.sound();
		eagle.fly();

		System.out.println("Number of lrgs: " + Bird.numberOfLegs);
		System.out.println("OuterCovering: " + Bird.outerCovering);
	}
	
}
