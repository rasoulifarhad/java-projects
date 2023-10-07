package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts;

import lombok.Data;

@Data
public class UserCreationDTO {

	private String username;
	private String email;
	private String password;
}
