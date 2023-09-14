package com.farhad.example.ddd_tips.tomato_architecture.demo2;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

public class Demo2 {
	
	interface Order {

	}
	static class DontDoThis {

		interface OrderService {
			List<Order> findPendingOrders();
		}
	}

	// With this approach, you can decouple order processing logic from scheduler and can test independently 
	// without triggering through Scheduler.
	static class DoThis {

		@Service
		@Transactional
		static class OrderService {
			List<Order> findPendingOrders() {
				return new ArrayList<>();
			}

			public void processOrders(List<Order> orders) {
			}
		}
		@Component
		@RequiredArgsConstructor
		static class OrderProcessingJob {
			private final OrderService orderService;

			@Scheduled(cron = "0 * * * * *")
			void run() {
				List<Order> orders = orderService.findPendingOrders();
				orderService.processOrders(orders);

			}
		}
	}

}
