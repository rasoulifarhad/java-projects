package com.farhad.example.ddd_tips.aggregate_pattern;

public interface ProductRepository {
	Product findById(String id);
}
