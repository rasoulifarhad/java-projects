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

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		List<Integer> doubledNumbers = numbers.stream()
											.filter(e -> e % 2 == 0)
											.map(e -> e * 2)
											.collect(toList());
		System.out.println(doubledNumbers);

		int factor = 3;
		List<Integer> tripledNumbers = numbers.stream()
											.filter(e -> e % 2 == 0)
											.map(e -> e * factor)
											.collect(toList());
		System.out.println(tripledNumbers);
		
		int factor2 = 4;
		List<Integer> quadrupledNumbers = numbers.stream()
											.filter(e -> e % 2 == 0)
											.map(e -> e * factor2)
											.collect(toList());
		System.out.println(quadrupledNumbers);
		
	}

	//  Instead of doubling the value of even numbers in a collection, what if we wanted to triple or quadruple them?
	//  We can do it by turning our original lambda expression into a closure.
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

	// the lambda expression in this code is a closure.
	public static void lambdaPrint() {

		String location = "World";

		Runnable runnable = () -> System.out.println("Hello " + location);

		runnable.run();
	}

	static class Sample1 {

		public static void call(Runnable runnable) {
			System.out.println("calling runnable");

			// level 2 of stack
			runnable.run();
		}

		public static void main(String[] args) {
			int value = 4; // level 1 of stack

			call(
				() -> System.out.println(value)  // level 3 of stack
			);
		}
	}

	// The closure holds on to a copy of value in this case.
	static class Sample2 {

		public static Runnable create() {
			int value = 4;
			Runnable runnable = () -> System.out.println(value);

			System.out.println("exiting create");
			return runnable;
		}

		public static void main(String[] args) {
			Runnable runnable = create();

			System.out.println("In main");
			runnable.run();
		}
	}

}
