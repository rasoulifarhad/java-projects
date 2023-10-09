package com.farhad.example.java_coding_problems.thread_interruption;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App2 {
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(
			() -> {
				TransferQueue<String> queue = new LinkedTransferQueue<>();
				while(!Thread.currentThread().isInterrupted()) {
					try {
						log.info("For 3 seconds the thread {} will try to poll an element from queue ...", Thread.currentThread().getName());
						queue.poll(3000, TimeUnit.MILLISECONDS);
					} catch (InterruptedException e) {
						log.info("For 3 seconds the thread {} was intrrupted!", Thread.currentThread().getName());
						// Thread.currentThread().interrupt();
					}
				}
				log.info("The execution was stopped!");
			});

			thread.start();
			Thread.sleep(1500);
			thread.interrupt();
	}

}
