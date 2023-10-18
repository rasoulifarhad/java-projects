package com.farhad.example.design_principles02.another_solid_principles.dip.violates_dip;

public class Shelf {

	Book book;
	DVD dvd;

	void addBook(Book book) {
		this.book = book;
	}

	void addDVD(DVD dvd) {
		this.dvd = dvd;
	}

	void customizeShelf() {

	}
}
