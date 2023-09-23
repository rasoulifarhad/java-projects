package com.farhad.example.codekata.Bank_kata.impl2.domain;

import static com.farhad.example.codekata.Bank_kata.impl2.builders.TransactionBuilder.aTransaction;
import static com.farhad.example.codekata.Bank_kata.impl2.domain.Amount.amountOf;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class StatementLineTest {

   private final static String DATE_FORMAT = "dd/MM/yyyy";

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);    
	
	@Mock PrintStream printer;
	
	@Test 
    public void should_print_itself() {
		StatementLine statementLine = new StatementLine(
											aTransaction()
												.with(amountOf(1000))
												.with(LocalDate.parse("10/01/2012", dateFormatter)).build(),
											amountOf(1000));
		
		statementLine.printTo(printer);
		
		verify(printer).println("10/01/2012 | 1000.00  |          | 1000.00");
	}
	
	@Test 
    public void should_print_withdrawal() {
		StatementLine statementLine = new StatementLine(
											aTransaction()
												.with(amountOf(-1000))
												.with(LocalDate.parse("10/01/2012", dateFormatter)).build(), 
											amountOf(-1000));
		
		statementLine.printTo(printer);
		
		verify(printer).println("10/01/2012 |          | 1000.00  | -1000.00");
	}
	    
}
