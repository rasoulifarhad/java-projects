package com.farhad.example.producer_consumer;

import java.util.concurrent.TimeUnit;

public class ProducerConsumerUtil {
	
	private ProducerConsumerUtil() {}

	static void delayMills(int mills) {

		try {
			TimeUnit.MILLISECONDS.sleep(mills);
		} catch (Exception e) {
            throw new RuntimeException(e);		
		}
	}

}
