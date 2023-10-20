package com.farhad.example.design_principles02.exception_design;

import lombok.Data;

@Data
public class Order {

	private Long id;

	public Order(Long id) {
		this.id = id;
	}
	
}
