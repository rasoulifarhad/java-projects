package com.farhad.example.codekata.birthday_greetings_kata.refactored.core;

public class CannotReadEmployeesException extends RuntimeException {

    public CannotReadEmployeesException(String message, Exception e) {
        super(message, e);
    }
    
}
