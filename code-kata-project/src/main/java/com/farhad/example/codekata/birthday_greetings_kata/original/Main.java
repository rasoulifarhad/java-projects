package com.farhad.example.codekata.birthday_greetings_kata.original;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class Main {
    
	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
		BirthdayService service = new BirthdayService();
		service.sendGreetings("employee_data.txt", LocalDate.now(), "localhost", 25);
	}    
}
