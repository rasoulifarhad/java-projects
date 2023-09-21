package com.farhad.example.codekata.birthday_greetings_kata.refactored.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class Employee {
    
	private LocalDate birthDate;
	private String lastName;
    
	private String firstName;

	private String email;
    
    public Employee(String firstName, String lastName, String birthDate, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
	    this.birthDate = LocalDate.parse(
							birthDate, 
							DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		this.birthDate = LocalDate.parse(
							birthDate, 
							DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		this.email = email;
	}    

    public boolean isBirthday(LocalDate today) {
		return birthDate.compareTo(today) == 0;
    }
   
}
