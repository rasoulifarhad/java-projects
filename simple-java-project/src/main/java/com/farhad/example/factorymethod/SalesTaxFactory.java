package com.farhad.example.factorymethod;

public class SalesTaxFactory {

    public SalesTax makeTaxObject(String location) {
        if(location == null) return null;
        if(location.equalsIgnoreCase("Boston")) {
            return new BostonTax();
        } else if(location.equalsIgnoreCase("Chicago")) {
            return new ChicagoTax();
        } else if(location.equalsIgnoreCase("NY")) {
            return new NYTax();
        }
        return null;
    }
}
