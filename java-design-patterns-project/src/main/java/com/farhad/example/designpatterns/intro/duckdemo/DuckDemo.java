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
			System.out.println("Displaying: duck..");
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
		
	}
	

	public static void main(String[] args) {
		List<Duck> ducks = Arrays.asList(new MallardDuck(), new RedheadDuck(), new RubberDuck());
		quack(ducks);
		swim(ducks);
		display(ducks);
	}

	private static void quack(List<Duck> ducks) {
		ducks.forEach(Duck::quack);
	}

	private static void swim(List<Duck> ducks) {
		ducks.forEach(Duck::swim);
	}

	private static void display(List<Duck> ducks) {
		ducks.forEach(Duck::display);
	}

}
