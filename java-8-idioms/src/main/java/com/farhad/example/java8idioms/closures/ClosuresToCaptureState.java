package com.farhad.example.java8idioms.closures;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

// See https://developer.ibm.com/articles/j-java8idioms10/
public class ClosuresToCaptureState {
	
	public static void main(String[] args) {
		
		System.out.println(doubleEvenElements(Arrays.asList(1, 2, 3, 4)));

		print();
		lambdaPrint();
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
	// A lexical scope is the defining scope of a function. In turn, it may also be the defining scope of 
	// the defining scope, and so on.
	//
	// In the previous code, the method run does not define location or receive it as a parameter. The defining 
	// scope of run is the anonymous inner object of Runnable. Because location is not defined as a field in that 
	// instance, the search continues to the defining scope of the anonymous inner object—in this case the local 
	// scope of the method print.

    // If location were not present in the scope, the compiler's search would continue in the defining scope of 
	// print, continuing until either the variable was found or the search failed.
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

	public static void lambdaPrint() {

		String location = "World";

		Runnable runnable = () -> System.out.println("Hello " + location);

		runnable.run();
	}


}
