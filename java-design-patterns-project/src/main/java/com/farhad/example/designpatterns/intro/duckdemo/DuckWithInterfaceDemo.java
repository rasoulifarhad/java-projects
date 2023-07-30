package com.farhad.example.designpatterns.intro.duckdemo;

import java.util.Arrays;
import java.util.List;

public class DuckWithInterfaceDemo {

	public static class Duck {

		public void swim() {
			System.out.println("Swimming duck.");
		}

		public void display() {
			System.out.println("Displaying: duck..");
		}

	}

	public static class MallardDuck extends Duck implements Flyable, Quackable {

		@Override
		public void display() {
			System.out.println("Displaying: malard duck..");
		}
		
		@Override
		public void fly() {
			System.out.println("Flying: mallar duck...");
		}

		@Override
		public void quack() {
			System.out.println("Quacking: mallar duck...");
		}
		
	}

	public static class RedheadDuck extends Duck implements Flyable, Quackable {

		@Override
		public void display() {
			System.out.println("Displaying: redhead duck..");
		}

		@Override
		public void fly() {
			System.out.println("Flying: redhead duck...");
		}

		@Override
		public void quack() {
			System.out.println("Quacking: redhead duck...");
		}
		
		
	}

	public static class RubberDuck extends Duck implements Quackable {

		@Override
		public void display() {
			System.out.println("Displaying: rubber duck..");
		}

		@Override
		public void quack() {
			System.out.println("Quacking: Rubber duck..");
		}

	}
	
	public static class DecoyDuck extends Duck {

		@Override
		public void display() {
			System.out.println("Displaying: Decoy duck..");
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
		List<Quackable> quackables = Arrays.asList(new MallardDuck(), new RedheadDuck(), new RubberDuck());
		List<Flyable> flyables = Arrays.asList(new MallardDuck(), new RedheadDuck());
		quack(quackables);
		swim(ducks);
		fly(flyables);
		display(ducks);
	}

	private static void fly(List<Flyable> ducks) {
		System.out.println();
		System.out.println("Flying.......");
		ducks.forEach(Flyable::fly);
	}

	private static void quack(List<Quackable> ducks) {
		System.out.println();
		System.out.println("Quacking.......");
		ducks.forEach(Quackable::quack);
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
