package com.farhad.example.let_play_tdd.finances;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SavingsAccountYearTest {
 
    @Test
    public void startingBalance() {
        SavingsAccountYear account = new SavingsAccountYear(10_000, 10);
        assertEquals(10_000, account.startingBalance());
    }
    @Test
    public void endingBalance() {
        SavingsAccountYear account = new SavingsAccountYear(10_000, 10);
        assertEquals(11_000, account.endingBalance());
    }

    @Test
    @Disabled
    public void nextYearStartingBalanceShouldEqualThisYearEndingBalance() {
        SavingsAccountYear account = new SavingsAccountYear(10_000, 10);
        assertEquals(account.endingBalance(), account.nextYear().startingBalance());
    }


}