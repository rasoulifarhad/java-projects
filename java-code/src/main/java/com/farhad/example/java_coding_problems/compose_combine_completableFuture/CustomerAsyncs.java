package com.farhad.example.java_coding_problems.compose_combine_completableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerAsyncs {
	

	private static CompletableFuture<String> fetchOrder(String customerId) {
		return CompletableFuture.supplyAsync(() -> {
			return "Order of " + customerId;
		});
	}

	private static CompletableFuture<Integer> computeTotal(String order) {
		return CompletableFuture.supplyAsync(() -> {
			return order.length() + new Random().nextInt(1000);
		});
	}

	private static CompletableFuture<String> packProducts(String order) {
		return CompletableFuture.supplyAsync(() -> {
			return "Order: " + order + " | Product 1, Product2, Product3, ....";
		});
	}

	public static void fetchOrderTotal(String customerId) throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> cfTotal = 
			fetchOrder(customerId).thenCompose(o -> computeTotal(o));

		int total = cfTotal.get();
		System.out.println("Total: " + total);
	}

	public static void deliverParcel(String order) throws InterruptedException, ExecutionException {
		CompletableFuture<String> cfParcel = computeTotal(order)
			.thenCombine(packProducts(order), (total, products) -> {
				return "Parcel-[" + products + " Invoice: $" + total + "]";
			});

		String parcel = cfParcel.get();
		System.out.println("Delivering: " + parcel);
	}
}
