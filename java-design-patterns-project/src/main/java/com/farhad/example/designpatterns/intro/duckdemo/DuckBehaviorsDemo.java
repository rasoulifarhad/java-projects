package com.farhad.example.designpatterns.intro.duckdemo;

import java.util.Arrays;
import java.util.List;

/**
 * See [O`Reilly. Head First] - Head First Design Patterns - [Freeman] 
 * 
 * we want to assign behaviors to the instances of Duck. For example, we might 
 * want to instantiate a new MallardDuck instance and initialize it with a speciﬁc 
 * type of ﬂying behavior. and also changing the behavior of a duck dynamically.
 * 
 * Design Principle: 
 * 
 * Program to an interface, not an implementation.
 * 
 * We’ll use an interface to represent each behavior – for instance, FlyBehavior 
 * and QuackBehavior.
 * 
 * So this time it won’t be the Duck classes that will implement the 
 * ﬂying and quacking interfaces. Instead, we’ll make a set of classes 
 * whose entire reason for living is to represent a behavior (for example, 
 * “squeaking”), and it’s the behavior class, rather than the Duck class, 
 * that will implement the behavior interface.
 */
public class DuckBehaviorsDemo {
	

	public static class Duck {

		protected FlyBehavior flyBehavior;
		protected QuackBehavior quackBehavior;

		public void setFlyBehavior(FlyBehavior flyBehavior) {
			this.flyBehavior = flyBehavior;
		}

		public void setQuackBehavior(QuackBehavior quackBehavior) {
			this.quackBehavior = quackBehavior;
		}

		public void swim() {
			System.out.println("Swimming duck.");
		}

		public void display() {
			System.out.println("Displaying: duck..");
		}

		public void performFly() {
			flyBehavior.fly();
		}

		public void performQuack() {
			quackBehavior.quack();
		}

	}

	public static class MallardDuck extends Duck  {

		public MallardDuck() {
			quackBehavior = new Quack();
			flyBehavior = new FlyWithWings();
		}

		@Override
		public void display() {
			System.out.println("Displaying: real malard duck..");
		}
	
	}

	public static class RedheadDuck extends Duck {

		public RedheadDuck() {
			quackBehavior = new Quack();
			flyBehavior = new FlyWithWings();
		}
		@Override
		public void display() {
			System.out.println("Displaying: real redhead duck..");
		}
	}

	public static class RubberDuck extends Duck  {

		public RubberDuck() {
			quackBehavior = new Quack();
			flyBehavior = new FlyNoWay();
		}
		@Override
		public void display() {
			System.out.println("Displaying: rubber duck..");
		}

	}
	
	public static class DecoyDuck extends Duck {

		public DecoyDuck() {
			quackBehavior = new MuteQuack();
			flyBehavior = new FlyNoWay();
		}

		@Override
		public void display() {
			System.out.println("Displaying: Decoy duck..");
		}
	}

	public static class ModelDuck extends Duck {

		public ModelDuck() {
			flyBehavior = new FlyNoWay();
			quackBehavior = new Quack();
		}

		@Override
		public void display() {
			System.out.println("Displaying: Model duck..");
		}

	}
	interface FlyBehavior {
		void fly();
	}

	interface QuackBehavior {
		void quack();
	}


	public static class FlyWithWings implements FlyBehavior {

		@Override
		public void fly() {
			System.out.println("Flying with wings");
		}
		
	}

	public static class Quack implements QuackBehavior {

		@Override
		public void quack() {
			System.out.println("Quacking......!");
		}
	}

	public static class Squeak implements QuackBehavior {

		@Override
		public void quack() {
			System.out.println("Squeaking......!");
		}
	}

	public static class MuteQuack implements QuackBehavior {

		@Override
		public void quack() {
			System.out.println("do nothing - can not  quack!");
		}
	}

	public static class FlyNoWay implements FlyBehavior {

		@Override
		public void fly() {
			System.out.println("No Flying (Fly no way)");
		}
		
	}

	public static class FlyRocketPowered implements FlyBehavior {

		@Override
		public void fly() {
			System.out.println("Flying with a rocket");
		}
		
	}
	
	public static class DuckSimulator {

		private static void fly(List<Duck> ducks) {
			System.out.println();
			System.out.println("Flying.......");
			ducks.forEach(Duck::performFly);
		}

		private static void quack(List<Duck> ducks) {
			System.out.println();
			System.out.println("Quacking.......");
			ducks.forEach(Duck::performQuack);
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
		public static void main(String[] args) {
			List<Duck> ducks = Arrays.asList(new MallardDuck(), new RedheadDuck(), new RubberDuck(), new DecoyDuck());
		
			quack(ducks);
			swim(ducks);
			fly(ducks);
			display(ducks);

			Duck model = new ModelDuck();
			model.performFly();
			
			model.setFlyBehavior(new FlyRocketPowered());

			model.performFly();
		}
	}
		

}
