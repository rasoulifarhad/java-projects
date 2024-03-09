package com.farhad.example.code_smell.message_chains.better;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Library {

	@Getter
	private List<Book> books;

	public boolean isEmpty() {
		return books.isEmpty();
	}

	public Book firstBook() {
		return books.get(0);
	}
}
