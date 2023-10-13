package com.farhad.example.functional_interface;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class PickStockImperativeClubbed {
    
    public static void main(String[] args) {

        StockInfo highPriced = new StockInfo("", BigDecimal.ZERO);
        final Predicate<StockInfo> isPriceLessThan500 = StockUtil.isPriceLessThan(500);

        for (  String symbole : Tickers.symbols) {
            StockInfo stockInfo = StockUtil.getPrice(symbole); 
            if(isPriceLessThan500.test(stockInfo)) {
                highPriced = StockUtil.pickHigh(highPriced, stockInfo);
            }
        }
        System.out.println("High priced under $500 is " + highPriced);
    }
}
