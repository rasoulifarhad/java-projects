package com.farhad.example.discounter.adapters.discounter.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.farhad.example.discounter.adapters.rate.repository.testdouble.StubRateRepository;
import com.farhad.example.discounter.application.Amount;
import com.farhad.example.discounter.application.DiscounterApp;

public class StubRateRepositoryTests {
	
	@Test
	public void discount_of_0_should_be_0() {
		//given
		DiscounterApp discounterApp = new DiscounterApp(new StubRateRepository());
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("0"));
		Amount expectedDiscount = Amount.parse("0");
		//then
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_250_should_be_0() {
		//given
		DiscounterApp discounterApp = new DiscounterApp(new StubRateRepository());
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("250"));
		Amount expectedDiscount = Amount.parse("0");
		//then
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}
	
	@Test
	public void discount_of_499_99_should_be_0() {
		//given
		DiscounterApp discounterApp = new DiscounterApp(new StubRateRepository());
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("499.99"));
		Amount expectedDiscount = Amount.parse("0");
		//then
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_500_should_be_15() {
		//given
		DiscounterApp discounterApp = new DiscounterApp(new StubRateRepository());
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("500"));
		Amount expectedDiscount = Amount.parse("15");
		//then
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_2750_should_be_82_5() {
		//given
		DiscounterApp discounterApp = new DiscounterApp(new StubRateRepository());
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("2750"));
		Amount expectedDiscount = Amount.parse("82.5");
		//then
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_4999_99_should_be_150() {
		//given
		DiscounterApp discounterApp = new DiscounterApp(new StubRateRepository());
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("4999.99"));
		Amount expectedDiscount = Amount.parse("150");
		//then
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_5000_should_be_250() {
		//given
		DiscounterApp discounterApp = new DiscounterApp(new StubRateRepository());
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("5000"));
		Amount expectedDiscount = Amount.parse("250");
		//then
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}
}
