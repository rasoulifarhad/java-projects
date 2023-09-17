package com.farhad.example.product_price.asynchronous_style.completable_future_based;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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


	public void run() throws InterruptedException, ExecutionException {


		CompletableFuture<Double> priceInEurFuture = CompletableFuture.supplyAsync(() -> getPriceInEur.get());
		CompletableFuture<Double> exchangeRateEurToUsdFuture = CompletableFuture.supplyAsync(() -> getExchangeRateEurToUsd.get());

		CompletableFuture<Double> netAmountInUsd = 
										priceInEurFuture.thenCombine(
											exchangeRateEurToUsdFuture, 
											(price, exchangeRate) -> price * exchangeRate);
		log.info("task started!!");
		CompletableFuture<Double> result =
		netAmountInUsd
			.thenCompose(amount ->
					CompletableFuture.supplyAsync(() -> amount * (1 + getTax.apply(amount))))
			.whenComplete((grossAmountInUsd, throwable) -> {
				if( throwable == null ) {
					log.info("this task finished: {}", 	grossAmountInUsd);
				} else {
					log.warn("this task failed: {}", throwable.getMessage());
				}
			 })
			 ;
		result.join();
		log.info("another task is running");			 
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		TaskRun taskRun = new TaskRun();
		// taskRun.run();
		taskRun.run();
		// Thread.sleep(5000);
	}

}
