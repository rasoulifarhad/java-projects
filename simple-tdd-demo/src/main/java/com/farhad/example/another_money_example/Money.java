package com.farhad.example.another_money_example;

public class Money {
    
    private double amount;
    private String currency;

    protected Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
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

    public Money plus(Money addend) {
        return new Money(this.amount + addend.amount, currency);
    }

    public Money times(int multiplicand) {
        return new Money(amount * multiplicand, currency);
    }

    public Money divide(int divisor) {
        return new Money(amount / divisor, currency);
    }

    public String asString() {
        return String.format("[amount=%.1f][currency=%s]",amount, currency);
    }
    
}
