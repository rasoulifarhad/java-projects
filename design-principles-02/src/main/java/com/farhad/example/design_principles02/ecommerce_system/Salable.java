package com.farhad.example.design_principles02.ecommerce_system;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Salable {

	private Product product;
	private int quantity;

}
