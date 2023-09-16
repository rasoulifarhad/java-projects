package com.farhad.example.product_price.service;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;

public class GetNetAmountInUsd implements BiFunction<Double, Double, Double> {

	@Override
	public Double apply(Double priceInEur, Double eurToUsdRate) {
		Objects.requireNonNull(priceInEur, "priceInEur must be not null");
		Objects.requireNonNull(eurToUsdRate, "eurToUsdRate must be not null");

		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(100, 300));
		} catch (InterruptedException e) {
			System.out.println("Interuption ocurred.");
			e.printStackTrace();
		}

		return Double.valueOf( priceInEur.doubleValue() * eurToUsdRate.doubleValue() );
	}

	
}
