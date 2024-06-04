package com.farhad.example.let_play_tdd.finances;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SavingsAccountYearTest {
 
    @Test
    public void startingBalance() {
        SavingsAccountYear account = createAccount();
        assertEquals(10_000, account.startingBalance());
    }

    @Test
    public void interestRate() {
        SavingsAccountYear account = createAccount();
        assertEquals(10, account.interestRate());
    }

    @Test
    public void endingBalance() {
        SavingsAccountYear account = createAccount();
        assertEquals(11_000, account.endingBalance());
    }

    @Test
    public void nextYearStartingBalanceShouldEqualThisYearEndingBalance() {
        SavingsAccountYear thisYear = createAccount();
        assertEquals(thisYear.endingBalance(), thisYear.nextYear().startingBalance());
    }

    @Test
    public void nextYearInterestingRateEqualsThisYearIntrestingYear() {
        SavingsAccountYear thisYear = createAccount();
        assertEquals(thisYear.interestRate(), thisYear.nextYear().interestRate());
    }

    private SavingsAccountYear createAccount() {
        SavingsAccountYear account = new SavingsAccountYear(10_000, 10);
        return account;
    } 

}
