package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.dip.good;

import java.time.Instant;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserManager {

	private final Notifier notifier;

	public void changePassword(String usernamne, String oldPassword, String newPassword) {
		// change password
		notifier.notifier("Password was changed on " + Instant.now());
	}

}
