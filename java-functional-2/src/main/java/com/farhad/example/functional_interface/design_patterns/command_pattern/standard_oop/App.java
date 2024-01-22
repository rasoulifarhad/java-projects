package com.farhad.example.functional_interface.design_patterns.command_pattern.standard_oop;

public class App {

	public static void main(String[] args) {
		
		Receiver receiver1 = new Receiver();
		Receiver receiver2 = new Receiver();

		Invoker invoker = new Invoker();
		invoker.register(new CommandA(receiver1));
		invoker.request();

		invoker.register(new CommandB(receiver2));
		invoker.request();

		invoker.register(new CommandA(receiver2));
		invoker.request();
	}
}
