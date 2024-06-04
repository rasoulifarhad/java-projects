package com.farhad.example.refactoring.move_between_classes.demo2;

import lombok.Getter;

@Getter
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
        return accountType.overdraftCharge(this);
    }

}
