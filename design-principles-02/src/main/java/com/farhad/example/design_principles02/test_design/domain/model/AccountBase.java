package com.farhad.example.design_principles02.test_design.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class AccountBase {

	@Getter
	@Setter(value = AccessLevel.PROTECTED)
	protected double balance;

	@Getter
	@Setter(value = AccessLevel.PROTECTED)
	protected int rewardPoints;

	public void addTransaction(double amount) {
		rewardPoints += calculateRewardPoints(amount);
		balance += amount;
	}

	public abstract int calculateRewardPoints(double amount);

	public static SilverAccount silver() {
		return new SilverAccount();
	} 
	public static GoldAccount gold() {
		return new GoldAccount();
	} 
	public static PlatinumAccount palatinum() {
		return new PlatinumAccount();
	} 
}
