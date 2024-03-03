package com.farhad.example.design_principles02.another_order_class;

import java.util.Date;

import lombok.Data;

@Data
public class Order {

	private Date orderDate;
	private long orderNumber;
	private long orderTotal;
	
	public boolean getInfo() {
		return true;
	}

	public long calculateTotal() {
		return 0;
	}

	public static void main(String[] args) {
		Order order = new Order();
		System.out.println("Instantiated Order");
		System.out.println(order.getClass().getName());
		System.out.println(order.calculateTotal());
	}
}
