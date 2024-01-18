package com.farhad.example.composite_bridge;

public class FileLogger implements  Logger {

	@Override
	public void log(MyException exception) {
		System.out.println("FileLogger");
	}

}
