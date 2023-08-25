package com.farhad.example.java8idioms.cascadinglambdas;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
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
