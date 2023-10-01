package com.farhad.example.command.demo3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BuyStock implements Order{

    private Stock stock;

    @Override
    public void execute() {
        stock.buy();
    }
    
}
