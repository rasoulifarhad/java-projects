package com.farhad.example.refactoring.move_between_classes.demo1;

public class Account {

    private AccountType accountType;
    private int daysOverdrawn;
    
    public double bankCharge() {
        double result = 4.5;
        if(daysOverdrawn > 0) {
            result += overdraftCharge();
        }
        return result;
    }

    public double overdraftCharge() {
        if(accountType.isPremium()) {
            double baseCharge = 10;
            if(daysOverdrawn <= 7) {
                return baseCharge;
            } else {
                return baseCharge + (daysOverdrawn -7) * 0.85;
            }
        } else {
            return daysOverdrawn * 1.75;
        }
    }
}
