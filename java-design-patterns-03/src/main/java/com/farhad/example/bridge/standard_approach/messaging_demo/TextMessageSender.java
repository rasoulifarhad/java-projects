package com.farhad.example.bridge.standard_approach.messaging_demo;

public class TextMessageSender implements MessageSender {

    @Override
    public void sendMessage() {
        System.out.println("TextMessageSender: Sending text message...");    }
    
}
