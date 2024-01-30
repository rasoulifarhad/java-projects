package com.farhad.example.design_principles02.grasp.creator;

import lombok.Value;

@Value
public class OrderItem {

	private Product product;
	private int quantity;
}
