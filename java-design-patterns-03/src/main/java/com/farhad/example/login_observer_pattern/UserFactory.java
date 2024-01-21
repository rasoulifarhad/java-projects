package com.farhad.example.login_observer_pattern;


public class UserFactory {

	public User createUser(String username, String password, String userType, boolean gui) {
		if (userType == null) {
			return null;
		}

		if (userType.equalsIgnoreCase("Guest")) {
			return new Guest(username, password, userType, gui);
		} else if (userType.equalsIgnoreCase("Manager")) {
			return new Manager(username, password, userType, gui);
		} else if (userType.equalsIgnoreCase("Receptionist")) {
			return new Receptionist(username, password, userType, gui);
		} else if (userType.equalsIgnoreCase("NewUser")) {
			return new NewUser("NewUser");
		}
		return null;
		
	}
}
