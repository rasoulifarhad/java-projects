package com.farhad.example.product_price.asynchronous_style.future_based;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.farhad.example.product_price.service.GetExchangeRateEurToUsd;
import com.farhad.example.product_price.service.GetGrossAmountInUsd;
import com.farhad.example.product_price.service.GetNetAmountInUsd;
import com.farhad.example.product_price.service.GetPriceInEur;
import com.farhad.example.product_price.service.GetTax;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskRun {
	
	final private GetPriceInEur getPriceInEur = new GetPriceInEur();
	final private GetExchangeRateEurToUsd getExchangeRateEurToUsd = new GetExchangeRateEurToUsd();
	final private GetNetAmountInUsd getNetAmountInUsd = new GetNetAmountInUsd();
	final private GetTax getTax = new GetTax();
	final private GetGrossAmountInUsd getGrossAmountInUsd = new GetGrossAmountInUsd();

	final private ExecutorService executorService = Executors.newFixedThreadPool(10);

	public void anotherRun() throws InterruptedException, ExecutionException {

		log.info("task started!!");

		Future<Double> priceInEurFuture = executorService.submit(() -> getPriceInEur.get());
		Future<Double> exchangeRateEurToUsdFuture = executorService.submit(() -> getExchangeRateEurToUsd.get());

		while ( (!priceInEurFuture.isDone()) || (!exchangeRateEurToUsdFuture.isDone() ) ) {
			Thread.sleep(100);
			log.info("another task is running");
		}

		Double netAmountInUsd = getNetAmountInUsd.apply(priceInEurFuture.get(),exchangeRateEurToUsdFuture.get());
		
		Future<Double> taxFuture = executorService.submit(() -> getTax.apply(netAmountInUsd));

		while ( !taxFuture.isDone() ) {
			Thread.sleep(100);
			log.info("another task is running");
		}
		
		Double grossAmountInUsd =  getGrossAmountInUsd.apply(netAmountInUsd,taxFuture.get());

		log.info("this task finished: {}", 	grossAmountInUsd);
		executorService.awaitTermination(10_000, TimeUnit.MILLISECONDS);
		executorService.shutdownNow();
	}

	public void run() throws InterruptedException, ExecutionException {

		log.info("task started!!");
		Future<Double> priceInEurFuture = executorService.submit(() -> getPriceInEur.get());
		Future<Double> exchangeRateEurToUsdFuture = executorService.submit(() -> getExchangeRateEurToUsd.get());
		Future<Double> netAmountInUsdFuture = executorService.submit(() -> 
													getNetAmountInUsd.apply(
														priceInEurFuture.get(),
														exchangeRateEurToUsdFuture.get()));
		Future<Double> taxFuture = executorService.submit(() -> getTax.apply(netAmountInUsdFuture.get()));

		Future<Double> grossAmountFuture = executorService.submit(() -> 
													getGrossAmountInUsd.apply(
														netAmountInUsdFuture.get(),
														taxFuture.get()));

		log.info("this task finished: {}", grossAmountFuture.get());
		executorService.awaitTermination(10_000, TimeUnit.MILLISECONDS);
		executorService.shutdownNow();
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		TaskRun taskRun = new TaskRun();
		// taskRun.run();
		taskRun.anotherRun();
	}

}
