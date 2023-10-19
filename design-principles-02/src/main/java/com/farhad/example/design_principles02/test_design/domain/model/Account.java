package com.farhad.example.design_principles02.test_design.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

	@Getter
	@Setter(value = AccessLevel.PROTECTED)
	protected double balance;

	@Getter
	@Setter(value = AccessLevel.PROTECTED)
	protected int rewardPoints;

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
		return 0;
	}
	
}
