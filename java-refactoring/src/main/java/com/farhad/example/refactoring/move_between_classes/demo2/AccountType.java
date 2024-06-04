package com.farhad.example.refactoring.move_between_classes.demo2;

import lombok.Value;

@Value
public class AccountType {

    private boolean premium;

    public boolean isPremium() {
        return premium;
    }

    public double overdraftCharge(Account account) {
        if(isPremium()) {
            double baseCharge = 10;
            if(account.getDaysOverdrawn() <= 7) {
                return baseCharge;
            } else {
                return baseCharge + (account.getDaysOverdrawn() -7) * 0.85;
            }
        } else {
            return account.getDaysOverdrawn() * 1.75;
        }
    }

}
