package com.farhad.example.async_method;

public interface SensorCallback<T> {
	void onMeasurement(T value);
}
