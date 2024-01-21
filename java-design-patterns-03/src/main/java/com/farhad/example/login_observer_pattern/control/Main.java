package com.farhad.example.login_observer_pattern.control;

import javax.swing.JOptionPane;

import com.farhad.example.login_observer_pattern.ui.Login_UI;

// UseCases: 
//
// - Delete User
// - Browse All System Users
// - Browse All Rooms
// - Browse Occupied Rooms
// - Browse Available Rooms
// - Make Reservation
// - Cancel Reservation
// - View Cancelled Reservation
// - login
// - Register
//
// Actors:
//
// - Manager
// - New User
// - Guest
// - Receptionist 
public class Main {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "jim 123 = Manager"
				+ "\npat 456 = Receptionist"
				+ "\njoe 789 = Guest", null, 1);

		Login_UI loginBox = new Login_UI();
		loginBox.displayGUI();
	}
}
