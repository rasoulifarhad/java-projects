package com.farhad.example.composition_inheritance.step1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService extends AbstractService<User> {

	private final UserRepository userRepository;

	@Override
	public User save(User user) {
		user.setId(generateId());
		return userRepository.save(user);
	}
	
}
