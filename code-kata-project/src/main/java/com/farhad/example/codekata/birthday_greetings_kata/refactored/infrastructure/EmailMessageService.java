package com.farhad.example.codekata.birthday_greetings_kata.refactored.infrastructure;

import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.Greeting;
import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.MessageService;

public class EmailMessageService implements MessageService {

    private static final String SENDER_EMAIL_ADDRESS = "sender@here.com";
    private static final String HOST = "localhost";
    private static final int SMTP_PORT = 25;
        
    @Override
    public void send(Greeting greetings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'send'");
    }
    
}
