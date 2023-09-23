package com.farhad.example.codekata.Bank_kata.impl2.domain;

import static com.farhad.example.codekata.Bank_kata.impl2.domain.Amount.amountOf;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AmountTest {
   
	
	@Test 
    public void should_be_equal_to_another_instance_containing_same_amount() {
		Amount oneHundred = new Amount(100);
		Amount anotherOneHundred = new Amount(100);
		
		assertThat(oneHundred).isEqualTo(anotherOneHundred);
	}

	@Test 
    public void should_be_different_from_another_instance_containing_different_amount() {
		Amount ten = new Amount(10);
		Amount five = new Amount(5);
		
		assertThat(ten).isNotEqualTo(five);
	}
	
	@Test 
    public void should_statically_initialise_an_amount() {
		assertThat(new Amount(10)).isEqualTo(amountOf(10));
	}
	
	@Test 
    public void should_sum_up_amounts() {
		Amount ten = amountOf(10);
		Amount five = amountOf(5);
		Amount fifteen = amountOf(15);
		
		assertThat(fifteen).isEqualTo(ten.plus(five));
	}
	
	@Test 
    public void should_indicate_when_it_is_greater_than_other_amount() {
		Amount ten = amountOf(10);
		Amount five = amountOf(5);
		
		assertThat(ten.isGreaterThan(five)).isTrue();
	}
	
	@Test 
    public void should_indicate_when_it_is_not_greater_than_other_amount() {
		Amount ten = amountOf(10);
		Amount five = amountOf(5);
		
		assertThat(five.isGreaterThan(ten)).isFalse();
	}
	
	@Test 
    public void should_return_the_absolute_value() {
		Amount minusFive = amountOf(-5);
		
		assertThat(amountOf(5)).isEqualTo(minusFive.absValue());
	}
	
	@Test 
    public void should_return_the_negative_value() {
		Amount five = amountOf(5);
		
		assertThat(amountOf(-5)).isEqualTo(five.negative());
	}
	
	@Test 
    public void should_return_money_representation() {
		Amount oneThousand = amountOf(1000);
		
		assertThat("1000.00").isEqualTo(oneThousand.toString());
	}
	    
}
