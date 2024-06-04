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

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate);
    }

    public int endingBalance() {
        return startingBalance + (startingBalance * interestRate / 100);
    }

    public int interestRate() {
        return interestRate;
    }


}
