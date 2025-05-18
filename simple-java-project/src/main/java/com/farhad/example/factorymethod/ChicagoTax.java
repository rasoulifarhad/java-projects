package com.farhad.example.factorymethod;

public class ChicagoTax extends SalesTax {

    @Override
    void getRate() {
        rate = 0.075;
    }

}
