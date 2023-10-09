package com.farhad.example.async_method;

import java.util.concurrent.Callable;

public interface SensorExecutor<T> {
	
	void start();
	SensorResult<T> measure(Callable<T> sensor, SensorCallback<T> callback);
	T stopMeasurement(SensorResult<T> measurement);
}
