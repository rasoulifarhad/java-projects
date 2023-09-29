package com.farhad.example.functional_interface.applying_functional_principles.functional;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class CreditCard {

    @NonNull
    private BigDecimal balance;

    public void charge(BigDecimal amount) {
        if(balance.compareTo(amount) < 0)  {
            throw new IllegalArgumentException();
        }
        balance = balance.subtract(amount);
    }

}
