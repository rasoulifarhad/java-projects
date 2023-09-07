package com.farhad.example.discounter.adapters.discounter.testcases;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.farhad.example.discounter.adapters.rate.repository.file.FileRateRepository;
import com.farhad.example.discounter.application.Amount;
import com.farhad.example.discounter.application.DiscounterApp;

public class FileRateRepositoryTests {
	
	private static final String TMP_RATE_FILE_NAME = 
			System.getProperty("user.home") + File.separator + 
			"tmpratefile.txt";

	private DiscounterApp discounterApp() {

		return  new DiscounterApp(
					new FileRateRepository(
							TMP_RATE_FILE_NAME,
							"0 0",
							"100 0.05",
							"1000 0.07",
							"10000 0.1"));
	}

	@Test
	public void discount_of_0_should_be_0() {
		// given
		DiscounterApp discounterApp = discounterApp();
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("0"));
		Amount expectedDiscount = Amount.parse("0");
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_50_should_be_0() {
		// given
		DiscounterApp discounterApp = discounterApp();
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("50"));
		Amount expectedDiscount = Amount.parse("0");
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}
	
	@Test
	public void discount_of_99_99_should_be_0() {
		// given
		DiscounterApp discounterApp = discounterApp();
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("99.99"));
		Amount expectedDiscount = Amount.parse("0");
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_100_should_be_5() {
		// given
		DiscounterApp discounterApp = discounterApp();
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("100"));
		Amount expectedDiscount = Amount.parse("5");
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_550_should_be_27_5() {
		// given
		DiscounterApp discounterApp = discounterApp();
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("550"));
		Amount expectedDiscount = Amount.parse("27.5");
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_999_99_should_be_50() {
		// given
		DiscounterApp discounterApp = discounterApp();
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("999.99"));
		Amount expectedDiscount = Amount.parse("50");
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_1000_should_be_70() {
		// given
		DiscounterApp discounterApp = discounterApp();
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("1000"));
		Amount expectedDiscount = Amount.parse("70");
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_5500_should_be_385() {
		// given
		DiscounterApp discounterApp = discounterApp();
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("5500"));
		Amount expectedDiscount = Amount.parse("385");
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_9999_99_should_be_700() {
		// given
		DiscounterApp discounterApp = discounterApp();
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("9999.99"));
		Amount expectedDiscount = Amount.parse("700");
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}

	@Test
	public void discount_of_10000_should_be_1000() {
		// given
		DiscounterApp discounterApp = discounterApp();
		//when
		Amount currentDiscount = discounterApp.calculateDiscount(Amount.parse("10000"));
		Amount expectedDiscount = Amount.parse("1000");
		Assert.assertTrue(currentDiscount.isEqualTo(expectedDiscount));
	}
}
