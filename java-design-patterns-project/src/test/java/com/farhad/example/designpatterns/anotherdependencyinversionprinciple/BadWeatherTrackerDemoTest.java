package com.farhad.example.designpatterns.anotherdependencyinversionprinciple;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.anotherdependencyinversionprinciple.BadWeatherTrackerDemo.WeatherTracker;

public class BadWeatherTrackerDemoTest {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();

	@Test
	public void testAlertsPhoneUsersWhenRaining() {
		WeatherTracker weatherTracker = new WeatherTracker();
		System.setOut(new PrintStream(out));
		weatherTracker.setCurrentConditions("rainy");

		assertEquals("It is rainy\n", out.toString());
	}

	@Test
	public void testAlertsEmailUsersWhenSunny() {
		WeatherTracker weatherTracker = new WeatherTracker();
		System.setOut(new PrintStream(out));
		weatherTracker.setCurrentConditions("sunny");

		assertEquals("It is sunny\n", out.toString());

	}
}
