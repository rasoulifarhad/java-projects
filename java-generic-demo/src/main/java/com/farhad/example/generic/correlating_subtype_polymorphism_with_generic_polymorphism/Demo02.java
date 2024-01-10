package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism;

public class Demo02 {

	static class AnyObject<O extends AnyObject<O>> implements Comparable<O>{

		@Override
		public int compareTo(O o) {
			return 0;
		}
		
		public AnyContainer<O> container() {
			return null;
		}

	}
	
	static class AnyContainer<E extends AnyObject<E>> {

	}
	
	static class PhysicalObject<O extends PhysicalObject<O>> extends AnyObject<O> {

		@Override
		public PhysicalContainer<O> container() {
			return null;
		}
	}
	

	static class PhysicalContainer<E extends PhysicalObject<E>> extends AnyContainer<E> {

	}
	
	static class Fruit<O extends Fruit<O>> extends PhysicalObject<O> {
		@Override
		public FruitContainer<O> container() {
			return null;
		}
	}
	
	static class FruitContainer<E extends Fruit<E>> extends PhysicalContainer<E> {

	}

	static class Vegetable<O extends Vegetable<O>> extends PhysicalObject<O> {
		@Override
		public VegetableContainer<O> container() {
			return null;
		}
	}

	static class VegetableContainer<E extends Vegetable<E>> extends PhysicalContainer<E> {
		
	}
	
	// "Dangerous"

	static class Apple extends Fruit<Apple> {

	}

	// // "Safe"
	// final static class Apple extends Fruit<Apple> {

	// }

	static class GoldenDelicious extends Apple {

	}

	static class Gala extends Apple {

	}

	public static void main(String[] args) {
		
		Fruit<?> fruit;
		Vegetable<?> vegetable;
		
		// Compilation error!
		// fruit.compareTo(vegetable);

		Apple a1 = new Apple();
		Apple a2 = new Apple();

		a1.compareTo(a2);

		GoldenDelicious goldenDelicious = new GoldenDelicious();
		Gala gala = new Gala();

		goldenDelicious.compareTo(gala);

		FruitContainer<Apple> c = goldenDelicious.container();
		FruitContainer<Apple> c2 = gala.container();
	}
}
