package com.farhad.example.factorymethod;

import java.util.Scanner;

public class SalesTaxDriver {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        SalesTaxFactory salesTaxFactory = new SalesTaxFactory();

        System.out.print("Enter the location (boston/chicago/ny): ");
        String location = stdin.nextLine();
        System.out.print("Enter the dollar amount: ");
        double amount = stdin.nextDouble();

        SalesTax salesTax = salesTaxFactory.makeTaxObject(location);

        System.out.printf("Bill amount for %s of $%6.2f is: ", location, amount);

        salesTax.calculateTax(amount);
    }
}
