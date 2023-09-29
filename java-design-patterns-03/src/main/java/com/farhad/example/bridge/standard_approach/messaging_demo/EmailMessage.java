package com.farhad.example.bridge.standard_approach.messaging_demo;

public class EmailMessage extends Message {

    public EmailMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send() {
        messageSender.sendMessage();
    }
    
}
