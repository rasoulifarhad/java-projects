package com.farhad.example.another_money_example;

import static com.farhad.example.another_money_example.Currency.DefaultCurrency.Euro;
import static com.farhad.example.another_money_example.Currency.DefaultCurrency.KoreanWon;
import static com.farhad.example.another_money_example.Currency.DefaultCurrency.UsDollar;

import java.util.HashMap;
import java.util.Map;

public abstract class ExchangeRates implements IExchangeRates {

    private static Map<Currency, Map<Currency, Double>> _map;

    protected ExchangeRates(Map<Currency, Map<Currency, Double>> map) {
        _map = map;
    }
    
    @Override
    public IExchangeRateTo from(Currency currency) {
        if(!_map.containsKey(currency)) {
            throw new NoExchangeRateAvailableException();
        }
        return new InternalTo(_map.get(currency));
    }

    private static class InternalTo implements IExchangeRateTo {

        private Map<Currency, Double> _map;

        public InternalTo(Map<Currency, Double> _map) {
            this._map = _map;
        }

        @Override
        public double to(Currency currency) {
            if (!_map.containsKey(currency)) {
                throw new NoExchangeRateAvailableException();
            }
            return _map.get(currency);
        }

    }

public static final class InMemoryExchangeRates extends ExchangeRates {

    public InMemoryExchangeRates() {
        super(staticMap());
    }

    private static Map<Currency, Map<Currency, Double>> staticMap() {

        return new HashMap<Currency, Map<Currency, Double>>() {

            {
                Map<Currency, Double> m;
                m = computeIfAbsent(UsDollar, s -> new HashMap<>());
                m.putAll(new HashMap<Currency, Double>() {
                    {
                        put(UsDollar, 1.0);
                        put(KoreanWon, 1100.0);
                        // put(Euro, 1.2);
                    }
                });

                m = computeIfAbsent(Euro, s -> new HashMap<>());
                m.putAll(new HashMap<Currency, Double>() {
                    {
                        put(Euro, 1.0);
                        put(UsDollar, 1.2);
                    }
                });

                m = computeIfAbsent(KoreanWon, s -> new HashMap<>());
                m.putAll(new HashMap<Currency, Double>() {
                    {
                        put(KoreanWon, 1.0);
                    }
                });
            }
        };
    }
    
}

}
