package com.farhad.example.async_method;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class TempSensorExecutor<T> implements SensorExecutor<T> {

	private static final AtomicInteger COUNTER = new AtomicInteger();
	private final List<Thread> threads = new ArrayList<>();
	@Override
	public void start() {
		threads.forEach(Thread::start);
		System.out.println("SensorTaskExecutor, started:" + threads.size());
	}

	@Override
	public SensorResult<T> measure(Callable<T> sensor, SensorCallback<T> callback) {
		SensorResult<T> result = new TempSensorResult<>(callback);

		Runnable runnable = () -> {
			try {
				result.setResult(sensor.call());		
			} catch (Exception e) {
				result.addException(e);
			}
		};
		Thread thread = new Thread(runnable, "thread-" + COUNTER.getAndIncrement());
		thread.setDaemon(true);
		threads.add(thread);
		return result;
	}

	@Override
	public T stopMeasurement(SensorResult<T> measurement) {
		if (!measurement.isPresent()) {
			measurement.await();
		}
		return measurement.getResult();
	}
	
}
