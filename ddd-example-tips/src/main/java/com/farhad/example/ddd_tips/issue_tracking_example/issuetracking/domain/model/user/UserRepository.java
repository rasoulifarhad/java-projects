package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.user;

import java.util.Optional;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.user.User.UserId;

public interface UserRepository {

	Optional<User> findById(UserId userId);
	
}
