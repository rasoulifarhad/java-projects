package com.farhad.example.java8idioms.cascadinglambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CascadingLambdasDemo {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3);

		System.out.println(totalSelectedValues(numbers, e -> e % 2 == 0));
		System.out.println(totalSelectedValues(numbers, CascadingLambdasDemo::isEven));
	}
 
	public static int totalSelectedValues(List<Integer> values, Predicate<Integer> selector) {
		return values.stream()
				.filter(selector)
				.reduce(0, Integer::sum); 
	}

	public static boolean isEven(Integer number) {
		return number % 2 == 0;
	}
}
