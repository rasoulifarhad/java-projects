package com.farhad.example;

import java.util.concurrent.CompletableFuture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MethodsToHandleExceptions {
	
	public static void main(String[] args) {
		CompletableFuture.supplyAsync(() -> 0)
				.thenApply(i -> { log.info("Stage 1: {}", i); return 1/i;})
				.thenApply(i -> {log.info("Stage 2: {}", i); return 1/i;})
				.whenComplete((value, error) -> {
					if(error == null) {
						log.info("Success: {}", value);
					} else {
						log.warn("failure: {}", error.getMessage());
					}
				})
				.thenApply(i -> {log.info("Stage 3: {}", i); return 1/i;})
				.handle((value, error) -> {
					if( error == null) {
						// log.info("Success: {}", value);
						return value +1;
					} else {
						// log.warn("Failure: {}", error.getMessage());
						return -1;
					}
				})
				.thenApply(i -> {log.info("Stage 4: {}", i); return 1/i;})
				.join();
	}
}
