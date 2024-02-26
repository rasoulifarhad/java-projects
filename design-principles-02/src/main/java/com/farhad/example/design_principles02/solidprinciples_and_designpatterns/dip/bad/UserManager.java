package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.dip.bad;

import java.time.Instant;

public class UserManager {

	public void changePassword(String usernamne, String oldPassword, String newPassword) {
		// change password
		EmailNotifier notifier = new EmailNotifier(); 	
		notifier.notifier("Password was changed on " + Instant.now());
	}
}
