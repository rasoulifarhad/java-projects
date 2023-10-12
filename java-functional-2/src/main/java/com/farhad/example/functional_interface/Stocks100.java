package com.farhad.example.functional_interface;

import static java.util.stream.Collectors.joining;

import java.math.BigDecimal;

public class Stocks100 {
    
    public static void main(String[] args) {
        final BigDecimal HANDRED = new BigDecimal("100");
        System.out.println("Stocks priced over $100 are " +
            Tickers.symbols
                .stream()
                .filter(symbol ->  
                    AlphavantageFinance.getPrice(symbol).compareTo(HANDRED) > 0)
                .sorted()
                .collect(joining(", ")));
    }
}
