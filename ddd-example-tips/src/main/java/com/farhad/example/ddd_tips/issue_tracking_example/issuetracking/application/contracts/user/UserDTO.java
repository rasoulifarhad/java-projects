package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.user;

import java.time.Instant;
import java.util.List;

import lombok.Data;

@Data
public class UserDTO {

	private String uuid;
	private String username;
	private String email;
	private Instant creationDate;
	private List<String> roles;

}
