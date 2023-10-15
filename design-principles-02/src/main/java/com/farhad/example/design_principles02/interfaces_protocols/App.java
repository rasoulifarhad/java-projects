package com.farhad.example.design_principles02.interfaces_protocols;

import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String[] args) {
		
		List<Locatable> items = new ArrayList<>();

		items.add(new Car());
		items.add(new Phone());
	}

	public static void printLocation(Locatable item) {
		if(item.locationIsValid()) {
			print(item.getLocation().toString());
		}
	}

	private static void print(String string) {
	}
}
