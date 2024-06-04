package com.farhad.example.let_play_tdd.finances;

public class SavingsAccountYear {

    private int startingBalance = 0;
    private int capitalGainsAmount = 0;
    private int interestRate = 0;
    
    public SavingsAccountYear() {
    }

    public SavingsAccountYear(int startingBalance, int interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public SavingsAccountYear(int startingBalance, int capitalGainsAmount, int interestRate) {
        this.startingBalance = startingBalance;
        this.capitalGainsAmount = capitalGainsAmount;
        this.interestRate = interestRate;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public int startingPrincipal() {
        return startingBalance - capitalGainsAmount;
    }

    public int interestRate() {
        return interestRate;
    }

    public int endingBalance() {
        return startingBalance + (startingBalance * interestRate / 100);
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate);
    }

    public void withdraw(int amount) {
        startingBalance -= amount;
    }

}
