package com.farhad.example.another_money_example;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRates implements IExchangeRates {

    private static Map<String, Map<String, Double>> _map;

    public ExchangeRates() {
        this(get_map());
    }

    private ExchangeRates(Map<String, Map<String, Double>> map) {
        _map  = map;
    }

    private static Map<String, Map<String, Double>> get_map() {
        _map = new HashMap<String, Map<String, Double>>() {
            {
                computeIfAbsent("KRW", s -> new HashMap<>()).put("USD", 1.5);
                computeIfAbsent("EUR", s -> new HashMap<>()).put("USD", 1.2);
            }
        };
        return _map;
    }

    @Override
    public double exchangeRate(String toCurrency , String fromCurrency) {
        if(fromCurrency.equals(toCurrency)) {
            return 1.0;
        }
        if(!_map.containsKey(fromCurrency) || !_map.get(fromCurrency).containsKey(toCurrency)) {
            throw new NoExchangeRateAvailableException();
        }
        return _map.get(fromCurrency).get(toCurrency);    
    }
}
