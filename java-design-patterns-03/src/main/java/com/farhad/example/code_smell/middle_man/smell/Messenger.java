package com.farhad.example.code_smell.middle_man.smell;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Messenger {

	private final NotificationService notificationService;

	public void sendMessage(User user, String message) {
		notificationService.sendNotification(user, message);
	}
}
