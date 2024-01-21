package com.farhad.example.login_observer_pattern.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.farhad.example.login_observer_pattern.NewUser;
import com.farhad.example.login_observer_pattern.control.Login_Controller;

public class NewUser_UI extends JFrame implements ActionListener {

	private JTextField addressText;
	private JTextField telephoneText;
	private JTextField passportText;
	private JTextField userText;
	private JPasswordField passwordField;
	private JButton registerButton;
	private JFrame frame;
	private JButton backButton;
	private JCheckBox cbxManager;
	private JCheckBox cbxGuest;
	private JCheckBox cbxReceptionist;
	private JPanel panel;

	public void displayGUI(String username) {
	frame = new JFrame(username + "'s Menu");
		frame.setSize(250, 230);
		frame.setLocation(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout());

		panel = new JPanel();
		frame.add(panel);

		JLabel userLabel = new JLabel("User Name");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(10);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordField = new JPasswordField(10);
		passwordField.setBounds(100, 40, 160, 25);
		panel.add(passwordField);

		JLabel addressLabel = new JLabel("Address");
		userLabel.setBounds(10, 70, 80, 25);
		panel.add(addressLabel);

		addressText = new JTextField(10);
		addressText.setBounds(100, 70, 160, 25);
		panel.add(addressText);

		JLabel telephoneLabel = new JLabel("Telephone");
		telephoneLabel.setBounds(10, 100, 80, 25);
		panel.add(telephoneLabel);

		telephoneText = new JTextField(10);
		telephoneText.setBounds(100, 100, 160, 25);
		panel.add(telephoneText);

		JLabel passportLabel = new JLabel("Passport Number");
		passportLabel.setBounds(10, 130, 80, 25);
		panel.add(passportLabel);

		passportText = new JTextField(10);
		passportText.setBounds(100, 130, 160, 25);
		panel.add(passportText);

		JLabel m = new JLabel("Manager");
		panel.add(m);
		cbxManager = new JCheckBox();
		panel.add(cbxManager);

		JLabel g = new JLabel("Guest");
		panel.add(g);
		cbxGuest = new JCheckBox();
		panel.add(cbxGuest);

		JLabel r = new JLabel("Recept.");
		panel.add(r);
		cbxReceptionist = new JCheckBox();
		panel.add(cbxReceptionist);

		backButton = new JButton("Go back");
		backButton.setBounds(10, 160, 160, 25);
		panel.add(backButton);

		registerButton = new JButton("Register");
		registerButton.setBounds(10, 160, 80, 25);
		panel.add(registerButton);

		backButton.addActionListener(this);
		registerButton.addActionListener(this);

		frame.setVisible(true);	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == registerButton) {
			String username = userText.getText();
			String passport = passportText.getText();

			String address = addressText.getText();
			String telephone = telephoneText.getText();
			String password = passwordField.toString();

			String userType;
			if (cbxGuest.isSelected()) {
				userType = "Guest";

			} else if (cbxReceptionist.isSelected()) {
				userType = "Receptionist";

			} else if (cbxManager.isSelected()) {
				userType = "Manager";

			} else {
				userType = "";
			}


			if ((!address.equalsIgnoreCase("")
					&& (!telephone.equalsIgnoreCase(""))
					&& (!passport.equalsIgnoreCase(""))
					&& (!username.equalsIgnoreCase(""))
					&& (!password.equalsIgnoreCase(""))
					&& (!userType.equalsIgnoreCase("")))) {

				NewUser newUser_ = new NewUser(username, password, userType, address, passport, telephone);
				Login_Controller login = new Login_Controller();
				frame.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "You must enter all fields..", "Try Again",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == backButton) {
			Login_Controller login = new Login_Controller();
			frame.dispose();
		}
	}


}
