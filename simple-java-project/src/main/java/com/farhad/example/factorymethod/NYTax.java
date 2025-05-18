package com.farhad.example.factorymethod;

public class NYTax extends SalesTax {

    @Override
    void getRate() {
        rate = 0.05;
    }

}
