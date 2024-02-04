package com.farhad.example.design_principles02.ecommerce_system;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Salable {

	private double cost;

	public double price() {
		return cost;
	}

}
