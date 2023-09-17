package com.farhad.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompletableFutureCreateChaeckComplete {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		CompletableFuture<String> future = new CompletableFuture<>();

		executorService.submit(() -> {
			Thread.sleep(500);
			future.complete("completed an another thread");
			return null;
		});

		while (!future.isDone()) {
			Thread.sleep(1_000);
		}

		String result = future.get();
		log.info("Result: {}", result);
		// future.join();
		executorService.shutdown();
	}
}
