package com.farhad.example.java8idioms.collectionpipeline;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Iterating {
	
	public static List<Car> createCars() {
		return Arrays.asList(
			new Car("Jeep", "Wrangler", 2011),
			new Car("Jeep", "Comanche", 1990),
			new Car("Dodge", "Avenger", 2010),
			new Car("Buick", "Cascada", 2016),
			new Car("Ford", "Focus", 2012),
			new Car("Chevrolet", "Geo Metro", 1992)

		);
	}

	private static List<String> getModelsAfter2000UsingFor(List<Car> cars) {
		List<Car> carSortedByYear = new ArrayList<>();

		for (Car car : cars) {
			if(car.getYear() > 2000) {
				carSortedByYear.add(car);
			}
		}

		Collections.sort(carSortedByYear, new Comparator<Car>() {

			@Override
			public int compare(Car car1, Car car2) {
				return new Integer( car1.getYear()).compareTo(new Integer(car2.getYear())) ;
			}
			
		});

		List<String> models = new ArrayList<>();
		for (Car car : carSortedByYear) {
			
			models.add(car.getModel());
		}

		return models;
	}

	private static List<String> getModelsAfter2000UsingPipeline(List<Car> cars) {
		return 
			cars.stream()
				.filter(car -> car.getYear() > 2000 )
				.sorted(Comparator.comparing(Car::getYear))
				.map(Car::getModel)
				.collect(toList());
	}

	public static void main(String[] args) {
		
		System.out.println(getModelsAfter2000UsingFor(createCars()));

		System.out.println(getModelsAfter2000UsingPipeline(createCars()));
	}
}
