package com.farhad.example.built_in_observer;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {

	Observable observable;
	private float lastPressure;
	private float currentPressure = 29.92f;

	
	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		this.observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println(String.format("ForecastDisplay: currrent %.2f and last %.2f ", currentPressure, lastPressure));
	}

	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) observable;
			this.lastPressure = this.currentPressure;
			this.currentPressure = weatherData.getPressure();
			display();
		}
	}
	
}
