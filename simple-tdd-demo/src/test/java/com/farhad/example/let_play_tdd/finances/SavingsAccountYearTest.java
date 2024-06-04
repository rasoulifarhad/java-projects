package com.farhad.example.let_play_tdd.finances;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SavingsAccountYearTest {
 
    @Test
    public void startingBalance() {
        SavingsAccountYear account = newAccount();
        assertEquals(10_000, account.startingBalance());
    }

    @Test
    public void interestRate() {
        SavingsAccountYear account = newAccount();
        assertEquals(10, account.interestRate());
    }

    @Test
    public void endingBalance() {
        SavingsAccountYear account = newAccount();
        assertEquals(11_000, account.endingBalance());
    }

    @Test
    public void nextYearStartingBalanceShouldEqualThisYearEndingBalance() {
        SavingsAccountYear thisYear = newAccount();
        assertEquals(thisYear.endingBalance(), thisYear.nextYear().startingBalance());
    }

    @Test
    public void nextYearInterestingRateEqualsThisYearIntrestingYear() {
        SavingsAccountYear thisYear = newAccount();
        assertEquals(thisYear.interestRate(), thisYear.nextYear().interestRate());
    }

    private SavingsAccountYear newAccount() {
        SavingsAccountYear account = new SavingsAccountYear(10_000, 10);
        return account;
    } 

}
