package com.farhad.example.default_methods;

interface Movable {

	default void move() {
		System.out.println("Moving");
	}
}

class Cheetan implements Movable {

	@Override
	public void move() {
		System.out.println("Moving very fast!");
	}

}

class Elephant implements Movable {

}

public class AnimalDemo {

	public static void main(String[] args) {
		Movable cheetan = new Cheetan();
		cheetan.move();
		Movable elephant = new Elephant();
		elephant.move();
	}
}
