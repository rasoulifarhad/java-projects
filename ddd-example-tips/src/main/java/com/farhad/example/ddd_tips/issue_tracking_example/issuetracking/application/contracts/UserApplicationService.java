package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts;

public interface UserApplicationService {
	
	void create(UserDTO input);
	void update(UserDTO input);
	void changePassword(UserDTO input);
}
