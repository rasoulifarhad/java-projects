package com.farhad.example.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamDemoTest {
    
    private Stream<String> currencies;
    private Supplier<Stream<String>> currenciesSupplier;


    @BeforeEach
    public void setupCurrencies() {
        currencies = Stream.of("GBP", "EUR", "USD","CAD", "AUD", "JPY", "HKD");
        currenciesSupplier = () -> Stream.of("GBP", "EUR", "USD","CAD", "AUD", "JPY", "HKD");
    }

    @Test
    public void streamForeachTest() {
        currencies.forEach( C -> log.info("{}", C) ); 

        // currencies.forEach(System.out::println); // error `stream has already been operated upon or closed`
    }

    @Test
    public void streamSupplierForeachTest() {

        currenciesSupplier.get().forEach( C -> log.info("{}", C) ); 

        currenciesSupplier.get().forEach( System.out::println ); 

        currenciesSupplier.get().forEach( log::info ); 
    }

    @Test
    public void currrenciesFilterTest() {

        currenciesSupplier.get()
                              .filter(c -> c.matches("USD|EUR") )
                              .forEach(log::info);  

    }
}
