package com.farhad.example.login_observer_pattern;

import com.farhad.example.login_observer_pattern.ui.Manager_UI;

public class Manager extends User {

	private final Manager_UI manager_UI = new Manager_UI();

	public Manager(String username, String password, String userType, boolean gui) {
		super(username, password, userType);
		if (gui) {
			manager_UI.displayGUI(username);
			System.out.println("Manager GUI launched");		
		}
	}

}
