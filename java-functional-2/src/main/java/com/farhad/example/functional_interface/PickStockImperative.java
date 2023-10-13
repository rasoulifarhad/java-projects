package com.farhad.example.functional_interface;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PickStockImperative {
    public static void main(String[] args) {
        final List<StockInfo> stocks = new ArrayList<>();
        for (  String symbole : Tickers.symbols) {
            stocks.add(StockUtil.getPrice(symbole)); 
        }

        final List<StockInfo> stocksPriceUnder500 = new ArrayList<>();
        final Predicate<StockInfo> isPriceLessThan500 = StockUtil.isPriceLessThan(500);

        for (StockInfo stockInfo : stocks) {
            if(isPriceLessThan500.test(stockInfo)) {
                stocksPriceUnder500.add(stockInfo);
            }
        }

        StockInfo highPriced = new StockInfo("", BigDecimal.ZERO);
        for (StockInfo stockInfo : stocksPriceUnder500) {
            highPriced = StockUtil.pickHigh(highPriced, stockInfo);
        }

        System.out.println("High priced under $500 is " + highPriced);
    }
}
