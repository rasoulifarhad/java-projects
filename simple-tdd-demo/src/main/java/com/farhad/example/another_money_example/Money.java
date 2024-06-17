package com.farhad.example.another_money_example;

public abstract class Money {
    
    private double amount;
    private Currency currency;
    private IExchangeRates exchangeRates;

    protected Money(double amount, Currency currency) {
        this(amount, currency, new InMemoryExchangeRates());
    }

    private Money(double amount, Currency currency, IExchangeRates exchangeRates) {
        this.amount = amount;
        this.currency = currency;
        this.exchangeRates = exchangeRates;
    }

    public Money to(Currency currency) {
        double exchangeRate = exchangeRates.from(this.currency).to(currency);
        return new InnerMoney(amount * exchangeRate, currency);
    }

    public Money plus(Money addend) {
        double exchangeRate = exchangeRates.from(this.currency).to(addend.currency);
        return new InnerMoney(this.amount + (addend.amount * exchangeRate), this.currency);
    }

    public Money times(int multiplicand) {
        return new InnerMoney(amount * multiplicand, currency);
    }

    public Money divide(int divisor) {
        return new InnerMoney(amount / divisor, currency);
    }

    public String asString() {
        return String.format("[amount=%.1f][currency=%s]",amount, currency.asString());
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
        if (!Money.class.isAssignableFrom(obj.getClass())) 
            return false;
        return true;
        // return true;
    }

    private boolean equalsMoney(Money other) {
        double exchangeRate = exchangeRates.from(other.currency).to(this.currency);
        return this.amount == (other.amount * exchangeRate);
    }

    public boolean isSameAs(Money other) {
        return other == null ? false : equalsMoney(other);
    }

    @Override
    public String toString() {
        return amount + " " +  currency;
    }

   private  static class InnerMoney  extends Money {

    protected InnerMoney(double amount, Currency currency) {
        super(amount, currency);
    }

   }
}
