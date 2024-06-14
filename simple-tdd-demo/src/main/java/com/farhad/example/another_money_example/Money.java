package com.farhad.example.another_money_example;

public abstract class Money {
    private double amount;
    private String currency;

    protected Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double value() {
        return amount;
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
    
    public static Euro euro(int amount) {
        return new Euro(amount);
    }

    public static Dollar dollar(int amount) {
        return new Dollar(amount);
    }
    
    public static Money won(int amount){
        return new Won(amount);
    }

    private static final class Euro extends Money {

        public Euro(int amount) {
            super(amount, "EUR");
        }
    
    }
    
    private static final class Dollar extends Money {


        public Dollar(int amount) {
            super(amount, "USD");
        }
    
    }
    
    private static final class Won extends Money {


        public Won(int amount) {
            super(amount, "KRW");
        }
    
    }


}
