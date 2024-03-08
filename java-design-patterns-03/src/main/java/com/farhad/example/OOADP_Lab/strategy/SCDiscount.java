package com.farhad.example.OOADP_Lab.strategy;

public class SCDiscount  implements Discount {

	@Override
	public float calcDiscount(float amount) {
		return 0.1f * amount;
	}

}
