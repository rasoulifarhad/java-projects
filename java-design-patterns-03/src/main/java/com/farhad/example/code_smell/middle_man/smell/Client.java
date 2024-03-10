package com.farhad.example.code_smell.middle_man.smell;

public class Client {

	public static void main(String[] args) {
		
		NotificationService notificationService = new NotificationService();
		Messenger messenger = new Messenger(notificationService);
		User user = new User("user #1");

		messenger.sendMessage(user, "Hello!");
	}
}
