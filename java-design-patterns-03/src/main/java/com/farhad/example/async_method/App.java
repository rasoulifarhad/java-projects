package com.farhad.example.async_method;

import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Async method invocation Pattern, moving vehicle");
		SensorExecutor<Integer> sensorTaskExecutor = new TempSensorExecutor<>();
		SensorCallback<Integer> tempSensorCallback = new TempSensorCallback();

		int tasksNumber = 5;
		List<SensorResult<Integer>> measurements  =  new ArrayList<SensorResult<Integer>>();

		System.out.printf(
                    "AsyncMethodMain, tasksNumber:'%d' %n", tasksNumber);
		
		for (int i = 0; i < tasksNumber; i++) {
			SensorResult<Integer> sensorResult = sensorTaskExecutor.measure(new TempSensorTask(), tempSensorCallback);
			measurements.add(sensorResult);
		}
		sensorTaskExecutor.start();
		AsyncMethodUtils.delayMills(10);

		for (int i = 0; i < tasksNumber; i++) {
			Integer temperature = sensorTaskExecutor.stopMeasurement(measurements.get(i));
			System.out.printf(
				"AsyncMethodMain, sensor:'%d' temp:'%d'%n", i, temperature);		
		}

		Thread.currentThread().join();
	}
}
