package com.farhad.example.design_principles02.test_design.domain.model;


public class PlatinumAccount extends Account {

	private static final int PLATINUM_TRANSACTION_COST_PER_POINT = 2;

	private static final int PLATINUM_BALANCE_COST_PER_POINT = 1000;

	public PlatinumAccount() {
		super(AccountType.Platinum);
	}

	public int calculateRewardPoints(double amount) {
		int points =  (int)Math.ceil((balance / PLATINUM_BALANCE_COST_PER_POINT) + (amount / PLATINUM_TRANSACTION_COST_PER_POINT));
		return Math.max(points, 0);
	}
	
}
