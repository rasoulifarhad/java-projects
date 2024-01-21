package com.farhad.example.login_observer_pattern;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

public class LoginRecord implements Observer {

	private static final String NEW_LINE = System.lineSeparator();
	@Override
	public void update(Subject subject) {

		String userName = subject.getUserName();
		String userType = subject.getUserType();
		Instant loginTime = subject.getLoginDate();
		try {
			Path path = Paths.get(System.getProperty("user.dir"), "/src/loginAttempts.txt");
			if (!Files.exists(path)) {
				path = Files.createFile(path);
			}
			writeFile(userName, userType, loginTime, path);
			System.out.println("Login Attempt Observed\nRecorded to " + path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void writeFile(String userName, String userType, Instant loginTime, Path path) throws IOException {
		String content = userName + " " + userType + " " + loginTime + NEW_LINE;
		Files.write(path, content.getBytes(StandardCharsets.UTF_8));
	}

}
