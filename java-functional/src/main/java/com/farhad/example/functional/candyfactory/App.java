package com.farhad.example.functional.candyfactory;

import java.util.Collection;

import com.farhad.example.functional.candyfactory.Candy.Color;
import com.farhad.example.functional.candyfactory.Candy.Type;

public class App {

	public static void main(String[] args) {
		
		Collection<Candy> bagOfCandy = CandyFactory.bagOfCandy();

		CandyService candyService = new CandyService();
		
		Collection<Candy> redCandies =  candyService.filterByColor(bagOfCandy, Color.RED);
		int numberOfReds = redCandies.size();
		System.out.println(numberOfReds);

		bagOfCandy = CandyFactory.grabBag();
		Collection<Candy>  pretzelCandies = candyService.filterByType(bagOfCandy, Type.PRETZEL);
		int numberOfPretzel = pretzelCandies.size();
		System.out.println(numberOfPretzel);


		redCandies = candyService.filterByColor01(bagOfCandy, Color.RED);
		numberOfReds = redCandies.size();
		System.out.println(numberOfReds);


		redCandies = candyService.filterByColor02(bagOfCandy, Color.RED);
		numberOfReds = redCandies.size();
		System.out.println(numberOfReds);

		

	}
}
