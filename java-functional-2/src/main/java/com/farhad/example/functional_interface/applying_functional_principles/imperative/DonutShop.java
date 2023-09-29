package com.farhad.example.functional_interface.applying_functional_principles.imperative;

public class DonutShop {
    
    public static Donut buyDonut(CreditCard creditCard) {  
        Donut donut = new Donut();
        creditCard.charge(donut.price());
        return donut;
    }
}
