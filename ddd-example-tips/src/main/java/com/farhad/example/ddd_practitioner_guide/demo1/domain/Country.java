package com.farhad.example.ddd_practitioner_guide.demo1.domain;

public enum Country {
	USA("US"), INDIA("IN"), WAKANDA("WK"), SOKOVIA("SK");

	private final String code;

	Country(final String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
