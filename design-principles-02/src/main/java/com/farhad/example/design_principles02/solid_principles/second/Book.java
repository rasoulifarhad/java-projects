package com.farhad.example.design_principles02.solid_principles.second;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Book {
	private String name;
	private String authorName;
	private int year;
	private int price;
	private String isbn;
}
