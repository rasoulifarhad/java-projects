package com.farhad.example.login_observer_pattern;

import javax.swing.JOptionPane;

import com.farhad.example.login_observer_pattern.control.Login_Controller;

public class NewUser extends User{

	public NewUser(String string) {
		super();
	}

	public NewUser(String username, String password, String userType,
			String passportNo, String address, String telephone) {

		UserFactory userFactory = new UserFactory();
		Login_Controller login_controller = new Login_Controller(true);

		if(userType.equalsIgnoreCase("Guest")) {
			Guest guest = (Guest) userFactory.createUser(username, password, userType, false);
			guest.setPassportNo(passportNo);
			guest.setAddress(address);
			guest.setTelephone(telephone);
			login_controller.addUser(guest);
			System.out.println("New Guest added");

		} else if(userType.equalsIgnoreCase("Receptionist")) {
			Receptionist receptionist = (Receptionist) userFactory.createUser(username, password, userType, false);
			receptionist.setPassportNo(passportNo);
			receptionist.setAddress(address);
			receptionist.setTelephone(telephone);
			login_controller.addUser(receptionist);
			System.out.println("New Receptionist added");

		} else if (userType.equalsIgnoreCase("Manager")) {
			Manager manager = (Manager) userFactory.createUser(username, password, userType, false);
			manager.setPassportNo(passportNo);
			manager.setAddress(address);
			manager.setTelephone(telephone);
			login_controller.addUser(manager);
			System.out.println("New Manager added");

		}
		
		JOptionPane.showMessageDialog(null, username + " registered as " + userType, null, 1);

		JOptionPane.showMessageDialog(null, "jim 123 = Manager"
				+ "\npat 456 = Receptionist"
				+ "\njoe 789 = Guest", null, 1);
	}

}
