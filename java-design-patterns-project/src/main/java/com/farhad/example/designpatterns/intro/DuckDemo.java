package com.farhad.example.designpatterns.intro;

public class DuckDemo {
	
	public static class Duck {
		public void quack() {
			System.out.println("Quacking duck");
		}

		public void swim() {
			System.out.println("Swimming duck.");
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
}
