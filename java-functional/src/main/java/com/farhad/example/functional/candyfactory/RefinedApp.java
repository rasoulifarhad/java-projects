package com.farhad.example.functional.candyfactory;

import java.util.Collection;

import com.farhad.example.functional.candyfactory.Candy.Color;
import com.farhad.example.functional.candyfactory.Candy.Type;

public class RefinedApp {
	public static void main(String[] args) {
		
		Collection<Candy> bagOfCandy = CandyFactory.bagOfCandy();

		RefinedCandyService candyService = new RefinedCandyService();
		
		Collection<Candy> redCandies =  candyService.filter(bagOfCandy, candy -> candy.getColor().equals(Color.RED));
		int numberOfReds = redCandies.size();
		System.out.println(numberOfReds);

		bagOfCandy = CandyFactory.grabBag();
		Collection<Candy>  pretzelCandies = candyService.filter(bagOfCandy, candy -> candy.getType().equals(Type.PRETZEL));
		int numberOfPretzel = pretzelCandies.size();
		System.out.println(numberOfPretzel);

		numberOfReds = (int)bagOfCandy.stream()
							.filter(candy -> candy.getColor().equals(Color.RED) )
							.count();

		System.out.println(numberOfReds);

		numberOfPretzel = (int) bagOfCandy.stream()
									.filter(candy -> candy.getType().equals(Type.PRETZEL))
									.count();
	}

}
