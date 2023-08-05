package com.farhad.example.designpatterns.anotherbuilder;

import java.time.Year;

import lombok.Getter;

// the Book class has two mandatory fields: ISBN, which refers to a book’s 10-digit or 13-digit International Standard 
// Book Number, and Title. All remaining fields are optional.
@Getter
public class Book {
	public enum Genre {
		oo,bb;
	}

	private final String isbn;
	private final String title;
	private final Genre genre;
	private final String author;
	private final Year published;
	private final String description;
	
	public Book(String isbn, String title) {
		this(isbn, title, null);
	}

	public Book(String isbn, String title, Genre genre) {
		this(isbn, title, genre, null);
	}

	public Book(String isbn, String title, Genre genre, String author) {
		this(isbn, title, genre, author, null);
	}

	public Book(String isbn, String title, Genre genre, String author, Year published) {
		this(isbn, title, genre, author, published, null);
	}

	public Book(String isbn, String title, Genre genre, String author, Year published, String description) {
		this.isbn = isbn;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.published = published;
		this.description = description;
	}


	

}
