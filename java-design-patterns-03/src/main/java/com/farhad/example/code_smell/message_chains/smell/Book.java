package com.farhad.example.code_smell.message_chains.smell;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Book {

	private String title;
	private Author author;
}
