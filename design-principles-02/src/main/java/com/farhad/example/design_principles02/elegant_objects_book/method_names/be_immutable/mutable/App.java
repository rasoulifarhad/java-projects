package com.farhad.example.design_principles02.elegant_objects_book.method_names.be_immutable.mutable;

import java.util.HashMap;
import java.util.Map;

public class App {

	public static void main(String[] args) {
		
		Cash five = new Cash(5);
		five.mul(10);
		System.out.println(five);

		Map<Cash, String> map = new HashMap<>();
		Cash four = new Cash(4);
		Cash eight = new Cash(8);
		map.put(four, "four");
		map.put(eight, "eight");
		four.mul(2);
		System.out.println(map);
		System.out.println(map.get(four));


	}
}
