package com.farhad.example.composite_bridge;

import java.util.ArrayList;
import java.util.List;

public class ApplicationLogger {

	private List<Logger> loggers;

	public ApplicationLogger() {
		loggers = new ArrayList<>();
	}

	public void addLogger(Logger logger) {
		loggers.add(logger);
	}

	public void log(MyException exception) {
		loggers.forEach(logger -> logger.log(exception));
	}
	
}
