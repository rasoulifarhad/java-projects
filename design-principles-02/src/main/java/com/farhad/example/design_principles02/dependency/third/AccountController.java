package com.farhad.example.design_principles02.dependency.third;

import java.util.UUID;

import com.farhad.example.design_principles02.dependency.third.impl.SecurityServiceImpl;

public class AccountController {
	
	private final SecurityService securityService;

	public AccountController() {
		securityService = new SecurityServiceImpl();
	}

	// [Http Post]
	public void changePassword(UUID userId, String newPassword ) {
		securityService.changePassword(userId, newPassword);
	}

	
}
