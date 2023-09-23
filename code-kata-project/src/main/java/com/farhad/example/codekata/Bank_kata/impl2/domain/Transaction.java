package com.farhad.example.codekata.Bank_kata.impl2.domain;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Transaction {
    
    private final static String DATE_FORMAT = "dd/MM/yyyy";
    private final static String EMPTY_DATE  = "          ";

    @EqualsAndHashCode.Exclude
    private DecimalFormat decimalFormater = new DecimalFormat("#.00");

    @EqualsAndHashCode.Exclude
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    private final Amount value;
    private final LocalDate date;

    public Transaction(Amount value, LocalDate date) {
        this.value = Objects.requireNonNull(value);
        this.date = Objects.requireNonNull(date);
    }

    public Amount balanceAfter(Amount currentBalance) {
        return currentBalance.plus(value);
    }

    public void printTo(PrintStream printer, Amount currentBalance) {
        StringBuilder builder = new StringBuilder();
        addDateTo(builder);
        addValueTo(builder);
        addCurrentBalanceTo(builder, currentBalance);
        printer.println(builder.toString());
    }

    private StringBuilder addCurrentBalanceTo(StringBuilder builder, Amount currentBalance) {
        builder.append("| ");
        return builder.append(currentBalance.toString());

    }

    private StringBuilder addValueTo(StringBuilder builder) {
        if(value.isGreaterThan(Amount.amountOf(0)) ) {
            return addCreditTo(builder);
        } 
        return addDebitTo(builder);
    }

    private StringBuilder addDebitTo(StringBuilder builder) {
        builder.append(EMPTY_DATE);
        builder.append("|");
        return builder.append(formatedValue());
    }

    private String formatedValue() {
        return String.format("%-10s"," " + value.absValue().toString());
    }

    private StringBuilder addCreditTo(StringBuilder builder) {
        builder.append(formatedValue());
        builder.append("|");
        return builder.append(EMPTY_DATE);
    }

    private StringBuilder addDateTo(StringBuilder builder) {
        builder.append(dateFormatter.format(date));
        return builder.append(" |");
    }

    
}
