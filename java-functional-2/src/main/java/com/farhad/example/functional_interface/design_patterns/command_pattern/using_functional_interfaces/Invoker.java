package com.farhad.example.functional_interface.design_patterns.command_pattern.using_functional_interfaces;

public class Invoker {

	private Command command;

	public void register(Command command) {
		this.command = command;
	}

	public void execute() {
		command.execute();
	}
}
