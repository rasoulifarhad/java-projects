package com.farhad.example.design_principles02.grasp.indirection;

import java.util.List;

// In a notification system, a NotificationService class can be introduced to send notifications via 
// different channels, like email or SMS, without directly coupling the sender and receiver classes.
public class NotificationService {

	private List<NotificationChannel> channels;

	public void sendNotification(String message) {
		channels.forEach(n -> n.sendNotification(message));
	}
}
