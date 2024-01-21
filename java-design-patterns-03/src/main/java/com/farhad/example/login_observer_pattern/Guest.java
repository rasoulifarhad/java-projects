package com.farhad.example.login_observer_pattern;

import com.farhad.example.login_observer_pattern.ui.Guest_UI;

public class Guest extends User{

	private final Guest_UI guest_UI = new Guest_UI();

	public Guest(String username, String password, String userType, boolean gui) {
		super(username, password, userType);
		if (gui) {
			guest_UI.displayGUI(username);		
		}
	}

	public Guest(String username, String password, String userType,
			String passportNo, String address, String telephone, boolean gui) {
		super(username, password, userType, passportNo, address, telephone);
		if (gui) {
			guest_UI.displayGUI(username);
			System.out.println("Guest GUI launched");			
		}
	}

}
