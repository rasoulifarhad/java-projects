package com.farhad.example.another_money_example;

public abstract class Currency {

    private String currency;

    public Currency(String currency) {
        this.currency = currency;
    }

    public String asString() {
        return this.currency;
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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((currency == null) ? 0 : currency.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Currency other = (Currency) obj;
        if (currency == null) {
            if (other.currency != null)
                return false;
        } else if (!currency.equals(other.currency))
            return false;
        return true;
    }

    
}
 