package com.farhad.example.let_play_tdd.finances;

public class SavingsAccountYear {

    private int balance;
    private int interestRate;
    
    public SavingsAccountYear() {
        this.balance = 0;
        this.interestRate = 0;
    }

    public SavingsAccountYear(int startingBalance, int interestRate) {
        this.balance = startingBalance;
        this.interestRate = interestRate;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int balance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public SavingsAccountYear nextYear(int interestRate) {
        SavingsAccountYear result = new SavingsAccountYear();
        result.deposit(balance() + (balance() * interestRate / 100));
        return result;
    }

    public int endingBalance() {
        return balance() + (balance() * interestRate / 100);
    }

}
