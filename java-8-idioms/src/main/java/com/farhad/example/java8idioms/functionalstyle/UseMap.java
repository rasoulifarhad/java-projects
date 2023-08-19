package com.farhad.example.java8idioms.functionalstyle;

import java.util.HashMap;
import java.util.Map;

public class UseMap {
	
	public static void main(String[] args) {
		
		Map<String, Integer> pageVisits = new HashMap<>();

		String page = "https://example.com";

		incrementPageVisitImperative(pageVisits, page);
		incrementPageVisitImperative(pageVisits, page);

		System.out.println(pageVisits.get(page));

		incrementPageVisitDeclarative(pageVisits, page);
		incrementPageVisitDeclarative(pageVisits, page);

		System.out.println(pageVisits.get(page));

	}

	private static void incrementPageVisitImperative(Map<String, Integer> pageVisits, String page) {
		if (!pageVisits.containsKey(page)) {
			pageVisits.put(page, 0);
		}

		pageVisits.put(page, pageVisits.get(page) + 1);
	}

	private static void incrementPageVisitDeclarative(Map<String, Integer> pageVisits, String page) {
		pageVisits.merge(page, 1, (oldValue, value) -> oldValue + 1 ); 
	}


}
