package com.farhad.example.producer_consumer;

public class EventConsumer implements Runnable {

	private final int number;
	private final EventsContainer eventsContainer;

	public EventConsumer(int number, EventsContainer eventsContainer) {
		this.number = number;
		this.eventsContainer = eventsContainer;
	}


	@Override
	public void run() {
		Event event = eventsContainer.getEvent();
		System.out.printf(
			"EventConsumer,event:'%s', number:'%d', thread:'%s'%n", 
					event, 
					number, 
					Thread.currentThread().getName());
	}
	
}
