package com.farhad.example.another_money_example;

public abstract class Money {
    private int amount;
    private String currency;

    protected Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int value() {
        return amount;
    }

    public int times(int multiplicand) {
        return amount *multiplicand;
    }

    public String asString() {
        return String.format("[amount=%s][currency=%s]",amount, currency);
    }
    
    public static Euro euro(int amount) {
        return new Euro(amount);
    }

    private static class Euro extends Money {

        public Euro(int amount) {
            super(amount, "EUR");
        }
    
    }
    
}
