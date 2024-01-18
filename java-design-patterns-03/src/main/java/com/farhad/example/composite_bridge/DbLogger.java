package com.farhad.example.composite_bridge;

public class DbLogger implements Logger {

	@Override
	public void log(MyException exception) {
		System.out.println("DbLogger");
	}

}
