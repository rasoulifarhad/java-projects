package com.farhad.example.java8idioms.functionalstyle;

import java.util.Arrays;
import java.util.List;

public class WritingReadableCode {
	
	public static void main(String[] args) {
		
		imperativeCodeSample();
		
		functionalStyleCodeSample();
	}

	private static void imperativeCodeSample() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int result = 0;
		for (int e : numbers) {
			if ( e > 3 && e % 2 == 0 && e < 8 ) {
				result += e * 2;
			}
		}
		System.out.println();
		System.out.println("Result= " + result);
	}

	private static void  functionalStyleCodeSample() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		int result = numbers.stream()
						.filter(e -> e > 3 )
						.filter(e -> e % 2 == 0)
						.filter(e -> e < 8)
						.mapToInt(e -> e * 2)
						.sum();
		System.out.println();
		System.out.println("Result= " + result);
	}
}
