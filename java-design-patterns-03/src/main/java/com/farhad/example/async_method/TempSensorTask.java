package com.farhad.example.async_method;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class TempSensorTask implements Callable<Integer> {

	private static final  Random RANDOM = new Random();
	private static final AtomicInteger COUNTER = new AtomicInteger();

	@Override
	public Integer call() throws Exception {
		int temperature = RANDOM.nextInt(42);
		AsyncMethodUtils.delayMills(10);
		System.out.printf(
			"TempSensorTask,n:'%d' temp:'%d', thread:'%s'%n", 
					COUNTER.getAndIncrement(), 
					temperature, 
					Thread.currentThread().getName());
		return temperature;
	}
	
}
