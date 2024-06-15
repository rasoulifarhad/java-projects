package com.farhad.example.another_money_example;

import java.util.HashMap;
import java.util.Map;

public class Money {
    
    private double amount;
    private String currency;

    private Money(double amount, String currency) {
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

    static Money fakeCurrency(double amount) {
        return new Money(amount, "No a Real Currency");
    }

    public Money plus(Money addend) {
        double exchangeRate = Money.exchangeRate(this.currency, addend.currency);
        return new Money(this.amount + (addend.amount * exchangeRate), this.currency);
    }

    private static double exchangeRate(String toCurrency , String fromCurrency) {
        Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>() {
            {
                computeIfAbsent("KRW", s -> new HashMap<>()).put("USD", 1.5);
                computeIfAbsent("EUR", s -> new HashMap<>()).put("USD", 1.2);
            }
        };
        if(fromCurrency.equals(toCurrency)) {
            return 1.0;
        }
        if(!map.containsKey(fromCurrency) || !map.get(fromCurrency).containsKey(toCurrency)) {
            throw new NoExchangeRateAvailableException();
        }
        return map.get(fromCurrency).get(toCurrency);    
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((currency == null) ? 0 : currency.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(referenceEquals(obj)) {
            return true;
        }
        if(!classEquals(obj)) {
            return false;
        }
        return equalsMoney((Money) obj);
    }
    
    private boolean referenceEquals(Object obj) {
        if (this == obj)
            return true;
        return false;

    }

    private boolean classEquals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        return true;
    }

    private boolean equalsMoney(Money other) {
        if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
            return false;
        if (currency == null) {
            if (other.currency != null)
                return false;
        } else if (!currency.equals(other.currency))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return amount + " " +  currency;
    }

   
}
