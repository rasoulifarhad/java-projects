package com.farhad.example.async_method;

import java.util.concurrent.TimeUnit;

public class AsyncMethodUtils {
	
	private AsyncMethodUtils() {}

	static void delayMills(int mills) {

		try {
			TimeUnit.MILLISECONDS.sleep(mills);
		} catch (Exception e) {
            throw new RuntimeException(e);		
		}
	}
}
