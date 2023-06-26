package com.farhad.example.guava.model;

import java.math.BigDecimal;

import com.google.common.base.Preconditions;

public class Money {
    private final BigDecimal amount;
    private final Currency currency;

    public enum Currency {
        USD, EUR, JPY, GBP
    }

    public Money(BigDecimal amount, Currency currency) {
        // if (amount == null) {
        //     throw new NullPointerException("amount must not be null");
        // }
        // if(currency == null) {
        //     throw new NullPointerException("currency must not be null");
        // }
        // if (amount.signum() < 0 ) {
        //     throw new IllegalArgumentException("amount must be positive " + amount);
        // }
        // Preconditions.checkNotNull(amount, "amount must not be null");
        // Preconditions.checkNotNull(currency, "currency must not be null");
        // Preconditions.checkArgument(amount.signum() >= 0, "amount must be positive: %s", amount);
        // this.amount = amount;
        // this.currency = currency;
        this.amount = Preconditions.checkNotNull(amount, "amount must not be null");
        this.currency = Preconditions.checkNotNull(currency, "currency must not be null");
        Preconditions.checkArgument(amount.signum() >= 0, "amount must be positive: %s", amount);
    }
}
