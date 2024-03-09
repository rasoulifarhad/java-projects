package com.farhad.example.code_smell.message_chains.smell;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Library {

	@Getter
	private List<Book> books;
}
