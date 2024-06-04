package com.farhad.example.let_play_tdd.finances;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SavingsAccountYearTest {
 
    @Test
    public void startingBalance() {
        assertEquals(10_000, newAccount().startingBalance());
    }

    @Test
    public void interestRate() {
        assertEquals(10, newAccount().interestRate());
    }

    @Test
    public void endingBalance() {
        assertEquals(11_000, newAccount().endingBalance());
    }

    @Test
    public void nextYearStartingBalanceShouldEqualThisYearEndingBalance() {
        assertEquals(newAccount().endingBalance(), newAccount().nextYear().startingBalance());
    }

    @Test
    public void nextYearInterestingRateEqualsThisYearIntrestingYear() {
        assertEquals(newAccount().interestRate(), newAccount().nextYear().interestRate());
    }

    private SavingsAccountYear newAccount() {
        SavingsAccountYear account = new SavingsAccountYear(10_000, 10);
        return account;
    } 

}
