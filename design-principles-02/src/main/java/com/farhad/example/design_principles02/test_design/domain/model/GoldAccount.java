package com.farhad.example.design_principles02.test_design.domain.model;


public class GoldAccount  extends AccountBase {

	private static final int GOLD_TRANSACTION_COST_PER_POINT = 5;

	private static final int GOLD_BALANCE_COST_PER_POINT = 2000;

	public int calculateRewardPoints(double amount) {
		int points = (int)Math.floor((balance / GOLD_BALANCE_COST_PER_POINT) + (amount / GOLD_TRANSACTION_COST_PER_POINT));
		return Math.max(points, 0);
	}

}
