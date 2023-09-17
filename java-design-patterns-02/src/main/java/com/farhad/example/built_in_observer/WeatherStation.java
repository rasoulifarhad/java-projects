package com.farhad.example.built_in_observer;

public class WeatherStation {
	
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();

		CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

		weatherData.setMeasurement(80, 65, 30.4f);
		weatherData.setMeasurement(82, 70, 29.2f);
		weatherData.setMeasurement(78, 90, 29.2f);
	}
}
