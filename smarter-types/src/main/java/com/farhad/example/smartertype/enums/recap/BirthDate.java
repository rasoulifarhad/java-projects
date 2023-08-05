package com.farhad.example.smartertype.enums.recap;

public record BirthDate(Month month, Day day, Year year) {
	
	public BirthDate {
		month.checkDay(day);
	}
}
