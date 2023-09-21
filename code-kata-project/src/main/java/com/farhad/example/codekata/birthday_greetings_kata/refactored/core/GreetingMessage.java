package com.farhad.example.codekata.birthday_greetings_kata.refactored.core;

import static java.util.stream.Collectors.toList;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GreetingMessage {
    
    private String to;
    private Greeting greeting;

    public static List<GreetingMessage> generateForSome(List<Employee> employees) {
        return employees.stream()
                    .map(GreetingMessage::generateFor)
                    .collect(toList());
    }

    public static GreetingMessage generateFor(Employee employee) {
        Greeting greeting = Greeting.forBirthdayOf(employee);
        return new GreetingMessage(employee.getEmail(), greeting);
    }

    public String subject() {
        return greeting.header();
    }

    public String text() {
        return greeting.content();
    }

    public String to() {
        return this.to;
    }
}
