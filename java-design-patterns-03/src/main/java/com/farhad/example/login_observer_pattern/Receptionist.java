package com.farhad.example.login_observer_pattern;

import com.farhad.example.login_observer_pattern.ui.Receptionist_UI;

public class Receptionist extends User{

	private final Receptionist_UI receptionist_UI = new Receptionist_UI();


	
	public Receptionist(String username, String password, String userType, boolean gui1) {
		super(username, password, userType);
		if (gui1) {
			receptionist_UI.displayGUI(username);
			System.out.println("Receptionist GUI launched");			
		}
	}

}
