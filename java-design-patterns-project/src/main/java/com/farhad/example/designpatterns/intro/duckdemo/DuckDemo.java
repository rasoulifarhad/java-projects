package com.farhad.example.designpatterns.intro.duckdemo;

import java.util.Arrays;
import java.util.List;

public class DuckDemo {
	
	public static class Duck {
		public void quack() {
			System.out.println("Quacking duck");
		}

		public void swim() {
			System.out.println("Swimming duck.");
		}

		public void fly() {
			System.out.println("Flying: duck..");
		}

		public void display() {
			System.out.println("Displaying: duck..");
		}

	}

	public static class MallardDuck extends Duck {

		@Override
		public void display() {
			System.out.println("Displaying: malard duck..");
		}
		
	}

	public static class RedheadDuck extends Duck {

		@Override
		public void display() {
			System.out.println("Displaying: redhead duck..");
		}
		
	}

	public static class RubberDuck extends Duck {

		@Override
		public void display() {
			System.out.println("Displaying: rubber duck..");
		}

		@Override
		public void quack() {
			System.out.println("Error: Rubber duck can not Quacking.");
		}

		@Override
		public void fly() {
			System.out.println("Error: Rubber duck can not flying.");
		}
		
		
	}
	
	public static class DecoyDuck extends Duck {

		@Override
		public void display() {
			System.out.println("Displaying: Decoy duck..");
		}

		@Override
		public void quack() {
			System.out.println("Error: decoy duck can not Quacking.");
		}

		@Override
		public void fly() {
			System.out.println("Error: decoy duck can not flying.");
		}
		
	}

	interface Flyable {
		void fly();
	}

	interface Quackable {
		void quack();
	}
	public static void main(String[] args) {
		List<Duck> ducks = Arrays.asList(new MallardDuck(), new RedheadDuck(), new RubberDuck(), new DecoyDuck());
		quack(ducks);
		swim(ducks);
		fly(ducks);
		display(ducks);
	}

	private static void fly(List<Duck> ducks) {
		System.out.println();
		System.out.println("Flying.......");
		ducks.forEach(Duck::fly);
	}

	private static void quack(List<Duck> ducks) {
		System.out.println();
		System.out.println("Quacking.......");
		ducks.forEach(Duck::quack);
	}

	private static void swim(List<Duck> ducks) {
		System.out.println();
		System.out.println("Swiming.......");
		ducks.forEach(Duck::swim);
	}

	private static void display(List<Duck> ducks) {
		System.out.println();
		System.out.println("Displaying.......");
		ducks.forEach(Duck::display);
	}

}
