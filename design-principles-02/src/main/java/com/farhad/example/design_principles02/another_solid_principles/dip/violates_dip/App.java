package com.farhad.example.design_principles02.another_solid_principles.dip.violates_dip;

// Suppose a book store asked us to build a new feature that enables customers to put their favorite books on a shelf.
// The Book class will allow users to see reviews and read a sample of each book they store on their shelves.
// The Shelf class will let them add a book to their shelf and customize the shelf. 

public class App {
	
	public static void main(String[] args) {
		Shelf myShelf = new Shelf();

		Book book_01 = new Book();

		// high-level Shelf class depends on the low-level Book
		myShelf.addBook(book_01);

		// Store asks us to enable customers to add DVDs to their shelves, too
		
		DVD dvd_01 = new DVD();
		myShelf.addDVD(dvd_01);

		


	}
}
