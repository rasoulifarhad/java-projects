package com.farhad.example.another_money_example;

import java.util.HashMap;
import java.util.Map;

import com.farhad.example.another_money_example.Currency.DefaultCurrency;

public final class InMemoryExchangeRates extends ExchangeRates {

    public InMemoryExchangeRates() {
        super(staticMap());
    }

    private static Map<Currency, Map<Currency, Double>> staticMap() {

        return new HashMap<Currency, Map<Currency, Double>>() {

            {
                Map<Currency, Double> m;
                m = computeIfAbsent(DefaultCurrency.UsDollar, s -> new HashMap<>());
                m.putAll(new HashMap<Currency, Double>() {
                    {
                        put(DefaultCurrency.UsDollar, 1.0);
                        put(DefaultCurrency.KoreanWon, 1100.0);
                        put(DefaultCurrency.Euro, 1.2);
                    }
                });

                m = computeIfAbsent(DefaultCurrency.Euro, s -> new HashMap<>());
                m.putAll(new HashMap<Currency, Double>() {
                    {
                        put(DefaultCurrency.Euro, 1.0);
                    }
                });

                m = computeIfAbsent(DefaultCurrency.KoreanWon, s -> new HashMap<>());
                m.putAll(new HashMap<Currency, Double>() {
                    {
                        put(DefaultCurrency.KoreanWon, 1.0);
                    }
                });
            }
        };
    }
    
}
