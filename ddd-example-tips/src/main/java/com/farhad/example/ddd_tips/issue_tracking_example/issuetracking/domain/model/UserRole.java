package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.ValueObject;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class UserRole implements ValueObject {
	
	private User.UserId userId;
	private Role.RoleId roleId;

	
}
