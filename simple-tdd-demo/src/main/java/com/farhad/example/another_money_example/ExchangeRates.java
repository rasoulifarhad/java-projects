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
                computeIfAbsent("KRW", s -> new HashMap<>()).put("KWR", 1.5);
                computeIfAbsent("EUR", s -> new HashMap<>()).put("EUR", 1.2);
                computeIfAbsent("EUR", s -> new HashMap<>()).put("USD", 1.2);
                computeIfAbsent("USD", s -> new HashMap<>()).put("KRW", 1100.0);
                computeIfAbsent("USD", s -> new HashMap<>()).put("USD", 1.0);
            }
        };
        return _map;
    }

    @Override
    public double exchangeRate(String toCurrency, String fromCurrency) {
        if (!_map.containsKey(fromCurrency) || !_map.get(fromCurrency).containsKey(toCurrency)) {
            throw new NoExchangeRateAvailableException();
        }
        return _map.get(fromCurrency).get(toCurrency);
    }

    @Override
    public IExchangeRateTo from(String currency) {
        if(!_map.containsKey(currency)) {
            throw new NoExchangeRateAvailableException();
        }
        return new InternalTo(_map.get(currency));
    }

    private static class InternalTo implements IExchangeRateTo {

        private Map<String, Double> _map;

        public InternalTo(Map<String, Double> _map) {
            this._map = _map;
        }

        @Override
        public double to(String currency) {
            if (!_map.containsKey(currency)) {
                throw new NoExchangeRateAvailableException();
            }
            return _map.get(currency);
        }

    }

}
