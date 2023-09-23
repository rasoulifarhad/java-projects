package com.farhad.example.codekata.Bank_kata.impl2.domain;

import static com.farhad.example.codekata.Bank_kata.impl2.domain.Amount.amountOf;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionTest {
    
    private final static String DATE_FORMAT = "dd/MM/yyyy";

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    @Mock PrintStream printer;

    @Test
    public void should_print_credit_trasanctionTest() {
        Transaction transaction = new Transaction(amountOf(1000), 
                        LocalDate.parse("10/01/2012", dateFormatter) );
        transaction.printTo(printer, amountOf(1000));
        Mockito.verify(printer).println("10/01/2012 | 1000.00  |          | 1000.00");
    }

    @Test
    public void should_print_debit_trasanctionTest() {
        Transaction transaction = new Transaction(amountOf(-1000), 
                        LocalDate.parse("10/01/2012", dateFormatter) );
        transaction.printTo(printer, amountOf(-1000));
        Mockito.verify(printer).println("10/01/2012 |          | 1000.00  | -1000.00");
    }

    @Test public void
	should_calculate_current_balance_after_deposit() {
		Transaction transaction = new Transaction(amountOf(1000), LocalDate.parse("10/01/2012", dateFormatter));
		
		Amount currentValue = transaction.balanceAfter(amountOf(100));
		
		assertThat(currentValue).isEqualTo(amountOf(1100));
	}

	@Test public void
	should_calculate_current_balance_after_withdrawal() {
		Transaction transaction = new Transaction(amountOf(-1000), LocalDate.parse("10/01/2012", dateFormatter));
		
		Amount currentValue = transaction.balanceAfter(amountOf(100));
		
		assertThat(currentValue).isEqualTo(amountOf(-900));
	}
	
	@Test public void
	should_be_equal_to_other_transaction_with_same_value_and_date() {
		LocalDate depositDate =LocalDate.parse("10/01/2012", dateFormatter);
		Transaction depositOfOneHundred = new Transaction(amountOf(1000), depositDate);
		Transaction anotherDepositOfOneHundred = new Transaction(amountOf(1000), depositDate);
		
		assertThat(depositOfOneHundred).isEqualTo(anotherDepositOfOneHundred);
	}
	    
}
