package com.farhad.example.money;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.Money;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExchangeDemo {
    public static void main(String[] args) {
        // MonetaryConversions.getConversionProviderNames().forEach(s -> log.info("{}", s));
        CurrencyUnit euro = Monetary.getCurrency("EUR");
        CurrencyUnit dollar = Monetary.getCurrency(Locale.US);

        ExchangeRateProvider imfRateProvider = MonetaryConversions.getExchangeRateProvider("IMF");
        ExchangeRateProvider ecbRateProvider = MonetaryConversions.getExchangeRateProvider("ECB");
        
        CurrencyConversion ecbDollarConvertion = ecbRateProvider.getCurrencyConversion(dollar);
        CurrencyConversion imfDollarConvertion = imfRateProvider.getCurrencyConversion(dollar);

        MonetaryAmount money = Money.of(10,euro);

        log.info("{}", money.with(ecbDollarConvertion));
        log.info("{}", money.with(imfDollarConvertion));
         
    }
}
