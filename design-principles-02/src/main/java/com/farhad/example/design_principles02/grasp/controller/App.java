package com.farhad.example.design_principles02.grasp.controller;

public class App {

	public static void main(String[] args) {
		
		UserService userService = new UserService();
		UserController userController = new UserController(userService);

		userController.register("username1", "password1");

		boolean isAuthenticated = userController.login("username1", "password1");
		System.out.println("Is authenticated:" + isAuthenticated);
	}
}
