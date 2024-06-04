package com.farhad.example.let_play_tdd.finances;

public class SavingsAccountYear {

    private int startingBalance;
    private int interestRate;
    
    public SavingsAccountYear() {
        this.startingBalance = 0;
        this.interestRate = 0;
    }

    public SavingsAccountYear(int startingBalance, int interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public void deposit(int amount) {
        startingBalance += amount;
    }

    public int balance() {
        return startingBalance;
    }

    public void withdraw(int amount) {
        startingBalance -= amount;
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), 0);
    }

    public int endingBalance() {
        return balance() + (balance() * interestRate / 100);
    }


}
