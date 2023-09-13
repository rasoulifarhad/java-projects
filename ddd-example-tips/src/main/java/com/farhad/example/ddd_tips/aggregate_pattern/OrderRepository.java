package com.farhad.example.ddd_tips.aggregate_pattern;

public interface OrderRepository {
	Order findById(String id);
	void save(Order order);
}
