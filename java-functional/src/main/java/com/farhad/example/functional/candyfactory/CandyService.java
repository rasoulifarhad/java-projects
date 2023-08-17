package com.farhad.example.functional.candyfactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.farhad.example.functional.candyfactory.Candy.Color;

public class CandyService {
	
	public Collection<Candy> filterByColor(Collection<Candy> assortedCandy, Color color) {
		List<Candy> res = new ArrayList<>();
		for (Candy candy : assortedCandy) {
			if ( candy.getColor().equals(Color.RED) ) {
				res.add(candy);
			}
		}
		return res;
	}

	public Collection<Candy> filterByColorAndType(Collection<Candy> assortedCandy, Color color, Candy.Type type) {
		return
		    filterByType(
					filterByColor(assortedCandy, color),
					type
			);
	}

	public Collection<Candy> filterByType(Collection<Candy> assortedCandy, Candy.Type type) {
		List<Candy> res = new ArrayList<>();
		for (Candy candy : assortedCandy) {
			if ( candy.getType().equals(type) ) {
				res.add(candy);
			}
		}
		return res;
	}

}
