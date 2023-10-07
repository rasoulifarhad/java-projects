package com.farhad.example.fluent_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Order {
	private List<String> cart = new ArrayList<>();
	private String address;

	public Order add(String order) {
		cart.add(order);
		System.out.println(order);
		return this;
	}

	public Order deliverAt(String location) {
		System.out.println("at " + location);
		return this;
	}

	public void place() {
		System.out.println("Order placed!");
	}

	public static void place(Consumer<Order> cons) {
		Order order = new Order();
		cons.accept(order);
		System.out.println("Order placed!");
	}


}
