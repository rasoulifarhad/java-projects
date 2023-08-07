package com.farhad.example.designpatterns.anotherdependencyinversionprinciple;

// See https://github.com/mikeknep/SOLID/tree/main
public class GoodWeatherTrackerDemo {

	interface Notifier {
		void alertWeatherConditions(String weatherConditions);
	}

	static class Phone implements Notifier {

		@Override
		public void alertWeatherConditions(String weatherConditions) {
			if ( "rainy".equals(weatherConditions) ) {
				System.out.println("It is rainy");
			}
		}

	}

	static class Emailer implements Notifier {

		@Override
		public void alertWeatherConditions(String weatherConditions) {
			if ( "sunny".equals(weatherConditions) ) {
				System.out.println("It is sunny");
			}
		}

	}

	public static class WeatherTracker {

		String currentConditions;

		public void setCurrentConditions(String weatherDescription) {
			this.currentConditions = weatherDescription;
		}

		public void notify(Notifier notifier) {
			notifier.alertWeatherConditions(currentConditions);
		}
	}
}

