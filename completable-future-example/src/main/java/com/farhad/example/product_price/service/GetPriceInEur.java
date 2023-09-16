package com.farhad.example.product_price.service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class GetPriceInEur implements Supplier<Double>{

	private final static Double DEF_PRICE_IN_EUR = Double.valueOf("1000");

	@Override
	public Double get() {
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(1_000, 2_000));
		} catch (InterruptedException e) {
			System.out.println("Interuption ocurred.");
			e.printStackTrace();
		}
		return DEF_PRICE_IN_EUR;
	}

	
}
