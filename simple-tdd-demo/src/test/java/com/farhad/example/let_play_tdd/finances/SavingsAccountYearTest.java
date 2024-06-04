package com.farhad.example.let_play_tdd.finances;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SavingsAccountYearTest {

    @Test
    public void depositAndWithdrawal() {
        SavingsAccountYear account = new SavingsAccountYear();
        account.deposit(100);
        assertEquals( 100, account.balance(), "after deposit");
        account.withdraw(50);
        assertEquals(50, account.balance(),"after withdrawal");
    }

    @Test
    public void negativeBalanceIsJustified() {
        SavingsAccountYear account = new SavingsAccountYear();
        account.withdraw(75);
        assertEquals(-75, account.balance());
    }

    @Test
    public void nextYear() {
        SavingsAccountYear account = new SavingsAccountYear();
        account.deposit(10000);
        SavingsAccountYear nextYear = account.nextYear(10);
        assertEquals(11000, nextYear.balance());
    }

    @Test
    public void endingBalance() {
        SavingsAccountYear account = new SavingsAccountYear(10_000, 10);
        assertEquals(11_000, account.endingBalance());
    }
}
