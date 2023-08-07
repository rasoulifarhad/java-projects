package com.farhad.example.designpatterns.intro.weatherdatademo;

public class WeatherDataDemo {
	
	interface Display {
		void update(float temperature, float humidity, float pressure);
	}

	static class CurrentConditionsDisplay implements Display {

		@Override
		public void update(float temperature, float humidity, float pressure) {
		}

	}

	static class StatisticsDisplay	implements Display {

		@Override
		public void update(float temperature, float humidity, float pressure) {
		}
		
	}

	static class ForecastDisplay implements Display {

		@Override
		public void update(float temperature, float humidity, float pressure) {
		}
		
	}
	public static class WeatherData {

		private CurrentConditionsDisplay currentConditionsDisplay;
		private StatisticsDisplay statisticsDisplay;
		private ForecastDisplay forecastDisplay;

		
		public WeatherData(CurrentConditionsDisplay currentConditionsDisplay, StatisticsDisplay statisticsDisplay,
				ForecastDisplay forecastDisplay) {
			this.currentConditionsDisplay = currentConditionsDisplay;
			this.statisticsDisplay = statisticsDisplay;
			this.forecastDisplay = forecastDisplay;
		}

		public void measurementsChanged() {

			// Grab the most recent measuremets by calling the WeatherData’s getter methods.
			float temp = getTemperature();
			float humidity = getHumidity();
			float pressure = getPressure();

			// Now update displays...
			// Call each display element to update its display, passing it the most recent measurements.
			currentConditionsDisplay.update(temp, humidity, pressure);
			statisticsDisplay.update(temp, humidity, pressure);
			forecastDisplay.update(temp, humidity, pressure);
		}

		private float getPressure() {
			return 0;
		}

		private float getHumidity() {
			return 0;
		}

		private float getTemperature() {
			return 0;
		}

	}
}
