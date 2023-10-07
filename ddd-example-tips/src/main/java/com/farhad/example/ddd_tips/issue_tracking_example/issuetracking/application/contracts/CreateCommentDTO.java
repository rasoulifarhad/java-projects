package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts;

import lombok.Value;

@Value
public class CreateCommentDTO {
	
	private String issueId;
	private String text;
}
