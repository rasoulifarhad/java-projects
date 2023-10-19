package com.farhad.example.design_principles02.dependency.second;

import java.util.UUID;

public class SecurityService {

	private final UserRepository userRepository;

	public SecurityService() {
		userRepository = new UserRepository();
	}

	public void changePassword(UUID userId, String newPassword) {
		User user = userRepository.findById(userId);
		user.changePassword(newPassword);
	}
	
}
