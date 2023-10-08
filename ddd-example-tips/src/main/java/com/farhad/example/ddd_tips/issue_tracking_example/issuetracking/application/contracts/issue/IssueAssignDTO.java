package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.issue;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.issue.Issue;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.user.User;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class IssueAssignDTO {

	private final User.UserId userId;
	private final Issue.IssueId issueId;
	
}
