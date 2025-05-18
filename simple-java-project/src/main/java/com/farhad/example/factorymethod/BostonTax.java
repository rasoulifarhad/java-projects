package com.farhad.example.factorymethod;

public class BostonTax extends SalesTax {

    @Override
    void getRate() {
        rate = 0.875;
    }

}
