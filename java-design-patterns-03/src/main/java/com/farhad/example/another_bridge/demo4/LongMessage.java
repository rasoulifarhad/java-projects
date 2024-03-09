package com.farhad.example.another_bridge.demo4;

public class LongMessage extends AbstractMessage {

	public LongMessage(MessageSender messageSender) {
		super(messageSender);
	}

	@Override
	void sendMessage(String message) {
		// System.out.print("Long message -- ");
		messageSender.sendMessage(message);
	}

}
