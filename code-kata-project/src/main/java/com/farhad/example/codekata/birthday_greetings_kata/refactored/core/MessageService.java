package com.farhad.example.codekata.birthday_greetings_kata.refactored.core;

import java.util.List;

public interface MessageService {

    void send(GreetingMessage greetingMessage);

    void send(List<GreetingMessage> greetingMessages);

}
