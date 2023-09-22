package com.farhad.example.codekata.Bank_kata.impl2.domain;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class Statement {
    
    private static final int TOP_OF_THE_LIST = 0;
    private List<StatementLine> statementLines = new LinkedList<>();

    public void addLine(Transaction transaction, Amount currentBalance) {
        statementLines.add(TOP_OF_THE_LIST, new StatementLine(transaction, currentBalance));
    }

    public void printTo(PrintStream printer) {
        printHeader(printer);
        printLines(printer);
    }

    private void printHeader(PrintStream printer) {
        printer.println("date       | credit   | debit    | balance");
    }

    private void printLines(PrintStream printer) {
        statementLines.forEach(line -> line.printTo(printer));
    }
}
