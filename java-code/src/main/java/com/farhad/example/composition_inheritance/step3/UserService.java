package com.farhad.example.composition_inheritance.step3;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService extends AbstractService<User> {

	private final UserRepository userRepository;

	@Override
	public String generateId() {
		return getId() + "+User";
	}

	String getId() {
		return super.generateId();
	}


	@Override
	public User save(User user) {
		user.setId(generateId());
		return userRepository.save(user);
	}
	
}
