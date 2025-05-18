package com.farhad.example.factorymethod;

public class BostonTax extends SalesTax {

    @Override
    double getRate() {
        return 0.875;
    }

}
