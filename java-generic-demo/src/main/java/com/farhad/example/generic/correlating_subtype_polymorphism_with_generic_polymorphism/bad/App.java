package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.bad;

public class App {

	public static void main(String[] args) {
		

		PositiveInteger n1 = new PositiveInteger(1);
		PositiveInteger n2 = new PositiveInteger(2);
		System.out.println(n1.compareTo(n2));


		Real r1 = new Real(2);
		System.out.println(n1.compareTo(r1));
	}
}
