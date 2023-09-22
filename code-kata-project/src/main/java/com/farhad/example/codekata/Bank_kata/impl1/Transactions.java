package com.farhad.example.codekata.Bank_kata.impl1;

import java.util.List;

public interface Transactions {

    public void save(int amount);

    public List<Transaction> retrieve();

}
