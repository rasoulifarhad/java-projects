package com.farhad.example.let_play_tdd.finances;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SavingsAccountYearTest {
 
    @Test
    public void startingBalanceMatchesConstructor() {
        assertEquals(10_000, newAccount().startingBalance());
    }

    @Test
    public void interestRateMatchesConstructor() {
        assertEquals(10, newAccount().interestRate());
    }

    @Test
    public void endingBalanceAppliesInterestRate() {
        assertEquals(11_000, newAccount().endingBalance(25));
    }

    @Test
    public void nextYearStartingBalanceEqualsThisYearEndingBalance() {
        assertEquals(newAccount().endingBalance(25), newAccount().nextYear(25).startingBalance());
    }

    @Test
    public void nextYearInterestingRateEqualsThisYearIntrestingYear() {
        assertEquals(newAccount().interestRate(), newAccount().nextYear(25).interestRate());
    }

    @Test
    @Disabled
    public void withdrawingFundsOccursAtBeginingOfTheYear() {
        SavingsAccountYear year = new SavingsAccountYear(10_000, 10);
        year.withdraw(1000);
        assertEquals(9900, year.endingBalance(25));
    }

    @Test
    public void multipleWithdrawalsInAYear() {
        SavingsAccountYear year = new SavingsAccountYear(10_000, 10);
        year.withdraw(1000);
        year.withdraw(2000);
        assertEquals(3000, year.totalWithdrawn());
    }

    @Test
    public void startingPrincipal() {
        SavingsAccountYear year = new SavingsAccountYear(10_000, 3000, 10);
        assertEquals(3000, year.startingPrincipal());
    }

    @Test
    public void endingPrincipal() {
        SavingsAccountYear year = new SavingsAccountYear(10_000, 3000, 10);
        year.withdraw(4000);
        assertEquals(0, year.endingPrincipal(), "Ending principal");
    }

    @Test
    public void endingPrincipalNeverGoesBelowZero() {
        SavingsAccountYear year = new SavingsAccountYear(10_000, 3000, 10);
        year.withdraw(2000);
        assertEquals(1000, year.endingPrincipal(), "Ending principal");


    }

    @Test
    public void capitalGainsWithdrawn(){
        SavingsAccountYear year = new SavingsAccountYear(10_000, 3000, 10);
        year.withdraw(1000);
        assertEquals(0,year.capitalGainsWithdrawn());
        year.withdraw(3000);       
        assertEquals(1000,year.capitalGainsWithdrawn());
    }

    @Test
    public void capitalGainsTaxIncurred() {
        SavingsAccountYear year = new SavingsAccountYear(10_000, 3000, 10);
        year.withdraw(5000);
        assertEquals(2000, year.capitalGainsWithdrawn());
        assertEquals(500, year.capitalGainsTaxIncurred(25));
    }

    @Test
    public void capitalGainsTaxIsIncludedInEndingBalance() {
        SavingsAccountYear year = new SavingsAccountYear(10_000, 3000, 10);
        year.withdraw(5000);
        assertEquals(2000, year.capitalGainsWithdrawn());
        assertEquals(10000 - 5000 - 500 + 450, year.endingBalance(25));
        // TODO: need  to withdraw enough money to cover capital gains tax; that money  will also be taxed 
    }

    @Test
    @Disabled
    public void withdrawingMoreThanPrincipalIncursCapitalGainsTax() {
        SavingsAccountYear year = new SavingsAccountYear(10_000, 3000, 10);
        year.withdraw(3000);
        assertEquals(7700, year.endingBalance(25));
        year.withdraw(5000);
        assertEquals(2000 + 200 - (1250) , year.endingBalance(25));
    }

    private SavingsAccountYear newAccount() {
        SavingsAccountYear account = new SavingsAccountYear(10_000, 10);
        return account;
    } 

    // Let's Play TDD #7: Tax Rage
}
