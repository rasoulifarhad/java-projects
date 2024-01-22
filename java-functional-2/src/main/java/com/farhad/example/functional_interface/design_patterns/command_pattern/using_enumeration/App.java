package com.farhad.example.functional_interface.design_patterns.command_pattern.using_enumeration;

public class App {

	public static void main(String[] args) {
		
		Receiver receiver1 = new Receiver();
		Receiver receiver2 = new Receiver();

		Invoker invoker = new Invoker();

		invoker.register(Command.COMMANDA, receiver1);
		invoker.request();

		invoker.register(Command.COMMANDB, receiver2);
		invoker.request();

		invoker.register(Command.COMMANDB, receiver1);
	}
}
