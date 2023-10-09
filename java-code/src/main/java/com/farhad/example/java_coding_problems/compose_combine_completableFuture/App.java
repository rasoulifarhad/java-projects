package com.farhad.example.java_coding_problems.compose_combine_completableFuture;

import java.util.concurrent.ExecutionException;

public class App {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		System.out.println("Exemplify thenCompose():");
		CustomerAsyncs.fetchOrderTotal("Customer #1");

		System.out.println("Exemplify thenCombine():");
		CustomerAsyncs.deliverParcel("#123");

	}
}
