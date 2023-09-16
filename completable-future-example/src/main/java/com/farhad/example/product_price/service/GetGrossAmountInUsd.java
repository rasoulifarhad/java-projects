package com.farhad.example.product_price.service;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;

public class GetGrossAmountInUsd implements BiFunction<Double, Double, Double>{

	@Override
	public Double apply(Double netAmount, Double tax) {
		Objects.requireNonNull(netAmount, "netAmount must be not null");
		Objects.requireNonNull(tax, "tax must be not null");
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(100, 300));
		} catch (InterruptedException e) {
			System.out.println("Interuption ocurred.");
			e.printStackTrace();
		}

		return Double.valueOf(netAmount.doubleValue() * (1 + tax.doubleValue()));
	}
	
}
