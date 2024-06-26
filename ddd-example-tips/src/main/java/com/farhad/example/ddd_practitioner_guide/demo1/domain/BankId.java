package com.farhad.example.ddd_practitioner_guide.demo1.domain;

import java.util.UUID;


public class BankId extends BaseId {

	protected BankId(UUID id) {
		super(id);
	}

	@SuppressWarnings("unused")
	private BankId(String id) {
		this(UUID.fromString(id));
	}

	public static BankId from(UUID id) {
		return new BankId(id);
	}

	public static BankId randomId() {
		return new BankId(UUID.randomUUID());
	}



}
