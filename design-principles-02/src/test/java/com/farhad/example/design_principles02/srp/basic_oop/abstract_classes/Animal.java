package com.farhad.example.design_principles02.srp.basic_oop.abstract_classes;

public abstract class Animal {
	abstract void move();
	abstract void eat();

	void label() {
		System.out.println("Animal's data:");
	}
}
