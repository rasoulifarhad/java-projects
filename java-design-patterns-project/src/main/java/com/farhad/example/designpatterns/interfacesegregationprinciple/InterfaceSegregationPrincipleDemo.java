package com.farhad.example.designpatterns.interfacesegregationprinciple;

import lombok.ToString;

// an application that builds different types of toys. Each toy will have a price and color. 
// Some toys, such as a toy car or toy train can additionally move, while some toys, such as a toy plane can both move and fly.
// consider that the Toy interface is modified to include a walk() method to accommodate toy robots. 
//
// The solution is- Segregate the Toy interface into multiple role interfaces each for a specific behavior.
public class InterfaceSegregationPrincipleDemo {
	
	static class Bad {

		interface BadToy {
			void setPrice(double price);
			void setColor(String color);
			void move();
			void fly();

		}

		@ToString
		static class BadToyHouse implements BadToy {

			double price;
			String color;

			@Override
			public void fly() {
				throw new UnsupportedOperationException("Fly not supported for BadToyHouse");
			}

			@Override
			public void move() {
				throw new UnsupportedOperationException("Move not supported for BadToyHouse");
			}

			@Override
			public void setColor(String color) {
				this.color = color;
			}

			@Override
			public void setPrice(double price) {
				this.price = price;
			}
			
		}

		@ToString
		static class BadToyPlane implements BadToy {

			double price;
			String color;

			@Override
			public void fly() {
				System.out.println("BadToyPlane: flying");
			}

			@Override
			public void move() {
				System.out.println("BadToyPlane: moving");
			}

			@Override
			public void setColor(String color) {
				this.color = color;
			}

			@Override
			public void setPrice(double price) {
				this.price = price;
			}
			
		}
	}

	static class Better {

		interface Toy {
			void price(double price);
			void color(String color);
		}

		interface Flyable {
			void fly();
		}

		interface Movable {
			void move();
		}

		@ToString
		static class ToyHouse implements Toy {

			double price;
			String color;

			@Override
			public void price(double price) {
				this.price = price;
			}

			@Override
			public void color(String color) {
				this.color = color;
			}

		}

		@ToString
		static class ToyCar implements Toy, Movable {

			double price ;
			String color;

			@Override
			public void color(String color) {
				this.color = color;
			}

			@Override
			public void price(double price) {
				this.price = price;
			}

			@Override
			public void move() {
				System.out.println("ToyCar: start moving car");					
			}

		}

		@ToString
		static class ToyPlane implements Toy, Flyable, Movable {

			double price ;
			String color;

			@Override
			public void color(String color) {
				this.color = color;
			}

			@Override
			public void price(double price) {
				this.price = price;
			}

			@Override
			public void fly() {
				System.out.println("ToyPlane: start flying plane");
			}

			@Override
			public void move() {
				System.out.println("ToyPlane: start moving plane");
			}

		}

		static class ToyBuilder {

			public static ToyHouse buildToyHouse() {
				ToyHouse toy = new ToyHouse();
				toy.price(15.0);
				toy.color("green");
				return toy;
			} 

			public static ToyCar buildToyCar() {
				ToyCar toy = new ToyCar();
				toy.price(25.0);
				toy.color("red");
				toy.move();
				return toy;
			}

			public static ToyPlane buildToyPlane() {
				ToyPlane toy = new ToyPlane();
				toy.price(125.0);
				toy.color("white");
				toy.move();
				toy.fly();
				return toy;
			}
		}
	}

}
