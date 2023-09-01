package com.farhad.example.java8idioms.functionalpipelinesandstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// See https://developer.ibm.com/articles/j-java8idioms11/
public class FunctionalPipelinesAndStreamDemo {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(2, 5, 8, 15, 12, 19, 50, 23);
		Integer result = null;
		for (int e : numbers) {
			if ( e > 10 && e % 2 == 0) {
				result = e * 2;
				break;
			}
		}
		if (result != null ) {
			System.out.println("The value is " + result);
		} else {
			System.out.println("No value found");
		}

		System.out.println(
			numbers.stream()
				.filter(e -> e> 10)
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2 )
				.findFirst()
				.map(e -> "The value is " + e)
				.orElse("No value found")
		);

		System.out.println(
			numbers.stream()
				.peek(e -> System.out.println("Proccessing " + e ) )
				.filter(e -> e> 10)
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2 )
				.findFirst()
				.map(e -> "The value is " + e)
				.orElse("No value found")
		);
	}

	static class Sample {
		public static int simulateTimeConsumingComputation(int number) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}

			return number * 2; 
		}

		public static void main(String[] args) {
			List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

			numbers.stream()
				.map(Sample::simulateTimeConsumingComputation)
				.forEachOrdered(System.out::println);

			System.out.println();
			numbers.stream()
				.parallel()
				.map(Sample::simulateTimeConsumingComputation)
				.forEachOrdered(System.out::println);
		}
	}

	static class ImpureFunction {
		public static void main(String[] args) {
			List<Integer> numbers = Arrays.asList(1, 2, 3);
			int[] factors  = new int[] {2};

			Stream<Integer> stream = numbers.stream()
										.map(e -> e * factors[0] );

			factors[0] = 0;
			stream.forEach(System.out::println);
		}
	}
}
