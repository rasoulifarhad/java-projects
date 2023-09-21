package com.farhad.example.codekata.birthday_greetings_kata.refactored.application;

import java.util.ArrayList;
import java.util.List;

import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.GreetingMessage;
import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.MessageService;

import lombok.Getter;

public class ListMessageService  implements MessageService {
    
    @Getter
    List<GreetingMessage> sentGreetingMessages = new ArrayList<>();

    @Override
    public void send(GreetingMessage greetingMessage) {
        sentGreetingMessages.add(greetingMessage);
    }

    @Override
    public void send(List<GreetingMessage> greetingMessages) {
        greetingMessages.addAll(greetingMessages);
    }
    
}
