package com.farhad.example.another_money_example;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class Currency {

    private String currency;

    public Currency(String currency) {
        this.currency = currency;
    }

    public String asString() {
        return this.currency;
    }

    public String toString() {
        return asString();
    }

    public static class DefaultCurrency extends Currency{

        public static Currency UsDollar = new DefaultCurrency("USD");
        public static Currency KoreanWon = new DefaultCurrency("KRW");
        public static Currency Euro = new DefaultCurrency("EUR");

        public static Currency Fake = new DefaultCurrency("Fake_Fake");
        
        public DefaultCurrency(String currency) {
            super(currency);
        }

    }
    
}
 