package com.farhad.example.another_money_example;

public class Currency {

    public static Currency UsDollar = new Currency("USD");
    public static Currency KoreanWon = new Currency("KRW");
    public static Currency Euro = new Currency("EUR");

    private String currency;

    public Currency(String currency) {
        this.currency = currency;
    }

    public String asString() {
        return this.currency;
    }


}
