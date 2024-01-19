package com.farhad.example.functional_interface.function.generic;

public class App {

	public static void main(String[] args) {
		
		final Function<Integer, Integer> tripleFunction = new Function<Integer,Integer>() {

			@Override
			public Integer apply(Integer t) {
				return 3 * t;
			}
			
		};

		final int result = tripleFunction.apply(2);
		System.out.println(result);

		Function<String, String> uppercaseFunction = new Function<String,String>() {

			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
			
		};

		final String uppercaseResult = uppercaseFunction.apply("hello");
		System.out.println(uppercaseResult);
	}
}
