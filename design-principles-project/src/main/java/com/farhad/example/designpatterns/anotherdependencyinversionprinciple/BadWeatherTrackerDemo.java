package com.farhad.example.designpatterns.anotherdependencyinversionprinciple;

// See https://github.com/mikeknep/SOLID/tree/main
public class BadWeatherTrackerDemo {
	
	public static class WeatherTracker {

		String currentConditions;
		Phone phone;
		Emailer emailer;

		public WeatherTracker(){
			phone = new Phone();
			emailer = new Emailer();
		}

		public void setCurrentConditions(String weatherDescription) {
			this.currentConditions = weatherDescription;
			if ( "rainy".equals(weatherDescription) ) {
				String alert = phone.generateWeatherAlert(weatherDescription);
				System.out.println(alert);
			}
			if ( "sunny".equals(weatherDescription) ) {
				String alert = emailer.generateWeatherAlert(weatherDescription);
				System.out.println(alert);
			}
		}
	}

	static class Phone {
		public String generateWeatherAlert(String weatherDescription) {
			String alert = "It is " + weatherDescription;
			return alert;
		}
	}

	static class Emailer {
		public String generateWeatherAlert(String weatherDescription) {
			String alert = "It is " + weatherDescription;
			return alert;
		}
	} 
}
