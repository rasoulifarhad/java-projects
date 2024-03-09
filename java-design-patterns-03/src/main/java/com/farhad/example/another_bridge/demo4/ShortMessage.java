package com.farhad.example.another_bridge.demo4;

// This is going to be a concrete class which inherits from the Abstraction class i.e. AbstractMessage. 
// This Concrete Abstraction Class implements the operations defined by AbstractMessage class.
public class ShortMessage extends AbstractMessage {

	public ShortMessage(MessageSender messageSender) {
		super(messageSender);
	}

	@Override
	void sendMessage(String message) {
		if (message.length() <= 10) {
			// System.out.print("Short message -- ");
			messageSender.sendMessage(message);
		} else {
			System.out.println("Unable to send the message as length > 10 characters");
		}
	}

}
