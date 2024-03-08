
package com.farhad.example.OOADP_Lab.strategy;

public class FTCDiscount implements Discount {

	@Override
	public float calcDiscount(float amount) {
		return 0.15f * amount;
	}

}
