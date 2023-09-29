package com.farhad.example.bridge.standard_approach.messaging_demo;

public class App {
    
    public static void main(String[] args) {
        MessageSender textMessageSender = new TextMessageSender();
        Message textMessage = new TextMessage(textMessageSender);
        textMessage.send();

        MessageSender emailMessageSender = new EmailMessageSender();
        Message emailMessage = new EmailMessage(emailMessageSender);
        emailMessage.send();
    }
}
