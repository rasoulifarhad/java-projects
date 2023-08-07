package com.farhad.example.designpatterns.intro.senderreceiverDemo.sender;

public class Sender {
	
	private Receiver receiver;

	public Sender(Receiver receiver) {
		this.receiver = receiver;
	}

	public void doSomething() {
		receiver.receiveThis();
	}

	public interface Receiver {
		public void receiveThis();
	}	
}
