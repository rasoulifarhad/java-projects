package com.farhad.example.ddd_tips.aggregate_root.orders;

import java.util.UUID;

import com.farhad.example.ddd_tips.aggregate_root.orders.Product.ProductId;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Data
public class Product extends AggregateRoot<ProductId>{
	
	private String name;
	
	public Product(ProductId id) {
		super(id);
	}

	@RequiredArgsConstructor
	@Value
	public static class ProductId {
		private final String id;

		public static ProductId createRandomUnique() {
			return new ProductId(UUID.randomUUID().toString());
		}

	}

}
