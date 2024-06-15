package com.farhad.example.another_money_example;

public class Money {
    
    private double amount;
    private String currency;
    private IExchangeRates exchangeRates;

    private Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
        this.exchangeRates = new ExchangeRates();
    }

    private Money(double amount, String currency, IExchangeRates exchangeRates) {
        this.amount = amount;
        this.currency = currency;
        this.exchangeRates = exchangeRates;
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
        double exchangeRate = exchangeRates.exchangeRate(this.currency, addend.currency);
        return new Money(this.amount + (addend.amount * exchangeRate), this.currency);
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

    public Money toWon() {
        double exchangeRate = exchangeRates.from(currency).to("KRW");
        return Money.won(amount * exchangeRate);
    }

    public Money toDollar() {
        double exchangeRate = exchangeRates.from(currency).to("USD");
        return Money.dollar(amount * exchangeRate);
    }

   
}
