package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

import lombok.Value;

@Value
public class Payment {

	private Money amount;
	private Account account;

	private Payment(Money amountTendered) {
		this.amount = amountTendered;
		this.account = null;
	}

	private Payment(Money amountTendered, Account account) {
		this.amount = amountTendered;
		this.account = account;
	}

	public static Payment create(Money amountTendered) {
		return new Payment(amountTendered);
	}

	public void authorize() {
		
	}
}
