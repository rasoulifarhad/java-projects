package com.farhad.example.java8idioms.cascadinglambdas;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CascadingLambdasDemo {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3);

		System.out.println(totalSelectedValues(numbers, e -> e % 2 == 0));
		System.out.println(totalSelectedValues(numbers, CascadingLambdasDemo::isEven));

		Predicate<Integer> isOdd = createIsOdd();
		System.out.println(isOdd.test(3));

		List<Integer> numbers1 = Arrays.asList(10, 30, 50, 70);
		System.out.println(extractValuesGreaterThan50(numbers1));
		List<Integer> numbers2 = Arrays.asList(50, 70, 90, 110);
		System.out.println(extractValuesGreaterThan50AndDouble(numbers2));

		Predicate<Integer> isGreaterThan50 = number -> number > 50;

		System.out.println(
			numbers1.stream()
				.filter(isGreaterThan50)
				.collect(toList())
		);

		System.out.println(
			numbers2.stream()
				.filter(isGreaterThan50)
				.map(e -> e * 2)
				.collect(toList())
		);

		List<Integer> valuesOver25 = numbers1.stream()
			.filter(e -> e > 25 )
			.collect(toList());
		System.out.println(valuesOver25);

		List<Integer> valuesOver50 = numbers1.stream()
			.filter(e -> e > 50 )
			.collect(toList());
		System.out.println(valuesOver50);
		
		List<Integer> valuesOver75 = numbers1.stream()
			.filter(e -> e > 75 )
			.collect(toList());
		System.out.println(valuesOver75	);

		// While the two lambdas in the previous example were identical, there are slight variations in the 
		// three above. Creating a Function that returns a Predicate solves the problem at hand.
		// 
		// The reference isGreaterThan refers to a lambda expression that represents a Function<T, U>—or more 
		// precisely, Function<Integer, Predicate<Integer>>. The input is an Integer and the output is a 
		// Predicate<Integer>.
		//
		// Within the body of the lambda expression (the outer {}) we created another reference, isGreaterThanPivot, 
		// that holds a reference to another lambda expression. This time the reference is to a Predicate instead of 
		// a Function. Finally, we return that reference.
		// 
		// isGreaterThan is a reference to a lambda expression that returns another lambda expression when 
		// invoked—in other words, there’s a cascade of lambdas hidden in there.
		Function<Integer, Predicate<Integer>> isGreaterThan = (Integer pivot) -> {
			Predicate<Integer> isGreaterThanPivot = (Integer candidate) -> {
				return candidate > pivot;
			};
			return isGreaterThanPivot;
		};

		valuesOver25 = numbers1.stream()
			.filter(isGreaterThan.apply(25))
			.collect(toList());
		System.out.println(valuesOver25);

		valuesOver50 = numbers1.stream()
			.filter(isGreaterThan.apply(50))
			.collect(toList());
		System.out.println(valuesOver50);

		valuesOver75 = numbers1.stream()
			.filter(isGreaterThan.apply(75))
			.collect(toList());
		System.out.println(valuesOver75);
	}
 
	public static int totalSelectedValues(List<Integer> values, Predicate<Integer> selector) {
		return values.stream()
				.filter(selector)
				.reduce(0, Integer::sum); 
	}

	public static boolean isEven(Integer number) {
		return number % 2 == 0;
	}

	public static Predicate<Integer> createIsOdd() {
		return  number -> number %  2 != 0;
	}

	public static List<Integer> extractValuesGreaterThan50(List<Integer> numbers) {
		return numbers.stream()
					.filter(e ->  e > 50)
					.collect(toList());
	}

	public static List<Integer> extractValuesGreaterThan50AndDouble(List<Integer> numbers) {
		return numbers.stream()
					.filter(e ->  e > 50)
					.map(e -> e * 2)
					.collect(toList());
	}

	

}
