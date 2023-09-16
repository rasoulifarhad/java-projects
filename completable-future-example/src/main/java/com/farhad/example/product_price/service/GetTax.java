package com.farhad.example.product_price.service;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

public class GetTax implements Function<Double, Double>{

	private final static Double DEF_TAX = Double.valueOf("0.1");

	@Override
	public Double apply(Double amount) {
		Objects.requireNonNull(amount, "amount must be not null");
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(1_000, 2_000)); 
		} catch (InterruptedException e) {
			System.out.println("Interuption ocurred.");
			e.printStackTrace();
		}
		return DEF_TAX;
	}
	
}
