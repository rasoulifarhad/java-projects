package com.farhad.example.code_smell.middle_man.better;

public class Client {

	public static void main(String[] args) {
		
		NotificationService notificationService = new NotificationService();
		User user = new User("user #1");

		notificationService.sendNotification(user, "Hello!");
	}
}
