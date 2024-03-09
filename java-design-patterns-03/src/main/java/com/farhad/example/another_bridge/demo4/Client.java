package com.farhad.example.another_bridge.demo4;

public class Client {

	enum MessageType {
		Short, Long
	}
	// Except for the initialization phase, where an Abstraction object i.e.
	// LongMessage or ShortMessage
	// linked with a specific Implementation object i.e. new EmailMessageSender() or
	// new SmsMessageSender(),
	// the client code should only depend on the Abstraction class i.e.
	// AbstractMessage
	public static void main(String[] args) {
		AbstractMessage abstractMessage = createMesssage(MessageType.Long);
		abstractMessage.sendMessage("long messageeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee!");

		abstractMessage = createMesssage(MessageType.Short);
		abstractMessage.sendMessage("short msg!");
	}
	
	private static AbstractMessage createMesssage(MessageType messageType) {

		if(messageType.equals(MessageType.Short)) {
			return createShortMessage();
		} else {
			return createLongMessage();
		}
	}
	
	private static AbstractMessage createLongMessage() {
		return new LongMessage(new EmailMessageSender());
	}

	private static AbstractMessage createShortMessage() {
		return new ShortMessage(new SmsMessageSender());
	}
}
