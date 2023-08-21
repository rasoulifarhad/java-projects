package com.farhad.example.java8idioms.passingthrough;

import static java.util.stream.Collectors.toCollection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

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

	static class PassingParameterWithMethodReferenceOnThis {

		public static void main(String[] args) {
			int [] numbers = new int[] {1, 2, 3, 4, 5};	
			PassingParameterWithMethodReferenceOnThis p = new PassingParameterWithMethodReferenceOnThis();
			p.incrementArray(numbers);
		}

		private int increment(int numbers) {
			return numbers + 1;
		}
		
		private void incrementArray(int [] numbers) {
			Stream.of(numbers)
				.flatMapToInt(Arrays::stream)
				.map(this::increment)
				.forEach(System.out::println);
		}
	}

	static class PassingParameterWithMethodReferenceOnStatic {

		public static void main(String[] args) {
			int [] numbers = new int[] {1, 2, 3, 4, 5};	
			incrementArray(numbers);

			System.out.println();
			String [] strNumbers = new String[] {"1", "2", "3", "4", "5"};	
			Arrays.stream(strNumbers)
				.map(Integer::valueOf)
				.forEach(System.out::println);

		}

		private static int increment(int numbers) {
			return numbers + 1;
		}
		
		private static void incrementArray(int [] numbers) {
			Stream.of(numbers)
				.flatMapToInt(Arrays::stream)
				.map(PassingParameterWithMethodReferenceOnStatic::increment)
				.forEach(System.out::println);
		}
	}
	
	static class PassingParameterToTarget  {

		public static void main(String[] args) {
			passingParameterToTarget();
		}
		// Using the parameter as a target
		// map(e ‑> e.doubleValue())
		private static void passingParameterToTarget() {

			int [] numbers = new int[] {1, 2, 3};

			Arrays.stream(numbers)
				.boxed()
				.map(Integer::doubleValue)
				.forEach(System.out::println);
		}
	}

	static class PassingConstructorCalls {

		public static void main(String[] args) {
			
			int [] numbers = new int[] {1, 2, 3, 4};

			System.out.println();
			Arrays.stream(numbers)
				.boxed()
				.mapToDouble(Integer::doubleValue)
				.boxed()
				.collect(toCollection(() -> new LinkedList<Double>()))
				.forEach(System.out::println);;

			System.out.println();
			Arrays.stream(numbers)
				.boxed()
				.mapToDouble(Integer::doubleValue)
				.boxed()
				.collect(toCollection(LinkedList::new))
				.forEach(System.out::println);
		}
	}

	static class PassingMultipleArguments {

		public static void main(String[] args) {
			
			int [] numbers = new int[] {1, 2, 3, 4};
			int sum = Arrays.stream(numbers)
						.reduce(0, (total, e) -> Integer.sum(total, e));
			System.out.println();
			System.out.println("Sum = " + sum);

			sum = Arrays.stream(numbers)
						.reduce(0, Integer::sum);
			System.out.println();
			System.out.println("Sum = " + sum);

		}
	}

}
