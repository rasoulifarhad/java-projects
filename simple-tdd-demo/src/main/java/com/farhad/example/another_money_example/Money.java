package com.farhad.example.another_money_example;

public class Money {
    
    private double amount;
    private String currency;

    protected Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money plus(Money addend) {
        return new Money(this.amount + addend.amount, currency);
    }

    public double times(int multiplicand) {
        return amount * multiplicand;
    }

    public double divide(int divisor) {
        return amount / divisor;
    }

    public String asString() {
        return String.format("[amount=%.1f][currency=%s]",amount, currency);
    }
    
    public static Money euro(double amount) {
        return new Money(amount, "EUR");
    }

    public static Money dollar(double amount) {
        return new Money(amount, "USD");
    }
    
    public static Money won(double amount){
        return new Money(amount, "KRW");
    }

}
