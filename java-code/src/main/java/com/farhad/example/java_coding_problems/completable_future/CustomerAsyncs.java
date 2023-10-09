package com.farhad.example.java_coding_problems.completable_future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CustomerAsyncs {
	

	public static void printOrder() throws InterruptedException, ExecutionException{

		CompletableFuture<Void> cfPrintOrder = CompletableFuture.runAsync(() -> {
			try {
				System.out.println("Order is printed by: "  +   Thread.currentThread().getName());
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});
		cfPrintOrder.get();
		System.out.println("Customer order was printed ...");
	}

	public static void fetchOrderSummary() throws InterruptedException, ExecutionException {
		CompletableFuture<String> cfOrderSummary = CompletableFuture.supplyAsync(() -> {
			try {
				System.out.println("Fetch order summary by: "  +   Thread.currentThread().getName());
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return "Order summary #12345";
		});

		String summary = cfOrderSummary.get();
		System.out.println("Order summary: " + summary);
	}

	public static void fetchOrderSummaryExecutor() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		CompletableFuture<String> cfOrderSummary = CompletableFuture.supplyAsync(() -> {
			try {
				System.out.println("Fetch order summary by: "  +   Thread.currentThread().getName());
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return "Order summary #12345";
		}, executor);

		String summary = cfOrderSummary.get();
		System.out.println("Order summary: " + summary);

		executor.shutdown();
	}

	public static void fetchInvoiceTotalSign() throws InterruptedException, ExecutionException {

		CompletableFuture<String> cfFetchInvoice = CompletableFuture.supplyAsync(() -> {
			try {
				System.out.println("Fetch invoice by: "  +   Thread.currentThread().getName());
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return "Invoice #6789";
		});

		CompletableFuture<String> cfTotalSign = cfFetchInvoice
				.thenApplyAsync(o -> o + " Total: $345 ")
				.thenApplyAsync(o -> o + " Signed");
		String result = cfTotalSign.get();
		System.out.println("Invoice: " + result);
	}

	public static void fetchAndPrintOrder() throws InterruptedException, ExecutionException {

		CompletableFuture<Void> cfFetchAndPrintOrder = CompletableFuture.supplyAsync(() -> {
			try {
				System.out.println("Fetch order by: "  +   Thread.currentThread().getName());
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return "Order #4321";
		}).thenAccept(o -> 
			System.out.println("Printing order " + o + " by: " + Thread.currentThread().getName()));		

		cfFetchAndPrintOrder.get();
		System.out.println("Order was fetched and printed ");
	}

	public static void deliverOrderNotifyCustomer() throws InterruptedException, ExecutionException {

		CompletableFuture<Void> cfDeliverOrder = CompletableFuture.runAsync(() -> {
			try {
				System.out.println("Order was delivered by: "  +   Thread.currentThread().getName());
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		CompletableFuture<Void> cfNotifyCustomer = cfDeliverOrder.thenRun(() -> 
			System.out.println("Dear customer, your order has been delivered today by: " + Thread.currentThread().getName()));
		
		cfNotifyCustomer.get();
		System.out.println("Order was delivered and customer was notified.");
	}

	public static void fetchOrderTotalException() throws InterruptedException, ExecutionException {

		CompletableFuture<Integer> cfTotalOrder = CompletableFuture.supplyAsync(() -> {
				System.out.println("Compute total: : "  +   Thread.currentThread().getName());
				int surrogate = new Random().nextInt(1000);
				if(surrogate > 500) {
					throw new IllegalStateException("Invoice service is not responding");
				} else {
					return 1000;
				}
		}).exceptionally(ex -> {
			System.out.println("Exception: " + ex + " Thread: " + Thread.currentThread().getName());
			return 0;
		});

		int result = cfTotalOrder.get();
		System.out.println("Total: " + result);

	}
	public static void fetchInvoiceTotalSignChainOfException() throws InterruptedException, ExecutionException {

	}
	public static void fetchInvoiceTotalSignGlobalException() throws InterruptedException, ExecutionException {

	}
	public static void printInvoiceException() throws InterruptedException, ExecutionException {

	}
	public static void fetchOrderTotalExceptionAsync() throws InterruptedException, ExecutionException {

	}
	public static void fetchOrderTotalHandle() throws InterruptedException, ExecutionException {

	}
	// public static CompletableFuture<Integer>  taxes() {

	// }

}
