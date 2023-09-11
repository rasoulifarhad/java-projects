package com.farhad.example.composition_inheritance.step4;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService implements Service<User> {

	private final UserRepository userRepository;
	private final KeyGenerator keyGenerator;
	
	@Override
	public User save(User user) {
		user.setId(keyGenerator.generateId());
		return userRepository.save(user);
	}
	
}
