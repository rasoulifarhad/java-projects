package com.farhad.example.ddd_tips.aggregate_root.orders;

import lombok.Data;

@Data
public class LocalEntity<T> {
	T id;

	public LocalEntity(T id) {
		this.id = id;
	}

	
}
