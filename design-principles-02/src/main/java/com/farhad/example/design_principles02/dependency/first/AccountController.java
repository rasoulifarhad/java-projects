package com.farhad.example.design_principles02.dependency.first;

import java.util.UUID;

import com.farhad.example.design_principles02.dependency.User;

public class AccountController {
	
	private final SecurityService securityService;

	public AccountController() {
		securityService = new SecurityService();
	}

	// [Http Post]
	public void changePassword(UUID userId, String newPassword ) {
		UserRepository userRepository = new UserRepository();
		User user = userRepository.findById(userId);
		securityService.changePassword(user, newPassword);
	}

	
}
