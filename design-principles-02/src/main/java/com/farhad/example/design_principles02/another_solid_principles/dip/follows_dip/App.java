package com.farhad.example.design_principles02.another_solid_principles.dip.follows_dip;

public class App {


	public static void main(String[] args) {
		
		Shelf myShelf = new Shelf();
		Book book_01 = new Book();
		myShelf.addProduct(book_01);
		DVD dvd_01 = new DVD();
		myShelf.addProduct(dvd_01);

		Reader keyboard = new Keyboard();
		Writer printer = new Printer();
		
		CharCopier charCopier = new CharCopier();
		charCopier.copy(keyboard, printer);

	}
}
