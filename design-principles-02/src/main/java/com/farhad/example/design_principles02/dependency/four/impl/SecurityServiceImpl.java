package com.farhad.example.design_principles02.dependency.four.impl;

import java.util.Objects;
import java.util.UUID;

import com.farhad.example.design_principles02.dependency.four.SecurityService;
import com.farhad.example.design_principles02.dependency.four.User;
import com.farhad.example.design_principles02.dependency.four.UserRepository;


public class SecurityServiceImpl implements SecurityService{
	
	private final UserRepository userRepository;

	public SecurityServiceImpl(UserRepository userRepository) {
		Objects.requireNonNull(userRepository);
		this.userRepository = userRepository;
	}

	@Override
	public void changePassword(UUID userId, String newPassword) {
		User user = userRepository.findById(userId);
		user.changePassword(newPassword);
	}

}
