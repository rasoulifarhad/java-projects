package com.farhad.example.java8idioms.functionalinterfaces;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class CustomFunctionalInterfaceDemo {
	
	@FunctionalInterface
	interface Transformer<T> {
		T transform(T input);
	}

	@Data
	@RequiredArgsConstructor
	@ToString
	static class OrderItem {
		private final int id;
		private final int price;
	}

	@AllArgsConstructor
	static class Order {
		List<OrderItem> items;

		public void transformAndPrint(Transformer<Stream<OrderItem>> transformOrderItems) {
			transformOrderItems.transform(items.stream())
				.forEach(System.out::println);
		}
	}

	public static void main(String[] args) {
		
		Order order = new Order(
			Arrays.asList(
				new OrderItem(1, 1234),
				new OrderItem(2, 2345),
				new OrderItem(3, 3456)));
		order.transformAndPrint(new Transformer<Stream<OrderItem>>() {

			@Override
			public Stream<OrderItem> transform(Stream<OrderItem> orderItems) {
				return orderItems.sorted(comparing(OrderItem::getPrice));
			}
			
		});

		order.transformAndPrint(orderItems -> orderItems.sorted(comparing(OrderItem::getPrice)));
	}
}
