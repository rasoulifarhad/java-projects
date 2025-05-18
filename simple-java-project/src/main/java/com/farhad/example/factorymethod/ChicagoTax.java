package com.farhad.example.factorymethod;

public class ChicagoTax extends SalesTax {

    @Override
    double getRate() {
        return 0.075;
    }

}
