package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.user.User.UserId;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class CurrentUser {
	
	public static final CurrentUser USER_1 = CurrentUser.from("user_1");
	private final UserId userId;

	public static CurrentUser from(String userId) {
		return new CurrentUser(UserId.from(userId));
	}
}
