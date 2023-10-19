package com.farhad.example.design_principles02.test_design.domain.model;


public class SilverAccount  extends Account {

	private static final int SILVER_TRANSACTION_COST_PER_POINT = 10;

	public SilverAccount() {
		super(AccountType.Silver);
	}

	public int calculateRewardPoints(double amount) {
		int points = (int)Math.floor(amount / SILVER_TRANSACTION_COST_PER_POINT);
		return Math.max(points, 0);
	}
}
