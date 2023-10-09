package com.farhad.example.design_principles02.solid_principles.first;

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

	public void printInvoice() {
		System.out.println(quantity + "x " + book.getName() + " " +          book.getPrice() + "$");
		System.out.println("Discount Rate: " + discountRate);
		System.out.println("Tax Rate: " + taxRate);
		System.out.println("Total: " + total);
	}

	public void saveToFile(String filename) {
		
	}

	
}
