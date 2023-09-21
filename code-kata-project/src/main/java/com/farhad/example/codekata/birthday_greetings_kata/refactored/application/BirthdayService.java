package com.farhad.example.codekata.birthday_greetings_kata.refactored.application;

import java.time.LocalDate;
import java.util.List;

import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.Employee;
import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.EmployeeRepository;
import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.Greeting;
import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.MessageService;

public class BirthdayService {
    private EmployeeRepository  employeeRepository;
    private MessageService  messageService;

    
    public BirthdayService(EmployeeRepository employeeRepository, MessageService messageService) {
        this.employeeRepository = employeeRepository;
        this.messageService = messageService;
    }


    public void sendGreetings(LocalDate today) {
        List<Employee> employees = employeeRepository.findEmployeesWhoseBirthdayIs(today);
        for (Employee employee : employees) {
            Greeting greetings = new Greeting(employee);
            messageService.send(greetings);
        }
    }
}
