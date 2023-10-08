package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.user.User.UserId;

public interface PaymentService {

	void charge(UserId userId, double organizationPrice);
	
}
