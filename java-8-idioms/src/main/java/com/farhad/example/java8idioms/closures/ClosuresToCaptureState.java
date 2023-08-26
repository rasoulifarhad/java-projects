package com.farhad.example.java8idioms.closures;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

// See https://developer.ibm.com/articles/j-java8idioms10/
public class ClosuresToCaptureState {
	
	public static void main(String[] args) {
		
		System.out.println(doubleEvenElements(Arrays.asList(1, 2, 3, 4)));

		print();
	}

	private static List<Integer> doubleEvenElements(List<Integer> numbers) {
		return numbers.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.collect(toList());
	} 

	// Lexical scoping:
	// 
	// Functions expect variables to be in scope. Because they are anonymous functions at heart, lambdas 
	// expect variables referenced to be in scope, as well. Some variables are received as parameters to 
	// functions or lambdas. Some variables are defined locally. And some variables come from outside the 
	// function, in what's called the lexical scope.
	//
	public static void print() {
		String location = "World";

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello " + location);
			}
			
		};

		runnable.run();
	}


}
