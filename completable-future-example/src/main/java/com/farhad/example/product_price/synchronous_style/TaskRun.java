package com.farhad.example.product_price.synchronous_style;

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

	public void run() {

		log.info("task started!!");
		Double netAmount = getNetAmountInUsd.apply(
												getPriceInEur.get(), 
												getExchangeRateEurToUsd.get());
		Double grossAmount = getGrossAmountInUsd.apply(netAmount, getTax.apply(netAmount));

		log.info("this task finished: {}", grossAmount);

	}

	public static void main(String[] args) {
	
		TaskRun taskRun = new TaskRun();
		taskRun.run();
	}
}
