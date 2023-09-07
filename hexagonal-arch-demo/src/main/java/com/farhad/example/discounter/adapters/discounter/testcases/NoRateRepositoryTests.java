package com.farhad.example.discounter.adapters.discounter.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.farhad.example.discounter.application.Amount;
import com.farhad.example.discounter.application.DiscounterApp;

public class NoRateRepositoryTests {
	

	@Test
	public void discount_of_0_should_be_0() {
		// given
		DiscounterApp discounterApp = new DiscounterApp(null);
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("0.00"));
		Amount expectedDiscount = Amount.parse("0.00");
		//then
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_100_should_be_8() {
		//given
		DiscounterApp discounterApp = new DiscounterApp(null);
		//when
		Amount currentAmount = discounterApp.calculateDiscount(Amount.parse("100.00"));
		Amount expectedDiscount = Amount.parse("8.00");
		Assert.assertTrue(currentAmount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_50_should_be_4() {
		//given
		DiscounterApp discounterApp = new DiscounterApp(null);
		//when
		Amount currentAmount = discounterApp.calculateDiscount(Amount.parse("50.00"));
		Amount expectedDiscount = Amount.parse("4.00");
		Assert.assertTrue(currentAmount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_200_should_be_16() {
		//given
		DiscounterApp discounterApp = new DiscounterApp(null);
		//when
		Amount currentAmount = discounterApp.calculateDiscount(Amount.parse("200.00"));
		Amount expectedDiscount = Amount.parse("16.00");
		Assert.assertTrue(currentAmount.isEqualTo(expectedDiscount));
	}
}
