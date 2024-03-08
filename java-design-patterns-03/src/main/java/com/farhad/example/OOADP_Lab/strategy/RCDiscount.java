package com.farhad.example.OOADP_Lab.strategy;

public class RCDiscount implements Discount {

	@Override
	public float calcDiscount(float amount) {
		return 0.12f * amount;
	}

}
