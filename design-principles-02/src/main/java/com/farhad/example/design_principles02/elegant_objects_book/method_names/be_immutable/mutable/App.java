package com.farhad.example.design_principles02.elegant_objects_book.method_names.be_immutable.mutable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {

		{
			Cash five = new Cash(5);
			five.mul(10);
			System.out.println(five);
		}

		{
			Map<Cash, String> map = new HashMap<>();
			Cash four = new Cash(4);
			Cash eight = new Cash(8);
			map.put(four, "four");
			map.put(eight, "eight");
			four.mul(2);
			System.out.println(map);
			System.out.println(map.get(four));

		}

		{
			// Temporal coupling
			Cash price = new Cash();
			price.setDollars(29);
			price.setCents(95);
			System.out.println(price);

			Cash price2 = new Cash();
			price2.setDollars(29);
			System.out.println(price2);
			price2.setCents(95);
		}

		{
			// side effect-free
			System.out.println();
			Cash five = new Cash(5);
			print(five);
			System.out.println(five);

		}

		{
			System.out.println();
			final Cash cash = new Cash(15, 10);
			final CountDownLatch start = new CountDownLatch(1);
			final Callable<Object> script = new Callable<Object>() {

				@Override
				public Object call() throws Exception {
					start.await();
					cash.mul(2);
					System.out.println(cash);
					return null;
				}
				
			};

			final ExecutorService svc = Executors.newCachedThreadPool();
			svc.submit(script);
			svc.submit(script);
			start.countDown();

			svc.shutdown();
		}
	}
	
	public static void print(Cash price) {

		System.out.println("Today price is: " + price);
		price.mul(2);
		System.out.println("Buy now, tomarrow price is: " + price);
	}
	
}
