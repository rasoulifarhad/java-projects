package com.farhad.example.design_principles02.dependency.third.impl;

import java.util.UUID;

import com.farhad.example.design_principles02.dependency.third.SecurityService;
import com.farhad.example.design_principles02.dependency.third.User;
import com.farhad.example.design_principles02.dependency.third.UserRepository;


public class SecurityServiceImpl implements SecurityService{
	
	private final UserRepository userRepository;

	public SecurityServiceImpl() {
		userRepository = new UserRepository();
	}

	@Override
	public void changePassword(UUID userId, String newPassword) {
		User user = userRepository.findById(userId);
		user.changePassword(newPassword);
	}

}
