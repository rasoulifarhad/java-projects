package com.farhad.example.functional_interface.design_patterns.command_pattern.standard_oop;

public class Invoker {

	private Command command;

	public void register(Command command) {
		this.command = command;
	}

	public void request() {
		command.execute();
	}
}
