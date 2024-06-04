package com.farhad.example.refactoring.move_between_classes.demo2;

import lombok.Value;

@Value
public class AccountType {

    private boolean premium;

    public boolean isPremium() {
        return premium;
    }

    public double overdraftCharge(int daysOverdrawn) {
        if(isPremium()) {
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
