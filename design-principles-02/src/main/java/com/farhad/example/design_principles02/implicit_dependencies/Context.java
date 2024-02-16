package com.farhad.example.design_principles02.implicit_dependencies;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Context {

	@Getter
	@Setter
	private static Customer currentCustomer;

	public static void log(String message) throws IOException {
		String logFileStr = System.getProperty("log.file", "logfile.txt");
		Path path = Paths.get(logFileStr);
		Files.deleteIfExists(path);
		Files.createFile(path);
		Files.write(path, message.getBytes());
	}

}
