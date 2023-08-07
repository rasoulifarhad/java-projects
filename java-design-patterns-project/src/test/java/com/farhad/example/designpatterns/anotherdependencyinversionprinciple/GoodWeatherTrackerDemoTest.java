package com.farhad.example.designpatterns.anotherdependencyinversionprinciple;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.anotherdependencyinversionprinciple.GoodWeatherTrackerDemo.Notifier;
import com.farhad.example.designpatterns.anotherdependencyinversionprinciple.GoodWeatherTrackerDemo.WeatherTracker;

public class GoodWeatherTrackerDemoTest {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();

	static class MockNotifier implements Notifier {

		@Override
		public void alertWeatherConditions(String weatherConditions) {
			System.out.println("Foo");
		}

	}

	@Test
	public void testNotifiesWhenWeatherChanges() {
		WeatherTracker weatherTracker = new WeatherTracker();
		System.setOut(new PrintStream(out));
		weatherTracker.setCurrentConditions("cloudy");
		MockNotifier mockNotifier = new MockNotifier();
		weatherTracker.notify(mockNotifier);

		assertEquals("Foo\n", out.toString());
	}

}
