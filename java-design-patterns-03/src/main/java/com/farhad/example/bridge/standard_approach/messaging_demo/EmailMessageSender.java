package com.farhad.example.bridge.standard_approach.messaging_demo;

public class EmailMessageSender implements MessageSender {

    @Override
    public void sendMessage() {
        System.out.println("EmailMessageSender: Sending email message...");    
    }
    
}
