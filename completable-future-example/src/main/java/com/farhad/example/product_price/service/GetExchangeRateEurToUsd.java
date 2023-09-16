package com.farhad.example.product_price.service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class GetExchangeRateEurToUsd implements Supplier<Double>{

	private final static Double DEF_RATE = Double.valueOf("0.1");

	@Override
	public Double get() {
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(1_000, 2_000));
		} catch (InterruptedException e) {
			System.out.println("Interuption ocurred.");
			e.printStackTrace();
		}
		return DEF_RATE;
	}
	
}
