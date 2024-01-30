package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

import lombok.Getter;

@Getter
public class Sale {

	private boolean isComplete;
	private List<SalesLineItem> lineItems;
	private Instant time;
	private Payment payment;

	public Sale() {
		lineItems = new ArrayList<>();
		isComplete = false;
		time = Instant.now();
	}


	public void makeLineItem(ProductDescription productDescription, int quantity) {
		lineItems.add(SalesLineItem.of(productDescription, quantity));
	}

	public void complete() {
		this.isComplete = true;
	}

	public Money getTotal() {
		return lineItems.stream()
			.map(SalesLineItem::getSubtotal)
				.reduce(Money.of("0.0"), (m1, m2) -> m1.add(m2));
			
	}


	public Payment makePayment(Money cashTendered) {
		this.payment = Payment.create(cashTendered);
		return this.payment;
	}

	public Money getBalance() {
		return payment.getAmount().minus(getTotal());
	}

	// remove that
	public String printReceipt() {
		StringBuilder receipt = new StringBuilder();
		for (SalesLineItem item : lineItems) {
			receipt.append(item.toString());
			receipt.append("\n");
		}
		receipt.append("Total:       " + getTotal() + "\n");
		receipt.append("Paid amount: " + payment.getAmount() + "\n");
		receipt.append("Balance:     " + getBalance());
		return receipt.toString();
	}
	
	public Money getTenderedAmountOfPayment() {
		return payment.getAmount();
	}

	public AccountHolder getAccountHolderOfPayment() {
		return payment.getAccount().getAccountHolder();
	}

}
