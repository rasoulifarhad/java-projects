package com.farhad.example.design_principles02.dependency.four;

import java.util.UUID;

public class AccountController {
	
	private final SecurityService securityService;

	public AccountController(SecurityService securityService) {
		this.securityService = securityService;
	}

	// [Http Post]
	public void changePassword(UUID userId, String newPassword ) {
		securityService.changePassword(userId, newPassword);
	}

	
}
