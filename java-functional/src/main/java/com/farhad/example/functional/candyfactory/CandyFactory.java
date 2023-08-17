package com.farhad.example.functional.candyfactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.farhad.example.functional.candyfactory.Candy.Color;
import com.farhad.example.functional.candyfactory.Candy.Type;

// See https://dev.to/scottshipp/real-world-java-with-predicates-and-streams-2jlo

// Right now we only make one kind of candy: 
//
// a small piece of disc-shaped chocolate in a hard candy shell. 
// Even though that's our only product, we do make them in many colors. 
// Every bag of candy contains an assortment of red, blue, green, and yellow pieces. 
public class CandyFactory {

	public static Collection<Candy> bagOfCandy() {
		List<Candy> res = new ArrayList<>();

		return res;
	}

	public static Collection<Candy> grabBag() {
		List<Candy> res = new ArrayList<>();

		return res;
	}

	public static void main(String[] args) {
		
		Collection<Candy> bagOfCandy = CandyFactory.bagOfCandy();

		CandyService candyService = new CandyService();
		
		Collection<Candy> redCandies =  candyService.filterByColor(bagOfCandy, Color.RED);
		int numberOfReds = redCandies.size();

		bagOfCandy = CandyFactory.grabBag();
		Collection<Candy>  pretzelCandies = candyService.filterByType(bagOfCandy, Type.PRETZEL);
		int numberOfPretzel = pretzelCandies.size();
	}
}
