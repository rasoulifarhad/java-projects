package com.farhad.example.another_money_example;

import java.util.HashMap;
import java.util.Map;

import com.farhad.example.another_money_example.Currency.DefaultCurrency;

public class ExchangeRates implements IExchangeRates {

    private static Map<Currency, Map<Currency, Double>> _map;

    public ExchangeRates() {
        this(get_map());
    }

    private ExchangeRates(Map<Currency, Map<Currency, Double>> map) {
        _map = map;
    }

    private static Map<Currency, Map<Currency, Double>> get_map() {

        _map = new HashMap<Currency, Map<Currency, Double>>() {

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
        return _map;
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

}
