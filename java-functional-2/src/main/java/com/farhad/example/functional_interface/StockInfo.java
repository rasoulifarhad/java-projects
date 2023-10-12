package com.farhad.example.functional_interface;

import java.math.BigDecimal;

public class StockInfo {
    public final String ticker;
    public final BigDecimal price;
    
    public StockInfo(String ticker, BigDecimal price) {
        this.ticker = ticker;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ticker: %s price: %g", ticker, price);
    }

    
    
}
