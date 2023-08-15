package com.farhad.example.functional.identity;

import java.util.function.Function;

public class IdentityDemo {
	
	public static void main(String[] args) {
		
		Function<String, String> func = Function.identity();
		System.out.println(func.apply("Hello boys and girls"));

		Function<Integer, Integer> func2 = Function.identity();
		System.out.println(func2.apply(2));

		Function<String, String> func3 = t -> t;
		System.out.println(func3.apply("Hello boys and girls"));

		Function<Integer, Integer> func4 = t -> t;
		System.out.println(func4.apply(2));
	}
}
