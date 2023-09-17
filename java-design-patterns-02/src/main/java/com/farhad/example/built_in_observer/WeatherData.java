package com.farhad.example.built_in_observer;

import java.util.Observable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class WeatherData extends Observable {
	
	private float temperature;
	private float humidity;
	private float pressure;

	public void measurementChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurement(final float temperature, final float humidity, final float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChanged();
	}


}
