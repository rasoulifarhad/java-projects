package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.Issue;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.User;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class IssueAssignDTO {

	private final User.UserId userId;
	private final Issue.IssueId issueId;
	
}
