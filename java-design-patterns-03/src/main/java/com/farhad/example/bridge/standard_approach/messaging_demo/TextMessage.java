package com.farhad.example.bridge.standard_approach.messaging_demo;

public class TextMessage extends Message {

    public TextMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send() {
        messageSender.sendMessage();
    }
    
}
