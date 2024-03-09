package com.farhad.example.another_bridge.demo4;

import lombok.RequiredArgsConstructor;

//This is an abstract class that going to be implemented by the Concrete Abstraction
//It contains a reference to an object of type IMessageSender Interface i.e. messageSender
//and delegates all of the real work to this object (the class that implements IMessageSender Interface).
//It can also act as the base class for other abstractions.
@RequiredArgsConstructor
public abstract class AbstractMessage {

	protected final MessageSender messageSender;

	abstract void sendMessage(String message);
}
