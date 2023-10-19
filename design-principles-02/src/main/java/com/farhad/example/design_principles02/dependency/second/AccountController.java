package com.farhad.example.design_principles02.dependency.second;

import java.util.UUID;

public class AccountController {
	
	private final SecurityService securityService;

	public AccountController() {
		securityService = new SecurityService();
	}

	// [Http Post]
	public void changePassword(UUID userId, String newPassword ) {
		securityService.changePassword(userId, newPassword);
	}

	
}
