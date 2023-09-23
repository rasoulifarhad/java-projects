package com.farhad.example.codekata.Bank_kata.impl2.domain;

import static com.farhad.example.codekata.Bank_kata.impl2.builders.TransactionBuilder.aTransaction;
import static com.farhad.example.codekata.Bank_kata.impl2.domain.Amount.amountOf;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class StatementTest {
  
   private final static String DATE_FORMAT = "dd/MM/yyyy";

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);    

    
	@Mock PrintStream printer;
	@Mock Transaction transaction;

	private Statement statement;
	
	@BeforeEach
	public void initialise() {
		statement = new Statement();
	}
	
	@Test 
    public void should_print_statement_header() {
		statement.printTo(printer);
		
		verify(printer).println(Statement.STATEMENT_HEADER);
	}
	
	@Test 
    public void should_print_deposit() {
		statement.addLine(aTransaction()
										.with(amountOf(1000))
										.with(LocalDate.parse("10/01/2012", dateFormatter)).build(), 
										amountOf(1000));
		
		statement.printTo(printer);
		
		verify(printer).println("10/01/2012 | 1000.00  |          | 1000.00");
	}
	
	@Test 
    public void should_print_withdrawal() {
		statement.addLine(aTransaction()
										.with(amountOf(-1000))
										.with(LocalDate.parse("10/01/2012", dateFormatter)).build(), 
										amountOf(-1000));
		
		statement.printTo(printer);
		
		verify(printer).println("10/01/2012 |          | 1000.00  | -1000.00");
	}
	
	@Test 
    public void should_print_two_deposits_in_reverse_order() {
		statement.addLine(aTransaction()
										.with(amountOf(1000))
										.with(LocalDate.parse("10/01/2012", dateFormatter)).build(), 
										amountOf(1000));
		statement.addLine(aTransaction()
										.with(amountOf(2000))
										.with(LocalDate.parse("13/01/2012", dateFormatter)).build(), 
										amountOf(3000));
		
		statement.printTo(printer);
		
		InOrder inOrder = Mockito.inOrder(printer);
		inOrder.verify(printer).println("13/01/2012 | 2000.00  |          | 3000.00");
		inOrder.verify(printer).println("10/01/2012 | 1000.00  |          | 1000.00");
		
	}    
}
