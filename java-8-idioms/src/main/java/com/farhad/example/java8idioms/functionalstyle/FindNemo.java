package com.farhad.example.java8idioms.functionalstyle;

import java.util.Arrays;
import java.util.List;

public class FindNemo {
	
	public static void main(String[] args) {
		
		List<String> names = 
			Arrays.asList("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques"); 
		
		findNemoImperative(names);

		findNemoDeclarative(names);
	}

	private static void findNemoImperative(List<String> names) {

		boolean found = false;
		for (String name : names) {
			if (name.equals("Nemo")) {
				found = true;
				break;
			}
		}

		if ( found ) {
			System.out.println("Found Nemo.");
		} else {
			System.out.println("Sorry, Nemo not found.");
		}
	}

	private static void findNemoDeclarative(List<String> names) {
		if (names.contains("Nemo")) {
			System.out.println("Found Nemo.");
		} else {
			System.out.println("Sorry, Nemo not found.");
		}
	}
}
