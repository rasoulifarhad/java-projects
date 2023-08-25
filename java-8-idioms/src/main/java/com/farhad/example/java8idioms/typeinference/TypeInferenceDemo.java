package com.farhad.example.java8idioms.typeinference;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import lombok.Data;
import lombok.RequiredArgsConstructor;

// See https://developer.ibm.com/articles/j-java8idioms8/
public class TypeInferenceDemo {
	
	public static void main(String[] args) {
		
		IntStream.rangeClosed(1, 5)
			.forEach( (int number) -> System.out.println(number * 2));

		IntStream.rangeClosed(1, 5)
			.forEach(number -> System.out.println(number * 2));

		// IntStream.rangeClosed(1, 5)
		// 	.forEach(number -> System.out.println(number.length() * 2) );
		List<Car> cars = new ArrayList<>();
		
		List<String> list = cars.stream()
							.map((Car car) -> car.getRegistration())
							.map((String registration) -> DMVRecords.getOwner(registration))
							.map((Person owner) -> owner.getName())
							.map((String name) -> name.toUpperCase())
							.collect(toList());
			
		list = cars.stream()
				.map(car -> car.getRegistration())
				.map(registration -> DMVRecords.getOwner(registration))
				.map(owner -> owner.getName())
				.map(name -> name.toUpperCase())
				.collect(toList());

	}

	static class DMVRecords {

		private static Map<String, Person> owners = new HashMap<>();
		public static Person getOwner(String registration) {
			return owners.get(registration);
		}

	}

	@RequiredArgsConstructor
	@Data
	static class Car {
		private final String registration;
	}

	@RequiredArgsConstructor
	@Data
	static class Person {
		private final String name;
	}

	public static Comparator<Car> crateComparator() {
		// return comparing((Car car) -> car.getRegistration()	);
		return comparing(car -> car.getRegistration()	); 
	}

	public static Comparator<Car> crateReverseComparator() {
		return comparing((Car car) -> car.getRegistration()).reversed();
		// return comparing(car -> car.getRegistration()).reversed(); // compile error
	}

	public static Comparator<Car> crateReverseComparatorWithMethodReference() {
		return comparing(Car::getRegistration).reversed();
	}
}
