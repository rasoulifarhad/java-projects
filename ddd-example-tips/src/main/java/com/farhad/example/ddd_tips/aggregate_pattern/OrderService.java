package com.farhad.example.ddd_tips.aggregate_pattern;

import java.math.BigDecimal;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {
	// fields, c-tor 
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;

	// @Transactional
	public void addPosition(String orderId, String productId, BigDecimal quantity) {
		// stuff
		Order order = orderRepository.findById(orderId);
		Product product = productRepository.findById(productId);
		order.addPosition(product, quantity);
		orderRepository.save(order);
	}
}
