package com.farhad.example.design_principles02.dependency.four;

import java.util.UUID;

public interface UserRepository {

	public User findById(UUID userId);
	
}
