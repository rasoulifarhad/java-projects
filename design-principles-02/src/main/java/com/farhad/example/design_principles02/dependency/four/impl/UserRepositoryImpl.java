package com.farhad.example.design_principles02.dependency.four.impl;

import java.util.UUID;

import com.farhad.example.design_principles02.dependency.four.User;
import com.farhad.example.design_principles02.dependency.four.UserRepository;

public class UserRepositoryImpl implements UserRepository{
	
	@Override
	public User findById(UUID userId) {
		return null;
	}

}
