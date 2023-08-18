package com.farhad.example.functional.candyfactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class RefinedCandyService {
	
	public Collection<Candy> filter(Collection<Candy> candies, Predicate<Candy> candySelector) {
		List<Candy> res = new ArrayList<>();
		for (Candy candy : candies) {
			if ( candySelector.test(candy) ) {
				res.add(candy);
			}
		}
		return res;
	}

}
