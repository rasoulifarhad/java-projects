package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts;

public interface UserApplicationService {
	
	void create(UserCreationDTO input);
	void update(UserUpdateDTO input);
	void changePassword(UserChangePasswordDTO input);
}
