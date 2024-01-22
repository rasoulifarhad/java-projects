package com.farhad.example.functional_interface.design_patterns.command_pattern.using_enumeration;

public class Invoker {

	private Command command;
	private Receiver receiver;

	public void register(Command command, Receiver receiver) {
		this.command = command;
		this.receiver = receiver;
	}
	public void request() {
		command.execute(receiver);
	}
}
