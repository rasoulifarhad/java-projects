package com.farhad.example.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class App {
	public static void main(String[] args) {
		System.out.println("Producer-Consumer pattern, decoupling receiver and emitters");

		int producersNumber = 12;
		int consumersNumber = 10;
		EventsContainer eventsContainer = new EventsContainer(3);

		ExecutorService producerExecutor = Executors.newFixedThreadPool(4, new ProdConThreadFactory("producer"));
		ExecutorService consumersExecutor = Executors.newFixedThreadPool(2, new ProdConThreadFactory("consumer"));

		IntStream.range(0, producersNumber)
			.boxed()
			.map(i -> new EventProducer(eventsContainer))
			.forEach(producerExecutor::submit);

		IntStream.range(0, consumersNumber)
			.boxed()
			.map(i -> new EventConsumer(i, eventsContainer))
			.forEach(consumersExecutor::submit);
		ProducerConsumerUtil.delayMills(200);
		producerExecutor.shutdown();
		consumersExecutor.shutdown();	
	}
}
