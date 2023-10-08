package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.service;

public interface EmailSender {

	void send(String to, String subject, String body);
	
}
