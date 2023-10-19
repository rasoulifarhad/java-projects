package com.farhad.example.design_principles02.test_design.domain.model;

public class BronzeAccount extends AccountBase {

	private static final int BRONZE_TRANSACTION_COST_PER_POINT = 20;

	public int calculateRewardPoints(double amount) {
		int points = (int)Math.floor(amount / BRONZE_TRANSACTION_COST_PER_POINT);
		return Math.max(points, 0);
	}
	
}
