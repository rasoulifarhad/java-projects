package com.farhad.example.bridge.standard_approach.messaging_demo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Message {
    
    MessageSender messageSender;

    public abstract void send();

}
