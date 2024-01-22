package com.farhad.example.functional_interface.design_patterns.command_pattern.using_functional_interfaces;

public class App {

	public static void main(String[] args) {
		
		Receiver receiver1 = new Receiver();
		Receiver receiver2 = new Receiver();

		Invoker invoker = new Invoker();
		invoker.register(receiver1::action1);
		invoker.execute();

		invoker.register(receiver2::action2);
		invoker.execute();

		invoker.register(receiver2::action1);
		invoker.execute();
	}
}
