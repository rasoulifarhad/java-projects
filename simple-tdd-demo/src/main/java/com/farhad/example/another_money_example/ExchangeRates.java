package com.farhad.example.another_money_example;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRates implements IExchangeRates {

    private static Map<String, Map<String, Double>> _map;

    public ExchangeRates() {
        this(get_map());
    }

    private ExchangeRates(Map<String, Map<String, Double>> map) {
        _map = map;
    }

    private static Map<String, Map<String, Double>> get_map() {

        _map = new HashMap<String, Map<String, Double>>() {

            {
                Map<String, Double> m;
                m = computeIfAbsent("USD", s -> new HashMap<>());
                m.putAll(new HashMap<String, Double>() {
                    {
                        put("USD", 1.0);
                        put("KRW", 1100.0);
                        put("EUR", 1.2);
                    }
                });

                m = computeIfAbsent("EUR", s -> new HashMap<>());
                m.putAll(new HashMap<String, Double>() {
                    {
                        put("EUR", 1.0);
                    }
                });

                m = computeIfAbsent("KRW", s -> new HashMap<>());
                m.putAll(new HashMap<String, Double>() {
                    {
                        put("KRW", 1.0);
                    }
                });
            }
        };
        return _map;
    }

    @Override
    public IExchangeRateTo from(Currency currency) {
        if(!_map.containsKey(currency.asString())) {
            throw new NoExchangeRateAvailableException();
        }
        return new InternalTo(_map.get(currency.asString()));
    }

    private static class InternalTo implements IExchangeRateTo {

        private Map<String, Double> _map;

        public InternalTo(Map<String, Double> _map) {
            this._map = _map;
        }

        @Override
        public double to(Currency currency) {
            if (!_map.containsKey(currency.asString())) {
                throw new NoExchangeRateAvailableException();
            }
            return _map.get(currency.asString());
        }

    }

}
