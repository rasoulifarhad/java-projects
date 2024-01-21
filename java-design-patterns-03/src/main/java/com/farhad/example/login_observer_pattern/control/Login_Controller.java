package com.farhad.example.login_observer_pattern.control;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import com.farhad.example.login_observer_pattern.Guest;
import com.farhad.example.login_observer_pattern.LoginRecord;
import com.farhad.example.login_observer_pattern.Manager;
import com.farhad.example.login_observer_pattern.Observer;
import com.farhad.example.login_observer_pattern.Receptionist;
import com.farhad.example.login_observer_pattern.Subject;
import com.farhad.example.login_observer_pattern.User;
import com.farhad.example.login_observer_pattern.UserFactory;
import com.farhad.example.login_observer_pattern.entity.SingletonDatabase;
import com.farhad.example.login_observer_pattern.ui.Login_UI;

public class Login_Controller implements Subject {

	private static User user;
	private String username;
	private String password;
	private String userType;

	private Instant loginDate;

	private static SingletonDatabase singletonDatabase = SingletonDatabase.getInstance();
	private List<Observer> observers;

	public Login_Controller() {
		Login_UI login_UI = new Login_UI();
		login_UI.displayGUI();
		
	}
	
	public Login_Controller(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Login_Controller(boolean newUser) {
	}

	public void login() {
		observers = new ArrayList<>();
		LoginRecord loginRecord = new LoginRecord();
		registerObserver(loginRecord);

		user = singletonDatabase.searchUser(username);
		if (user != null) {
			String dbPassword = user.getPassword();
			if (password != null && dbPassword.equals(password)) {
				UserFactory userFactory = new UserFactory();
				if (user instanceof Guest) {
					userType = "Guest";
					// Guest guestUsecase = (Guest) userFactory.createUser(dbPassword, dbPassword, dbPassword);
					Guest guestUsecase = (Guest) userFactory.createUser(dbPassword, dbPassword, dbPassword, true);
				} else if (user instanceof Receptionist) {
					userType = "Receptionist";
					// Receptionist receptionistUsecase = (Receptionist) userFactory.createUser(dbPassword, dbPassword, dbPassword);
					Receptionist receptionistUsecase = (Receptionist) userFactory.createUser(dbPassword, dbPassword, dbPassword, true);
				} else if (user instanceof Manager) {
					userType = "Manager";
					// Manager managerUsecase = (Manager) userFactory.createUser(dbPassword, dbPassword, dbPassword);
					Manager managerUsecase = (Manager) userFactory.createUser(dbPassword, dbPassword, dbPassword, true);
				}
				
				loginDate = Instant.now();
				notifyAllObservers(username, password, loginDate);
			}
		} else {
			Login_UI login_UI = new Login_UI(username, password);
			login_UI.displayGUI();
		}
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void notifyAllObservers(String userName, String userType, Instant time) {
		observers.forEach(observer -> observer.update(this));
	}

	public static User getUser() {
		return user;
	}
	
	public static String deleteUser(String username) {
		boolean deleted = singletonDatabase.deleteUser(username);

		return deleted ? username + " deleted" : username + " not deleted";
	}

	public static String displayAllUsers() {
		return singletonDatabase.getRegisteredUsers().stream()
			.map(Login_Controller::displayUser)
			.collect(Collectors.joining("\n\n"));
	}

	private static String displayUser(User user) {
		StringJoiner stringJoiner = new StringJoiner("\n", "\n", "");
		stringJoiner.add(user.getUsername()).add(user.getPassword()).add(user.getUserType());
		return stringJoiner.toString();
	}

	@Override
	public String getUserName() {
		return username;
	}

	@Override
	public String getUserType() {
		return userType;
	}

	@Override
	public Instant getLoginDate() {
		return loginDate;
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addUser'");
	}

}
