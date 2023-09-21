package com.farhad.example.codekata.birthday_greetings_kata.refactored.core;

public class Greeting {

    private final String header;
    private final String content;
    
    public Greeting(String header, String content) {
        this.header = header;
        this.content = content;
    }

    public String header() {
        return header;
    }

    public String content() {
        return content;
    }
    
    static Greeting forBirthdayOf(Employee employee) {
        String content = String.format("Happy Birthday, dear %s!", employee.getFirstName());
        String header = "Happy Birthday!";
        return new Greeting(header, content);    
    }
    
}
