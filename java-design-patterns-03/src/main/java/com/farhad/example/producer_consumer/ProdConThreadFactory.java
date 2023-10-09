package com.farhad.example.producer_consumer;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ProdConThreadFactory implements ThreadFactory {

	private final AtomicInteger counter ;
	private final String name;

	
	public ProdConThreadFactory(String name) {
		this.counter = new AtomicInteger();
		this.name = name;
	}


	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		t.setName(
			String.format("pool-%s-%d", name, counter.getAndDecrement()));
		return t;
	}
	
}
