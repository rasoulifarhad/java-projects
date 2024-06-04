package com.farhad.example.let_play_tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    @Test
    public void deposit() {
        SavingsAccount account = new SavingsAccount();
        account.deposit(100);
        assertEquals( 100, account.balance(), "after deposit");
    }
}
