package com.farhad.example.let_play_tdd.finances;

public class Main {

    public static void main(String[] args) {
        SavingsAccountYear account = new SavingsAccountYear(10_000, 10);
        account.deposit(10_000);
        for (int i = 0; i < 60; i++) {
            System.out.println(i + ": $" + account.balance());
            account = account.nextYear();
        }
    }
}