package com.farhad.example.functional_interface.separating_concerns_lambda.iterations.Iteration1;

import java.math.BigDecimal;
import java.util.function.Function;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalculateNAV {
    
    private final Function<String, BigDecimal> priceFinder;

    public BigDecimal computeStockWorth(final String ticker, final int shares) {
        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }

    public static void main(String[] args) {
        CalculateNAV calculateNav = new CalculateNAV(AlphavantageFinance::getPrice);
        System.out.println(String.format("100 shares of Google worth: $%.2f",
                calculateNav.computeStockWorth("GOOG", 100)));
    }
}
