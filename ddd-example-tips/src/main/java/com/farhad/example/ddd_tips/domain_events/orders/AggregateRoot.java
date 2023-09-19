package com.farhad.example.ddd_tips.domain_events.orders;

import java.util.Objects;

import lombok.Data;

@Data
public class AggregateRoot<T> {
	T id;

	public AggregateRoot(T id) {
		this.id = Objects.requireNonNull(id);
	}

	
}