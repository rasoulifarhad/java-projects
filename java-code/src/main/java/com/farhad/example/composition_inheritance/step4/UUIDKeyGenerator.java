package com.farhad.example.composition_inheritance.step4;

import java.util.UUID;

public class UUIDKeyGenerator implements KeyGenerator {

	@Override
	public String generateId() {
		return getUUID().toString();
	}

	UUID getUUID() {
		return UUID.randomUUID();
	}
	
}
