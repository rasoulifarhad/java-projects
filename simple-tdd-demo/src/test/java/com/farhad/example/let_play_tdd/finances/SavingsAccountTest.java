package com.farhad.example.let_play_tdd.finances;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    @Test
    public void depositAndWithdrawal() {
        SavingsAccount account = new SavingsAccount();
        account.deposit(100);
        assertEquals( 100, account.balance(), "after deposit");
        account.withdraw(50);
        assertEquals(50, account.balance(),"after withdrawal");
    }

    @Test
    public void negativeBalanceIsJustified() {
        SavingsAccount account = new SavingsAccount();
        account.withdraw(75);
        assertEquals(-75, account.balance());
    }
}
