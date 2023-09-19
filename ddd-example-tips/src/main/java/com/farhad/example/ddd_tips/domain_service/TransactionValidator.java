package com.farhad.example.ddd_tips.domain_service;

public class TransactionValidator {
    
    public boolean isValid(Money amount, Account from, Account to) {
        if(!from.getCurrency().equals(amount.getCurrency())) {
            return false;
        }

        if(!to.getCurrency().equals(amount.getCurrency())) {
            return false;
        }

        if(from.getBalance().isLessThan(amount)) {
            return false;
        }

        if(amount.isGreaterThan(someThreshold())) {
            return false;
        }
        return true;
    }

    private Money someThreshold() {
        return null;
    }
}
