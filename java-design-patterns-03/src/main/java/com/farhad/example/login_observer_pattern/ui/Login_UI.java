package com.farhad.example.login_observer_pattern.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.farhad.example.login_observer_pattern.UserFactory;
import com.farhad.example.login_observer_pattern.control.Login_Controller;

public class Login_UI extends JFrame implements ActionListener {

	private static JFrame frame;
	private static JTextField userText;
	private static JPasswordField passwordField;
	private static JButton loginButton, registerButton;
	private String username, password;
	private NewUser_UI newUser_UI = new NewUser_UI();

	public Login_UI() {

	}
	
	public Login_UI(String username, String password) {
		if(username == null || username.equalsIgnoreCase("")
				|| password == null || password.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null,
					"Error: You Must Enter ALL Details\\nPlease try again!",
					"Login Failed",
						  JOptionPane.ERROR_MESSAGE);		
		} else {

			JOptionPane.showMessageDialog(null,
					"Error: User Does Not Exist\\nPlease Register or try again!",
					"Login Failed",
					JOptionPane.ERROR_MESSAGE);
		}
	}


	public void displayGUI() {
		frame = new JFrame("Hotel login panel");
		frame.setSize(300, 150);
		frame.setLocation(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}


	private void placeComponents(JPanel panel) {
		panel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setBounds(10, 40, 80, 25);

		passwordField = new JPasswordField(20);
		passwordField.setBounds(100, 40, 160, 25);
		panel.add(passwordField);

		loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);

		registerButton = new JButton("register");
		registerButton.setBounds(180, 80, 80, 25);
		panel.add(registerButton);
		
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == loginButton) {
			char[] input = passwordField.getPassword();
			password = new String(input);
			username = userText.getText();
			frame.dispose();

			Login_Controller login_controller;
			login_controller = new Login_Controller(username, password);
			login_controller.login();

		} else if (e.getSource() == registerButton) {
			UserFactory userFactory = new UserFactory();
			userFactory.createUser(username, password, "NewUser", true);
			newUser_UI.displayGUI("NewUser");
			frame.dispose();
		}
	}


}
