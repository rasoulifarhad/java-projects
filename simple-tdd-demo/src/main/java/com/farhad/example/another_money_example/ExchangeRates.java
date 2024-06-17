package com.farhad.example.another_money_example;

import java.util.Map;

public abstract class ExchangeRates implements IExchangeRates {

    private static Map<Currency, Map<Currency, Double>> _map;

    public ExchangeRates(Map<Currency, Map<Currency, Double>> map) {
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

}
