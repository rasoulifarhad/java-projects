package com.farhad.example.composite_bridge;

public class App {

	public static void main(String[] args) {
		
		Logger fileLogger = new FileLogger();
		Logger dbLogger = new DbLogger();

		ApplicationLogger appLogger = new ApplicationLogger();
		appLogger.addLogger(fileLogger);
		appLogger.addLogger(dbLogger);

		appLogger.log(new MyException());
	}
}
