package com.farhad.example.designpatterns.intro.senderreceiverDemo.receiver;

import com.farhad.example.designpatterns.intro.senderreceiverDemo.sender.Sender.Receiver;

public class SpecificReceiver  implements Receiver {

	@Override
	public void receiveThis() {
		System.out.println("Doing something......");
	}
	
}
