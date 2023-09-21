package com.farhad.example.codekata.birthday_greetings_kata.refactored.application;

import java.time.LocalDate;

import com.farhad.example.codekata.birthday_greetings_kata.refactored.infrastructure.EmailMessageService;
import com.farhad.example.codekata.birthday_greetings_kata.refactored.infrastructure.repository.FileEmployeeRepository;

public class Main {
    private static final String EMPLOYEE_FILE = "employee_data.txt";

    public static void main(String[] args) {
        
        BirthdayService service = new BirthdayService(new FileEmployeeRepository(EMPLOYEE_FILE),
                            new EmailMessageService());
        service.sendGreetings(LocalDate.now());
    }
    

}
