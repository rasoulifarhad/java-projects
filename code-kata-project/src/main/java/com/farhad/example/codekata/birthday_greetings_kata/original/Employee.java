package com.farhad.example.codekata.birthday_greetings_kata.original;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Employee {
  
	private LocalDate birthDate;
	private String lastName;
    
    @Getter
	private String firstName;

    @Getter
	private String email;
    
    public Employee(String firstName, String lastName, String birthDate, String email) throws ParseException {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = LocalDate.parse(
							birthDate, 
							DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		this.email = email;
	}    

    public boolean isBirthday(LocalDate today) {
		return birthDate.compareTo(today) == 0;
    }
}
