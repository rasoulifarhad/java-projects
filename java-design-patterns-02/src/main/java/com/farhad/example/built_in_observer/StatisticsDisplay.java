package com.farhad.example.built_in_observer;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class StatisticsDisplay implements Observer, DisplayElement {

	Observable observable;
	private List<Float> temperatures;

	
	public StatisticsDisplay(Observable observable) {
		this.observable = observable;
		this.temperatures = new ArrayList<>();
		this.observable.addObserver(this);
	}

	@Override
	public void display() {
		DoubleSummaryStatistics statistics = temperatures.stream()
												.mapToDouble(Float::doubleValue)
												.summaryStatistics();
			
		System.out.println(String.format("Avg/Max/Min temperature = %.2f/%.2f/%.2f ", statistics.getAverage(), statistics.getMax(), statistics.getMin()));
	}

	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) observable;
			this.temperatures.add(weatherData.getTemperature());
			display();
		}
	}
	
}

