package com.farhad.example.ddd_tips.repository.collection_oriented;

import java.util.Objects;

import lombok.Data;

@Data
public class AggregateRoot<T> {
	T id;

	public AggregateRoot(T id) {
		this.id = Objects.requireNonNull(id);
	}

	
}