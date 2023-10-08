package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.issue;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class IssueCreationDTO {

	private String title;
	private String text;
	private String gitRepositoryId;
	private String assignedUserId;
	
}
