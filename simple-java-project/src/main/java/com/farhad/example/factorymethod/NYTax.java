package com.farhad.example.factorymethod;

public class NYTax extends SalesTax {

    @Override
    double getRate() {
        return 0.05;
    }

}
