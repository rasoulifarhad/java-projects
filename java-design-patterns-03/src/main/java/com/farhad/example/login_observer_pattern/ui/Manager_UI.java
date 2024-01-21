package com.farhad.example.login_observer_pattern.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.farhad.example.login_observer_pattern.control.Login_Controller;

public class Manager_UI extends JFrame implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JButton browseButton;
	private JButton browseOccupiedButton;
	private JButton browseAvailableButton;
	private JButton viewCancelledReservations;
	private JButton viewAllUsersButton;
	private JButton deleteUserButton;
	private JButton logOutButton;
	private JButton cancelReservation;

	private JButton makeReservation;


	private JTextField txbRoom, txbRoom1, txbRoom2;


	public void displayGUI(String username) {
		frame = new JFrame("Manager " + username + "'s menue");
		frame.setSize(300, 330);
		frame.setLocation(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout());

		panel = new JPanel();
		frame.add(panel);

		browseButton = new JButton("Browes All Rooms");
		browseButton.setBounds(10, 100, 160, 75);
		panel.add(browseButton);

		
		browseOccupiedButton = new JButton("Browse Occupied Rooms");
		browseOccupiedButton.setBounds(10, 100, 160, 75);
		panel.add(browseOccupiedButton);

		browseAvailableButton = new JButton("Browse Available Rooms");
		browseAvailableButton.setBounds(10, 140, 80, 25);
		panel.add(browseAvailableButton);

		makeReservation = new JButton("Make Reservation");
		makeReservation.setBounds(10, 120, 160, 25);
		panel.add(makeReservation);

		txbRoom = new JTextField(2);
		txbRoom.setBounds(100, 160, 160, 25);
		panel.add(txbRoom);

		cancelReservation = new JButton("Cancel Reservation");
		cancelReservation.setBounds(10, 160, 80, 25);
		panel.add(cancelReservation);

		txbRoom1 = new JTextField(2);
		txbRoom1.setBounds(100, 160, 160, 25);
		panel.add(txbRoom1);

		viewCancelledReservations = new JButton("View Cancelled Reservations");
		viewCancelledReservations.setBounds(10, 180, 160, 25);
		panel.add(viewCancelledReservations);

		viewAllUsersButton = new JButton("Browse All System Users");
		viewAllUsersButton.setBounds(10, 220, 160, 25);
		panel.add(viewAllUsersButton);

		deleteUserButton = new JButton("Delete User");
		deleteUserButton.setBounds(10, 220, 160, 25);
		panel.add(deleteUserButton);

		txbRoom2 = new JTextField(10);
		txbRoom2.setBounds(100, 70, 160, 25);
		panel.add(txbRoom2);

		logOutButton = new JButton("Log out");
		logOutButton.setBounds(10, 200, 160, 25);
		panel.add(logOutButton);

		viewAllUsersButton.addActionListener(this);
		logOutButton.addActionListener(this);
		browseButton.addActionListener(this);
		makeReservation.addActionListener(this);
		browseOccupiedButton.addActionListener(this);
		viewCancelledReservations.addActionListener(this);
		browseAvailableButton.addActionListener(this);
		cancelReservation.addActionListener(this);
		deleteUserButton.addActionListener(this);		
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	// logout
		if (e.getSource() == logOutButton) {
			Login_Controller loginController = new Login_Controller();
			frame.dispose();
		}
			// browse all rooms
		// else if (e.getSource() == browseButton) {
		// 	Room_Controller roomController = new Room_Controller();

		// 	JOptionPane.showMessageDialog(null, roomController.displayAllRooms(),
		// 			"Displaying all rooms", JOptionPane.INFORMATION_MESSAGE);

		// 	// browse available rooms
		// } else if (e.getSource() == browseAvailableButton) {
		// 	Room_Controller roomController = new Room_Controller();

		// 	JOptionPane.showMessageDialog(null, roomController.displayAvailableRooms(),
		// 			"Displaying available rooms", JOptionPane.INFORMATION_MESSAGE);

		// 	// browse occupied rooms
		// } else if (e.getSource() == browseOccupiedButton) {
		// 	Room_Controller roomController = new Room_Controller();

		// 	JOptionPane.showMessageDialog(null, roomController.displayOccupiedRooms(),
		// 			"Displaying occupied rooms", JOptionPane.INFORMATION_MESSAGE);

		// 	// make a reservation
		// } else if (e.getSource() == makeReservation) {
		// 	Room_Controller control_reservation = new Room_Controller(
		// 			Integer.valueOf(txbRoom.getText()));
		// 	control_reservation.reserveRoom();

		// 	// cancel a reservation
		// } else if (e.getSource() == cancelReservation) {
		// 	Room_Controller control_reservation = new Room_Controller(
		// 			Integer.valueOf(txbRoom1.getText()));
		// 	control_reservation.cancelReservation();

		// 	// browse cancelled reservations
		// } else if (e.getSource() == viewCancelledReservations) {
		// 	Room_Controller roomController = new Room_Controller();
		// 	JOptionPane.showMessageDialog(null, roomController.displayCancelledReservations(),
		// 			"Displaying cancelled rooms", JOptionPane.INFORMATION_MESSAGE);

		// }

		// delete a user
		else if (e.getSource() == deleteUserButton) {
			JOptionPane.showMessageDialog(null, Login_Controller.deleteUser(txbRoom2.getText()),
			"User Deleted", JOptionPane.INFORMATION_MESSAGE);
		}

		// browse all users
		else if (e.getSource() == viewAllUsersButton) {
			JOptionPane.showMessageDialog(null, Login_Controller.displayAllUsers(),
					"Displaying all users", JOptionPane.INFORMATION_MESSAGE);
		}	
	}

}
