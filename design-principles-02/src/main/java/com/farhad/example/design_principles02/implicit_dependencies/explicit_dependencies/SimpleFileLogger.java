package com.farhad.example.design_principles02.implicit_dependencies.explicit_dependencies;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleFileLogger implements Logger {

	@Override
	public void log(String message) throws IOException {
		String logFileStr = System.getProperty("log.file", "logfile2.txt");
		Path path = Paths.get(logFileStr);
		Files.deleteIfExists(path);
		Files.createFile(path);
		Files.write(path, message.getBytes());
	}

}
