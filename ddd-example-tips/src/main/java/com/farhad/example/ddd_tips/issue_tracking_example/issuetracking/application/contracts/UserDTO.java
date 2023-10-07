package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts;

import java.time.Instant;

import lombok.Data;

@Data
public class UserDTO {

	private String uuid;
	private String username;
	private String email;
	private String password;
	private Instant creationDate;
}
