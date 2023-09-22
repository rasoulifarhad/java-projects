package com.farhad.example.codekata.Bank_kata.impl1.unit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.farhad.example.codekata.Bank_kata.impl1.Account;
import com.farhad.example.codekata.Bank_kata.impl1.Printer;
import com.farhad.example.codekata.Bank_kata.impl1.Statement;
import com.farhad.example.codekata.Bank_kata.impl1.Transaction;
import com.farhad.example.codekata.Bank_kata.impl1.Transactions;

public class AccountTest {

    @Test
    public void deposit_amount() {
        //given
        Transactions transactions = mock(Transactions.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactions, printer);
        int amount = 1000;
        //when
        account.deposit(amount);
        //then
        verify(transactions).save(amount);
    }

    @Test
    public void eithdraw_amount() {
        //given
        Transactions transactions = mock(Transactions.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactions, printer);
        int amount = 1000;
        //when
        account.withdraw(amount);
        //then
        verify(transactions).save(-amount);
    }

    @Test
    public void print_statement() {
        //given
        Transactions transactions = mock(Transactions.class);
        Printer printer = mock(Printer.class);
        List<Transaction> transactionsList = Collections.emptyList();
        when(transactions.retrieve()).thenReturn(transactionsList);

        Statement statement = new Statement(transactionsList);
        Account account = new Account(transactions, printer);
        //when
        account.printStatement();
        //then
        verify(transactions).retrieve();
        verify(printer).print(statement);
    }    
}
