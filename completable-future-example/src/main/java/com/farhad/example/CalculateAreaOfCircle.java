package com.farhad.example;

import java.util.concurrent.CompletableFuture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculateAreaOfCircle {
	public static void main(String[] args) {
		CompletableFuture<Double> pi = CompletableFuture.supplyAsync(() -> Math.PI);
		CompletableFuture<Integer> radius = CompletableFuture.supplyAsync(() -> 1);

		CompletableFuture<Void> area = radius
				.thenApply(r -> r * r )
				.thenCombine(pi, (multiplier1, multiplier2) -> multiplier1 * multiplier2)
				.thenAccept(a -> log.info("area: {}", a))
				.thenRun(() -> log.info("area calculated."));
		area.join();
	}
}
