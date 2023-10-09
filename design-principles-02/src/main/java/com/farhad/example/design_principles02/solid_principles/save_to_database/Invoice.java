package com.farhad.example.design_principles02.solid_principles.save_to_database;

import lombok.Getter;

@Getter
public class Invoice {
	
	private Book book;
	private int quantity;
	private double discountRate;
	private double taxRate;
	private double total;
	
	public Invoice(Book book, int quantity, double discountRate, double taxRate) {
		this.book = book;
		this.quantity = quantity;
		this.discountRate = discountRate;
		this.taxRate = taxRate;
		this.total = calculateTotal();
	}

	public double calculateTotal() {
		double price = (book.getPrice() - book.getPrice() * discountRate) * this.quantity;
		return price * (1 + taxRate);
	}

}
