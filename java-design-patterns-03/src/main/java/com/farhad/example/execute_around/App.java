package com.farhad.example.execute_around;

import java.io.IOException;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) throws IOException {
		
		double singleDouble = Doubles.read((Scanner sc) -> getFirst(sc) );
		System.out.println("Singler double: " + singleDouble);

		double sumAllDoubles = Doubles.read((Scanner sc) -> sumAll(sc) );
		System.out.println("Sum all doubles: " + sumAllDoubles);
	}

	private static double sumAll(Scanner sc) {
		double sum = 0.0d;
		while (sc.hasNextDouble()) {
			sum += sc.nextDouble();
		}
		return sum;
	}

	private static double getFirst(Scanner sc) {
		if(sc.hasNextDouble()) {
			return sc.nextDouble();
		}
		return Double.NaN;
	}
}
