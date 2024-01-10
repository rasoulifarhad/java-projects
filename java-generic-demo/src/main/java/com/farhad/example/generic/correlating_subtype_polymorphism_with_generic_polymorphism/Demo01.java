package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism;

import java.util.ArrayList;
import java.util.HashSet;

public class Demo01 {

	static public class IntegerList extends ArrayList<Integer> {

	}
	

	static class StringSet extends HashSet<String> {

	}
	
	static class AnyObject {

	}
	
	static class AnyContainer<E extends AnyObject> {

	}
	
	static class PhysicalObject extends AnyObject {

	}
	
	static class PhysicalContainer<E extends PhysicalObject> extends AnyContainer<E> {

	}
	
	static class Fruit extends PhysicalObject {

	}
	
	static class FruitContainer<E extends Fruit> extends PhysicalContainer<E> {
	
		
	}
}
