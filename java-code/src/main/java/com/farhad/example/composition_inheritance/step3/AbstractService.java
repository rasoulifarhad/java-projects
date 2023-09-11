package com.farhad.example.composition_inheritance.step3;

import java.util.UUID;

public abstract class AbstractService<T> implements Service<T> {

	@Override
	public String generateId() {
		return getUUID().toString();
	}

	UUID getUUID() {
		return UUID.randomUUID();
	}
	
}
