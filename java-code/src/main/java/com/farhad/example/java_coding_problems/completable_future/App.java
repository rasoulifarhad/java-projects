package com.farhad.example.java_coding_problems.completable_future;

import java.util.concurrent.ExecutionException;

public class App {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		System.out.println();
		System.out.println("Printing customer order ...");
		CustomerAsyncs.printOrder();

		System.out.println();
		System.out.println("Fetch order summary ...");
		CustomerAsyncs.fetchOrderSummary();

		System.out.println();
		System.out.println("Fetch order summary (Executor) ...");
		CustomerAsyncs.fetchOrderSummaryExecutor();

		System.out.println();
		System.out.println("Fetch order, compute total and sign  ...");
		CustomerAsyncs.fetchInvoiceTotalSign();;

		System.out.println();
		System.out.println("Fetch and print order ...");
		CustomerAsyncs.fetchAndPrintOrder();

		System.out.println();
		System.out.println("Deliver order and notify customer ...");
		CustomerAsyncs.deliverOrderNotifyCustomer();
	}
}
