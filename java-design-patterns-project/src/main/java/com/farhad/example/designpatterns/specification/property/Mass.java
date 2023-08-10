package com.farhad.example.designpatterns.specification.property;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Data
public class Mass {
	
	private final Double value;

	public boolean greaterThan(Mass mass) {
		
		return value.compareTo(mass.getValue()) > 0;
	}

}
