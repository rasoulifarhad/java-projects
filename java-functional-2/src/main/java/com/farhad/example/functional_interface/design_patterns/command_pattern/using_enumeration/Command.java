package com.farhad.example.functional_interface.design_patterns.command_pattern.using_enumeration;

public enum Command {

	COMMANDA {
		@Override
		public void execute(Receiver receiver) {
			receiver.action1();
		}
	},
	COMMANDB {
		@Override
		public void execute(Receiver receiver) {
			receiver.action2();
		}
	};
	public abstract void execute(Receiver receiver);
}
