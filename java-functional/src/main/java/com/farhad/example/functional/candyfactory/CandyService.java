package com.farhad.example.functional.candyfactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.farhad.example.functional.candyfactory.Candy.CandyMatcher;
import com.farhad.example.functional.candyfactory.Candy.Color;
import com.farhad.example.functional.candyfactory.Candy.ColorMatcher;
import com.farhad.example.functional.candyfactory.Candy.TypeMatcher;

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

	public Collection<Candy> filter(Collection<Candy> candies, CandyMatcher matcher) {
		List<Candy> res = new ArrayList<>();
		for (Candy candy : candies) {
			if ( matcher.matches(candy) ) {
				res.add(candy);
			}
		}
		return res;
	}

	public Collection<Candy> filterByColor01(Collection<Candy> assortedCandy, Color color) {
		ColorMatcher matcher = new ColorMatcher(color);
		return filter(assortedCandy, matcher);
	}

	public Collection<Candy> filterByType01(Collection<Candy> assortedCandy, Candy.Type type) {
		TypeMatcher matcher = new TypeMatcher(type);
		return filter(assortedCandy, matcher);
	}

	public Collection<Candy> filterByColor02(Collection<Candy> assortedCandy, Color color) {
		return filter(assortedCandy, 
					new CandyMatcher() {

						@Override
						public boolean matches(Candy candy) {
							return candy.getColor().equals(color);
						}
						
					});
	}

	public Collection<Candy> filterByType02(Collection<Candy> assortedCandy, Candy.Type type) {
		return filter(assortedCandy, 
						new CandyMatcher() {

							@Override
							public boolean matches(Candy candy) {
								return candy.getType().equals(type);
							}
							
						});
	}

	public Collection<Candy> filterByColor03(Collection<Candy> assortedCandy, Color color) {
		return filter(assortedCandy, candy -> candy.getColor().equals(color));
	}

	public Collection<Candy> filterByType03(Collection<Candy> assortedCandy, Candy.Type type) {
		return filter(assortedCandy, candy -> candy.getType().equals(type)); 
	}


}
