package com.farhad.example.design_principles02.ecommerce_system;

public interface TaxCalculator {

	double taxAmount(Salable itemSold, int quantity);
}
