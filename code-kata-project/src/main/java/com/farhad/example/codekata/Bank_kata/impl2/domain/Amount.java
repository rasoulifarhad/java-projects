package com.farhad.example.codekata.Bank_kata.impl2.domain;

import java.text.DecimalFormat;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class Amount {
    
    public static final Amount ZERO = amountOf(0);
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");
    private final int value;

    public static Amount amountOf(int value) {
        return new Amount(value);
    }

    public Amount plus(Amount other) {
        Objects.requireNonNull(other);
        return amountOf(value + other.value );
    }

    public boolean isGreaterThan(Amount other) {
        Objects.requireNonNull(other);
        return this.value > other.value;
    }

    public Amount absValue()  {
        return amountOf(Math.abs(value));
    }

    @Override
    public String toString() {
        return decimalFormat.format(value);
    }

    public Amount negative() {
        return amountOf(-value);
    }
}
