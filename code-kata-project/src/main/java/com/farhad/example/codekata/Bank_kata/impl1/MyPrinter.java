package com.farhad.example.codekata.Bank_kata.impl1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MyPrinter implements Printer {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Display display;

    @Override
    public void print(Statement statement) {
        List<Movement> movements = statement.retrieveMovement();
        display.print("date  || credit  ||  debit  || balance");
        if(!movements.isEmpty()) {
            Movement movement = movements.get(0);
            display.print(formatDate(movement.getDate()) + " || " +
                          formatAmount(movement.credit()) + " || " +
                          formatAmount(movement.debit()) + " || " +
                          movement.getBalance());
        }
    }

    private String formatAmount(int amount) {
        return amount != 0 ? Integer.toString(amount) : "";
    }

    private String formatDate(LocalDate date) {
        return formatter.format(date);
    }
    
}
