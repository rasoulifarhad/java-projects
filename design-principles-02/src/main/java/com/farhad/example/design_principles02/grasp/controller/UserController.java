package com.farhad.example.design_principles02.grasp.controller;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	public void register(String username, String password) {
		userService.register(username, password);
	}

	public boolean login(String username, String password) {
		return userService.login(username, password);
	}
}
