package com.farhad.example.java8idioms.passingthrough;

import java.util.Arrays;
import java.util.List;

public class PassThroughLambdas {
	
	public static void main(String[] args) {
		
		passThroughLambdaExpression();

		passingParameterWithMethodReference();
	}

	private static void passThroughLambdaExpression() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println();
		numbers.stream()
			.filter(e -> e % 2 == 0)
			.forEach(e -> System.out.println(e));
	}

	private static void passingParameterWithMethodReference() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println();
		numbers.stream()
			.filter(e ->  e % 2 == 0)
			.forEach(System.out::println);

	}
}
