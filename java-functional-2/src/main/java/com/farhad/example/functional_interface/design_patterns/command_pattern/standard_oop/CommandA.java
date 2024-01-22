package com.farhad.example.functional_interface.design_patterns.command_pattern.standard_oop;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandA implements Command {

	private final Receiver receiver;

	@Override
	public void execute() {
		receiver.action1();
	}
}
