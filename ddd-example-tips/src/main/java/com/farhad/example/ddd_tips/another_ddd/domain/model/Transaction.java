package com.farhad.example.ddd_tips.another_ddd.domain.model;

import java.math.BigDecimal;
import java.time.Instant;

public interface Transaction {
	BigDecimal amount();
	String issuerClientNumber();
	String sourceAccountNumber();
	String targetAccountNumber();
	Instant time();

	TransactionType type();
}
