package com.farhad.example.guava.model;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;

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
        this.amount = checkNotNull(amount, "amount must not be null");
        this.currency = checkNotNull(currency, "currency must not be null");
        checkArgument(amount.signum() >= 0, "amount must be positive: %s", amount);
    }
}
