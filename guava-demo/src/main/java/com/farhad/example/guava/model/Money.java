package com.farhad.example.guava.model;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal amount;
    private final Currency currency;

    public enum Currency {
        USD, EUR, JPY, GBP
    }

    public Money(BigDecimal amount, Currency currency) {
        if (amount == null) {
            throw new NullPointerException("amount must not be null");
        }
        if(currency == null) {
            throw new NullPointerException("currency must not be null");
        }
        if (amount.signum() < 0 ) {
            throw new IllegalArgumentException("amount must be positive " + amount);
        }
        this.amount = amount;
        this.currency = currency;
    }
}
