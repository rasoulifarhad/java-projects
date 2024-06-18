package com.farhad.example.another_money_example;

import com.farhad.example.another_money_example.ExchangeRates.InMemoryExchangeRates;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

public abstract class Money {
    

    public static final double _double(Money origin) {
        return origin.amountValue();
    }

    public static final Currency _currency(Money origin) {
        return origin.currencyValue();
    }

    protected abstract double amountValue();

    protected abstract Currency currencyValue();

    public Money times(int multiplicand) {
        return new TimesMney(this, multiplicand);
    }

    public Money divide(int divisor) {
        return new DivideMoney(this, divisor);
    }

    public Money plus(Money addend) {
        return new PlusMoney(this, addend);
    }

    public Money to(Currency currency) {
        return new ConvertToMoney(this, currency);
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(amountValue());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((currencyValue() == null) ? 0 : currencyValue().hashCode());
        return result;
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
        return this.amountValue() == other.to(this.currencyValue()).amountValue();
    }

    public boolean isSameAs(Money other) {
        return other == null ? false : equalsMoney(other);
    }

    @Override
    public String toString() {
        return amountValue() + " " +  currencyValue();
    }

    public String asString() {
        return String.format("[amount=%.1f][currency=%s]",amountValue(), currencyValue().asString());
    }

   @RequiredArgsConstructor
   public static class TimesMney extends Money {

    private final Money origin;
    private final int multiplicand;

    @Override
    protected double amountValue() {
        return _double(origin) * multiplicand;
    }

    @Override
    protected Currency currencyValue() {
        return _currency(origin);
    }

   }

   @RequiredArgsConstructor
   public static class DivideMoney extends Money {

    private final Money origin;
    private final int divisor;

    @Override
    protected double amountValue() {
        return _double(origin) / divisor;
    }

    @Override
    protected Currency currencyValue() {
        return _currency(origin);
    }

   }

   @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
   public static class  ConvertToMoney extends Money {
   
    private final Money origin;
    private final Currency toCurrency;
    private final IExchangeRates exchangeRates;


    public ConvertToMoney(Money origin, Currency toCurrency) {
        this(origin, toCurrency, new InMemoryExchangeRates());
    }


    @Override
    protected double amountValue() {
        return _double(origin) * exchangeRates.from(_currency(origin)).to(toCurrency);
    }


    @Override
    protected Currency currencyValue() {
        return toCurrency;
    }

   }

   @RequiredArgsConstructor
   public static class PlusMoney extends Money {

    private final Money augend;
    private final Money addend;

    @Override
    protected double amountValue() {
        return _double(augend) + _double(addend.to(currencyValue()));
    }

    @Override
    protected Currency currencyValue() {
        return _currency(augend);
    }
   
    
   }
}
