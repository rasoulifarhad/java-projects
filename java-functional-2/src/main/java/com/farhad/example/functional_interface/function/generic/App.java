package com.farhad.example.functional_interface.function.generic;

public class App {

	public static void main(String[] args) {

		final Function<Integer, Integer> tripleFunction = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer t) {
				return 3 * t;
			}

		};

		final int result = tripleFunction.apply(2);
		System.out.println(result);

		Function<String, String> uppercaseFunction = new Function<String, String>() {

			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}

		};

		final String uppercaseResult = uppercaseFunction.apply("hello");
		System.out.println(uppercaseResult);

		// Function<Integer, Integer> tripleFunction2 = (Integer arg) -> 3 * arg;
		Function<Integer, Integer> tripleFunction2 = arg -> 3 * arg;
		System.out.println(tripleFunction2.apply(2));

		Function<String, String> toUppercase = str -> str.toUpperCase();
		System.out.println(toUppercase.apply("hello"));
		
		Function<String, String> methodRefToUppercase = App::toUppercase;
		System.out.println(methodRefToUppercase.apply("hello"));

	}
	
	static Function<Integer, Integer> composeIntFunctions(Function<Integer, Integer> f1,
			Function<Integer, Integer> f2) {
		return arg -> f1.apply(f2.apply(arg));
	}
	
	public static String toUppercase(String input) {
		return input.toUpperCase();
	}
}
