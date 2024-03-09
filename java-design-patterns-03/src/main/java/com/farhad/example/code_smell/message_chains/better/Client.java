package com.farhad.example.code_smell.message_chains.better;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		
		String authorName = getAuthorNameOfFirstBook();
		System.out.println("Author name: " + authorName);
	}

	private static String getAuthorNameOfFirstBook() {
		Library library = getLibrary();
		if (library == null || library.isEmpty()) {
			throw new IllegalStateException("No books found in the library");
		}

		Book firstBook = library.firstBook();
		if (firstBook == null || !firstBook.hasAuthor()) {
			throw new IllegalStateException("No author found for the first book");
		}
		return firstBook.getAuthor().getName();
	}

	private static Library getLibrary() {
		List<Book> books = new ArrayList<>();

		books.add(new Book("Book Title #1", new Author("Author #1")));
		books.add(new Book("Book Title #2", new Author("Author #2")));
		books.add(new Book("Book Title #3", new Author("Author #3")));
		return new Library(books);
		
	}
}
