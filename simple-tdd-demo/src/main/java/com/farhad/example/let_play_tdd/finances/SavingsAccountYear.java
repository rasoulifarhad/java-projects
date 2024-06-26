package com.farhad.example.let_play_tdd.finances;

import static java.lang.Math.max;

public class SavingsAccountYear {

    private int startingBalance = 0;
    private int capitalGainsAmount = 0;
    private int interestRate = 0;
    private int totalWithdrawn = 0;
    private int startingPrincipal;
    
    public SavingsAccountYear() {
    }

    public SavingsAccountYear(int startingBalance, int interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public SavingsAccountYear(int startingBalance, int startingPrincipal, int interestRate) {
        this.startingBalance = startingBalance;
        this.startingPrincipal = startingPrincipal;
        this.capitalGainsAmount = startingBalance - startingPrincipal;
        this.interestRate = interestRate;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public int startingPrincipal() {
        return this.startingPrincipal;
    }

    public int interestRate() {
        return interestRate;
    }

    public int totalWithdrawn() {
        return this.totalWithdrawn;
    }

    public int endingPrincipal() {
        int result = this.startingPrincipal() - totalWithdrawn() ;
        return max(0, result);
    }

    public int endingBalance(int capitalGainsTaxRate) {
        int modifiedStart = startingBalance - totalWithdrawn() - capitalGainsTaxIncurred(capitalGainsTaxRate);

        return modifiedStart + (modifiedStart * interestRate / 100);
    }

    public SavingsAccountYear nextYear(int capitalGainsTaxRate) {
        return new SavingsAccountYear(this.endingBalance(capitalGainsTaxRate), interestRate);
    }

    public void withdraw(int amount) {
        this.totalWithdrawn += amount;
        // startingBalance -= amount;
    }

    public int capitalGainsWithdrawn() {
        int result = (startingPrincipal() - totalWithdrawn()) * -1;
        return max(0, result);
    }

    public Integer capitalGainsTaxIncurred(int taxRate) {
        return this.capitalGainsWithdrawn() * taxRate / 100;
    }

}
