package com.farhad.example.design_principles02.composition;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class Library {

	private final List<Book> books;

	public List<Book> getTotalBooksInLibrary() {
		return books;
	}	
}
