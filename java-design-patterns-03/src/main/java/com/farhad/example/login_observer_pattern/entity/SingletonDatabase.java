package com.farhad.example.login_observer_pattern.entity;

import java.util.ArrayList;
import java.util.List;

import com.farhad.example.login_observer_pattern.Guest;
import com.farhad.example.login_observer_pattern.Manager;
import com.farhad.example.login_observer_pattern.User;
import com.farhad.example.login_observer_pattern.room.Room;

public class SingletonDatabase {

	private static SingletonDatabase instance;
	private static List<User> registeredUsers = new ArrayList<>();

	private SingletonDatabase() {
		registeredUsers.add(new Manager("jim", "123", "Manager", false));
		registeredUsers.add(new Manager("pat", "456", "Receptionist", false));
		registeredUsers.add(new Guest("joe", "789", "Guest", "123456", "limerick", "(087)789654", false));
	}

	public static SingletonDatabase getInstance() {
		if (instance == null) {
			instance = new SingletonDatabase();
			System.out.println("Singleton database instanced");
		}
		return instance;
	}

	public List<User> getRegisteredUsers() {
		return registeredUsers;
	}

	public User searchUser(String username) {
		return registeredUsers.stream()
			.filter(user -> user.getUsername().equals(username))
			.findAny()
				.orElse(null);
	}

	public boolean deleteUser(String username) {
		User findedUser = registeredUsers.stream()
				.filter(user -> user.getUsername().equals(username))
				.findFirst()
				.orElse(null);
		if (findedUser != null) {
			registeredUsers.remove(findedUser);
		}

		return findedUser != null;
	}

	public List<Room> getRooms() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getRooms'");
	}

	public Room searchRooms(int roomNumber) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'searchRooms'");
	}
}
