package com.farhad.example.designpatterns.anotherbuilder;

import java.time.Year;

import lombok.Getter;
import lombok.ToString;

// the Book class has two mandatory fields: ISBN, which refers to a book’s 10-digit or 13-digit International Standard 
// Book Number, and Title. All remaining fields are optional.
@Getter
@ToString
public class Book {
	public enum Genre {
		ADVENTURE_FICTION,UNKNOWN;
	}

	private final String isbn;
	private final String title;
	private final Genre genre;
	private final String author;
	private final Year published;
	private final String description;
	
	// public Book(String isbn, String title) {
	// 	this(isbn, title, null);
	// }

	// public Book(String isbn, String title, Genre genre) {
	// 	this(isbn, title, genre, null);
	// }

	// public Book(String isbn, String title, Genre genre, String author) {
	// 	this(isbn, title, genre, author, null);
	// }

	// public Book(String isbn, String title, Genre genre, String author, Year published) {
	// 	this(isbn, title, genre, author, published, null);
	// }

	// public Book(String isbn, String title, Genre genre, String author, Year published, String description) {
	// 	this.isbn = isbn;
	// 	this.title = title;
	// 	this.genre = genre;
	// 	this.author = author;
	// 	this.published = published;
	// 	this.description = description;
	// }

	private Book(Builder builder) {
		this.isbn = builder.isbn;
		this.title = builder.title;
		this.genre = builder.genre;
		this.author = builder.author;
		this.published = builder.published;
		this.description = builder.description;
	}


	public static class Builder {

		private final IsbnValidator isbnValidator = new IsbnValidator(); 
		private final String isbn;
		private final String title;
		private Genre genre;
		private String author;
		private Year published;
		private String description;

		public Builder(String isbn, String title) {
			this.isbn = isbn;
			this.title = title;
		}

		public Builder genre(Genre genre) {
			this.genre = genre;
			return this;
		}

		public Builder author(String author) {
			this.author = author;
			return this;
		}

		public Builder published(Year year) {
			this.published = year;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Book build() throws IllegalStateException {
			validate();
			return new Book(this);
		}

		private void validate() throws IllegalStateException {
			MessageBuilder mb = new MessageBuilder();
			if( isbn == null ) {
				mb.append("ISBN must not be null.");
			} else if (!isbnValidator.isValid(isbn)) {
				mb.append("Invalid ISBN!");
			}

			if (title == null) {
				mb.append("Title must not be null.");
			} else if (title.length() < 2 ) {
				mb.append("Title must have at least 2 characters.");
			} else if (title.length() > 100 ) {
				mb.append( "Title can not have more than 100 characters.");
			}

			if (author != null && author.length() > 50 ) {
				mb.append("Author cannot have more than 50 characters.");
			}
			if (published != null && published.isAfter(Year.now())) {
				mb.append("Year published cannot be greater than current year.");
			}
			if (description != null && description.length() > 500 ) {
				mb.append("Description cannot have more than 500 characters.");
			}

			if ( mb.length() > 0 ) {
				throw new IllegalStateException(mb.toString());
			}
		}
	}

	public static void main(String[] args) {
		Book book = new Book.Builder("0-12-345678-9", "Moby-Dick")
							.genre(Genre.ADVENTURE_FICTION) 
							.author("Herman Melville")
							.published(Year.of(1851))
							.description("blah blahhhhhh")
							.build();
		System.out.println(book);	
		
		
		Book.Builder bookBuilder = new Book.Builder("0-12-345678-9", "Moby-Dick")
							.genre(Genre.ADVENTURE_FICTION) 
							.author("Herman Melville")
							.published(Year.of(1851))
							.description("blah blahhhhhh");

		Book firstEdition = bookBuilder.build();
		Book secondEdition = bookBuilder
								.published(Year.of(1952))
								.build();

		System.out.println(firstEdition);
		System.out.println(secondEdition);

		// Note: Since the ISBN field is final and, therefore, must be set via the Builder’s constructor. 

		try {
			Book book2 = new Book.Builder("0-12-345678-9", "M")
								.genre(Genre.ADVENTURE_FICTION) 
								.author("Herman Melville")
								.published(Year.of(1851))
								.description("blah blahhhhhh")
								.build();
		} catch (Exception e) {
			System.out.println(e);
		}
					
	}
	

}
