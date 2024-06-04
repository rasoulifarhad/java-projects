package com.farhad.example.refactoring.move_between_classes.demo1;

import lombok.Value;

@Value
public class AccountType {

    private boolean premium;

    public boolean isPremium() {
        return premium;
    }

}
