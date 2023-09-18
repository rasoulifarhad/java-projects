package com.farhad.example.functional.try_success_failure.example;

import static com.farhad.example.functional.try_success_failure.Try.apply;
import static java.lang.Math.abs;

import java.util.Arrays;

import com.farhad.example.functional.try_success_failure.TryBinaryOperator;

public class ParseAndSum {
	
	public static void main(String[] args) {

		final String [] ints = new String[] {"1", "2", "3", "4"};
		final String [] ints2 = new String[] {"1", "2", "fffff", "4"};

		System.out.println("Sum using the try-catch block");
		int sum1 = sumWithoutTry(ints);
        System.out.println("Result: " + sum1);

		System.out.println("Sum using the Try-Success-Failure API");
		int sum2 = sumWithtTry(ints);
		System.out.println("Result: " + sum2);

		System.out.println("Sum using the try-catch block- failed");
		int sum3 = sumWithoutTry(ints2);
        System.out.println("Result: " + sum3);

		System.out.println("Sum using the Try-Success-Failure API - failed");
		int sum4 = sumWithtTry(ints2);
		System.out.println("Result: " + sum4);

	}


	public static int sumWithoutTry(String [] intsString) {
		int sum = 0;
		for (String string : intsString) {
			try {
				int number = abs(Integer.parseInt(string));
				sum += number;
			} catch (NumberFormatException e) {
				return -1;
			}
		}
		return sum;
	}

	public static int sumWithtTry(String [] intsString) {
		return Arrays.stream(intsString)
						.map(s -> 
							apply(() -> 
								abs(Integer.parseInt(s))))
						.reduce(apply(() -> 0), TryBinaryOperator.of(Integer::sum))
						.getOrElse(-1);

	}
}
