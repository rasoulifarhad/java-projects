package com.farhad.example.codekata.birthday_greetings_kata.original;

import java.text.ParseException;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Employee {
  
	private XDate birthDate;
	private String lastName;
    
    @Getter
	private String firstName;

    @Getter
	private String email;
    
    public Employee(String firstName, String lastName, String birthDate, String email) throws ParseException {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = new XDate(birthDate);
		this.email = email;
	}    

    public boolean isBirthday(XDate today) {
        return today.isSameDay(birthDate);
    }
}
