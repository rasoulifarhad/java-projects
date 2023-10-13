package com.farhad.example.ddd_practitioner_guide.demo1.domain;

import java.util.UUID;


public class LCApplicationId extends BaseId {

	protected LCApplicationId(UUID id) {
		super(id);
	}
	

	public static LCApplicationId randomId() {
		return new LCApplicationId(UUID.randomUUID());
	}

}
