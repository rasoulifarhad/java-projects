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
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class AccountTest {
    
    private final static String DATE_FORMAT = "dd/MM/yyyy";

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    @Mock private  Statement statement;

    private Account account;

    @BeforeEach
    public void initialise() {
		account = new Account(statement);
	}
    
	@Test 
    public void should_add_deposit_line_to_statement() {
		LocalDate depositDate =LocalDate.parse("10/01/2012", dateFormatter);
		Amount depositAmount = amountOf(1000);
		
		account.deposit(depositAmount, depositDate);
		
		verify(statement).addLine(aTransaction()
												.with(depositDate)
												.with(depositAmount).build(),
											currentBalanceEqualsTo(depositAmount));
	}
	
	@Test 
    public void should_add_withdraw_line_to_statement() {
		LocalDate withdrawalDate = LocalDate.parse("10/01/2012", dateFormatter);
		
		account.withdrawal(amountOf(500), withdrawalDate);
		
		verify(statement).addLine(aTransaction()
											.with(amountOf(-500))
											.with(withdrawalDate).build(), 
											amountOf(-500));
	}
	
	@Test 
    public void should_print_statement() {
		PrintStream printer = System.out;
		
		account.printStatement(printer);
		
		verify(statement).printTo(printer);
	}
	
	private Amount currentBalanceEqualsTo(Amount amount) {
		return amount;
	}    
}
