package com.farhad.example.let_play_tdd.finances;

public class Main {

    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount();
        account.deposit(10_000);
        for (int i = 0; i < 60; i++) {
            System.out.println(i + ": $" + account.balance());
            account = account.nextYear(10);
        }
    }
}
