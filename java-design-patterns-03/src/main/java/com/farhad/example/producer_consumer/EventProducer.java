package com.farhad.example.producer_consumer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class EventProducer implements Runnable {
	
  	private static final AtomicInteger COUNTER = new AtomicInteger();
    private static final Random RANDOM = new Random();
	
	private final EventsContainer eventsContainer;

	public EventProducer(EventsContainer eventsContainer) {
		this.eventsContainer = eventsContainer;
	}

	@Override
	public void run() {
		int delay = 20 + RANDOM.nextInt(30);
		Event event = new Event(COUNTER.getAndIncrement(), Thread.currentThread().getName());
		eventsContainer.putEvent(event);
		ProducerConsumerUtil.delayMills(delay);
	}	
}
