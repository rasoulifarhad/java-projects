package com.farhad.example.design_principles02.test_design.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class Account {

	private static final int GOLD_TRANSACTION_COST_PER_POINT = 5;

	private static final int GOLD_BALANCE_COST_PER_POINT = 2000;

	private static final int PLATINUM_TRANSACTION_COST_PER_POINT = 2;

	private static final int PLATINUM_BALANCE_COST_PER_POINT = 1000;

	private static final int SILVER_TRANSACTION_COST_PER_POINT = 10;

	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private double balance;

	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private int rewardPoints;

	@NonNull
	private final AccountType accountType;

	

	public Account() {
		this(AccountType.Default);
	}

	public void addTransaction(double amount) {
		rewardPoints += calculateRewardPoints(amount);
		balance += amount;
	}

	public int calculateRewardPoints(double amount) {
		int points = 0;
		switch (accountType) {
			case Silver:
				points = (int)Math.floor(amount / SILVER_TRANSACTION_COST_PER_POINT);
				break;
			case Gold:
				points = (int)Math.floor((balance / GOLD_BALANCE_COST_PER_POINT) + (amount / GOLD_TRANSACTION_COST_PER_POINT));
				break;
			case Platinum:
				points = (int)Math.ceil((balance / PLATINUM_BALANCE_COST_PER_POINT) + (amount / PLATINUM_TRANSACTION_COST_PER_POINT));
				break;
			default:
				points = 0;
				break;
		}
		return Math.max(points, 0);
	}
	
}
